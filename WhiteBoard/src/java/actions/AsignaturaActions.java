/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionSupport;
import javax.ws.rs.core.GenericType;
import model.POJOs.Asignaturas; 
import model.dao.AsignaturasJerseyClient;

/**
 *
 * @author Portatil
 */
public class AsignaturaActions extends ActionSupport {
    
    //Asignatura to be shown
    private Integer asignaturaId;
    
    //Current asignatura shown
    private Asignaturas current;
    
    public AsignaturaActions() {
    }
    
    public String execute() throws Exception {
        AsignaturasJerseyClient asignaturaJersey = new AsignaturasJerseyClient();
        GenericType<Asignaturas> genericType = new GenericType<Asignaturas>(){};

        //This is saved in  session so that we don't have to load the Asignaturas again
        this.setCurrent(asignaturaJersey.find_XML(genericType,asignaturaId.toString()));
        
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
    
    
    
}
