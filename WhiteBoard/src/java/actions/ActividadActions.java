/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
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
    
    public ActividadActions() {
    }
    
    public String execute() throws Exception {
         Map session = (Map) ActionContext.getContext().get("session");
        Usuario alumno = (Usuario) session.get("usuario");
        
        current = findActividad(actividadId);
        
        entrega = getEntregaAlumnoActividad(current.getActividadId().toString(),alumno.getIdUsuario().toString());
        
        return SUCCESS;
    }
    
    public String subirActividad()
    {
        Asignaturas asignatura = findAsignatura(asignaturaId);
        
        String fullPath = getServletContext().getRealPath(File.separator) + (path + stripAccents(asignatura.getNombre())+"/entregas/"+stripAccents(nombreActividad));
        
         //Create folder to store future entregas
        File saveFolder = new File(fullPath);
        
        saveFolder.mkdirs();
        
        Actividades newActividad = new Actividades();
        
        Map session = (Map) ActionContext.getContext().get("session");
        Usuario profesor = (Usuario) session.get("usuario");
        
        newActividad.setAsignaturaId(asignatura);
        newActividad.setNombre(nombreActividad);
        newActividad.setFechaFin(new Date(fechaActividad));
        newActividad.setNotaMax(Double.parseDouble(notaActividad));
        newActividad.setTipo(tipoActividad);
        newActividad.setProfesorId((Profesores) profesor);
        
        crearActividad(newActividad);
        
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
    
    public String cargarTodasActividades()
    {
        all = findActividadesAsignatura(asignaturaId);
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
    
    
    
    
    
}
