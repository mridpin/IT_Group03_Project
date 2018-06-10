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
import javax.ws.rs.core.GenericType;
import model.POJOs.Actividades;
import model.POJOs.Alumnos;
import model.POJOs.Asignaturas; 
import model.POJOs.Profesores;
import model.dao.AsignaturasJerseyClient;
import static model.dao.DAOImpl.*;

/**
 *
 * @author Portatil
 */
public class AsignaturaActions extends ActionSupport {
    
    //Asignatura to be shown
    private Integer asignaturaId;
    
    //Profesor of the Asignatura
    private Profesores profesor;
    
    private List<Alumnos> allAlumnos;
    
    private List<Actividades> currentActividades;
    
    public AsignaturaActions() {
    }
    
    public String execute() throws Exception {
        Asignaturas asignatura = findAsignatura(asignaturaId.toString());
        
        Map session = (Map) ActionContext.getContext().get("session");
        
        //This is saved in  session so that we don't have to load the Asignatura again
        session.put("asignatura",asignatura);
        
        this.setProfesor(asignatura.getProfesorId());
        
        currentActividades = getProximasActividadesFromAsignatura(asignaturaId.toString());
        
        return "success";
    }
    
    public String allAlumnos()
    {      
        allAlumnos = alumnosFromAsignatura(asignaturaId.toString());
        return SUCCESS;
    }

    public Integer getAsignaturaId() {
        return asignaturaId;
    }

    public void setAsignaturaId(Integer asignaturaId) {
        this.asignaturaId = asignaturaId;
    }

    public Profesores getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesores profesor) {
        this.profesor = profesor;
    }

    public List<Alumnos> getAllAlumnos() {
        return allAlumnos;
    }

    public void setAllAlumnos(List<Alumnos> allAlumnos) {
        this.allAlumnos = allAlumnos;
    }

    public List<Actividades> getCurrentActividades() {
        return currentActividades;
    }

    public void setCurrentActividades(List<Actividades> currentActiviades) {
        this.currentActividades = currentActiviades;
    }
    
    
    
    
    
}
