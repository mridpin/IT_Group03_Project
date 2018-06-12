/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import model.POJOs.Actividades;
import model.POJOs.Entrega;
import model.POJOs.Usuario;
import static model.dao.DAOImpl.*;

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
    
    
    
    
    
}
