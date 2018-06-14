/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import model.POJOs.Actividades;
import model.POJOs.Asignaturas;
import model.POJOs.Entrega;
import model.POJOs.Profesores;
import model.POJOs.Usuario;
import static model.dao.DAOImpl.*;
import static org.apache.commons.lang3.StringUtils.stripAccents;
import static org.apache.struts2.ServletActionContext.getServletContext;

/**
 *
 * @author Portatil
 */
public class ActividadActions extends ActionSupport {

    private Actividades current;

    private Entrega entrega;

    private String actividadId;

    private List<Actividades> all;

    private String asignaturaId;

    private String notaActividad;

    private String tipoActividad;

    private String nombreActividad;

    private String fechaActividad;

    private String pasada;

    public ActividadActions() {
    }

    public String execute() throws Exception {
        Map session = (Map) ActionContext.getContext().get("session");
        Usuario alumno = (Usuario) session.get("usuario");

        current = findActividad(actividadId);

        entrega = getEntregaAlumnoActividad(current.getActividadId().toString(), alumno.getIdUsuario().toString());

        if (current.getFechaFin().before(new Date())) {
            pasada = "SI";
        } else {
            pasada = "NO";
        }

        return SUCCESS;
    }

    public String subirActividad() throws ParseException {
        Asignaturas asignatura = findAsignatura(asignaturaId);

        //Nota is numeric
        if (notaActividad.matches("^\\d+(\\.\\d+)+$")) {

            double notaFinal = Double.parseDouble(notaActividad);

            //Nota is positive
            if (notaFinal > 0) {

                //Fecha is valid
                if (fechaActividad.matches("^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$")) {

                    //Nombre Actividad is required
                    if (nombreActividad != null && !nombreActividad.equals("")) {

                        //Tipo Actividad is required
                        if (tipoActividad != null && !tipoActividad.equals("")) {
                            String fullPath = getServletContext().getRealPath(File.separator) + (path + stripAccents(asignatura.getNombre()) + "/entregas/" + stripAccents(nombreActividad));

                            //Create folder to store future entregas
                            File saveFolder = new File(fullPath);

                            saveFolder.mkdirs();

                            Actividades newActividad = new Actividades();

                            Map session = (Map) ActionContext.getContext().get("session");
                            Usuario profesor = (Usuario) session.get("usuario");

                            newActividad.setAsignaturaId(asignatura);
                            newActividad.setNombre(nombreActividad);
                            try{
                            newActividad.setFechaFin(new SimpleDateFormat("yyyy-MM-dd").parse(fechaActividad));
                            }
                            catch(ParseException ex)
                            {
                                 addFieldError("fechaActividad", "La fecha debe ser válida y debe tener el formato correcto");
                    return INPUT;
                            }
                            newActividad.setNotaMax(Double.parseDouble(notaActividad));
                            newActividad.setTipo(tipoActividad);
                            newActividad.setProfesorId((Profesores) profesor);

                            crearActividad(newActividad);
                        } else {
                            addFieldError("tipoActividad", "El tipo de la actividad es requerido");
                            return INPUT;
                        }
                    } else {
                        addFieldError("nombreActividad", "El nombre de la actividad es requerido");
                        return INPUT;
                    }

                } else {
                    addFieldError("fechaActividad", "La fecha debe ser válida y debe tener el formato correcto");
                    return INPUT;
                }

            } else {
                addFieldError("notaActividad", "La nota debe ser mayor o igual a 0");
                return INPUT;
            }

        } else {
            addFieldError("notaActividad", "La nota debe ser numérica y debe seguir el formato X.X");
            return INPUT;
        }

        return SUCCESS;
    }

    public Actividades getCurrent() {
        return current;
    }

    public void setCurrent(Actividades current) {
        this.current = current;
    }

    public String getActividadId() {
        return actividadId;
    }

