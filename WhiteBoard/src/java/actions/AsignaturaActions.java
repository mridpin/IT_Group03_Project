/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionSupport;
import javax.ws.rs.core.GenericType;
import model.POJOs.Asignaturas; 
import model.POJOs.Profesores;
import model.dao.AsignaturasJerseyClient;

/**
 *
 * @author Portatil
 */
public class AsignaturaActions extends ActionSupport {
    
    //Asignatura to be shown
    private Integer asignaturaId;
    
    //Current Asignatura shown
    private Asignaturas current;
    
    //Profesor of the Asignatura
    private Profesores profesor;
    
    public AsignaturaActions() {
    }
    
    public String execute() throws Exception {
        AsignaturasJerseyClient asignaturaJersey = new AsignaturasJerseyClient();
        GenericType<Asignaturas> genericTypeAsignatura = new GenericType<Asignaturas>(){};
        
        Asignaturas asignatura = asignaturaJersey.find_XML(genericTypeAsignatura,asignaturaId.toString());

        //They are not saved in session since every page will be different
        this.setCurrent(asignatura);
        
        this.setProfesor(asignatura.getProfesorId());
        
        return "success";
    }

    public Integer getAsignaturaId() {
        return asignaturaId;
    }

    public void setAsignaturaId(Integer asignaturaId) {
        this.asignaturaId = asignaturaId;
    }

    public Asignaturas getCurrent() {
        return current;
    }

    public void setCurrent(Asignaturas current) {
        this.current = current;
    }

    public Profesores getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesores profesor) {
        this.profesor = profesor;
    }
    
    
    
}