    public void setActividadId(String actividadId) {
        this.actividadId = actividadId;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

    public String cargarTodasActividades() {
        Map session = (Map) ActionContext.getContext().get("session");
        all = findActividadesAsignatura(asignaturaId);
        session.put("actividades", all);

        return SUCCESS;
    }

    public String cargarActividad() {
        Actividades current = findActividad(actividadId);

        notaActividad = String.valueOf(current.getNotaMax());
        fechaActividad = new SimpleDateFormat("YYYY-MM-dd").format(current.getFechaFin());
        tipoActividad = current.getTipo();
        nombreActividad = current.getNombre();

        return SUCCESS;
    }

    public String editarActividad() throws ParseException {
        Asignaturas asignatura = findAsignatura(asignaturaId);

        //Nota is numeric
        if (notaActividad.matches("^\\d+(\\.\\d+)+$")) {

            double notaFinal = Double.parseDouble(notaActividad);

            //Nota is positive
            if (notaFinal > 0) {

                //Fecha is valid
                if (fechaActividad.matches("^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$")) {

                    //Nombre Actividad is required
                    if (nombreActividad != null && !nombreActividad.equals("")) {

                        //Tipo Actividad is required
                        if (tipoActividad != null && !tipoActividad.equals("")) {
                            Actividades oldActividad = findActividad(actividadId);

                            String fullPath = getServletContext().getRealPath(File.separator) + (path + oldActividad.getAsignaturaId().getNombre() + "/entregas/");

                            File oldPath = new File(fullPath + oldActividad.getNombre());

                            File newPath = new File(fullPath + stripAccents(nombreActividad));

                            oldPath.renameTo(newPath);

                            Actividades newActividad = new Actividades();

                            Map session = (Map) ActionContext.getContext().get("session");
                            Usuario profesor = (Usuario) session.get("usuario");

                            newActividad.setAsignaturaId(asignatura);
                            newActividad.setNombre(nombreActividad);
                            try {
                                newActividad.setFechaFin(new SimpleDateFormat("yyyy-MM-dd").parse(fechaActividad));
                            } catch (ParseException ex) {
                                addFieldError("fechaActividad", "La fecha debe ser válida y debe tener el formato correcto");
                                return INPUT;
                            }
                            newActividad.setNotaMax(Double.parseDouble(notaActividad));
                            newActividad.setTipo(tipoActividad);
                            newActividad.setProfesorId((Profesores) profesor);
                            newActividad.setActividadId(oldActividad.getActividadId());

                            modificarActividad(newActividad);
                        } else {
                            addFieldError("tipoActividad", "El tipo de la actividad es requerido");
                            return INPUT;
                        }
                    } else {
                        addFieldError("nombreActividad", "El nombre de la actividad es requerido");
                        return INPUT;
                    }

                } else {
                    addFieldError("fechaActividad", "La fecha debe ser válida y debe tener el formato correcto");
                    return INPUT;
                }

            } else {
                addFieldError("notaActividad", "La nota debe ser mayor o igual a 0");
                return INPUT;
            }

        } else {
            addFieldError("notaActividad", "La nota debe ser numérica y debe seguir el formato X.X");
            return INPUT;
        }

        return SUCCESS;
    }

    public String getAsignaturaId() {
        return asignaturaId;
    }

    public void setAsignaturaId(String asignaturaId) {
        this.asignaturaId = asignaturaId;
    }

    public List<Actividades> getAll() {
        return all;
    }

    public void setAll(List<Actividades> all) {
        this.all = all;
    }

    public String getNotaActividad() {
        return notaActividad;
    }

    public void setNotaActividad(String notaActividad) {
        this.notaActividad = notaActividad;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public String getFechaActividad() {
        return fechaActividad;
    }

    public void setFechaActividad(String fechaActividad) {
        this.fechaActividad = fechaActividad;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public String getPasada() {
        return pasada;
    }

    public void setPasada(String pasada) {
        this.pasada = pasada;
    }

}
