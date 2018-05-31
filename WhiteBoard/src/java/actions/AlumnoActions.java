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
import model.POJOs.Asignaturas;
import model.POJOs.Usuario;
import model.dao.AlumnosJerseyClient; 

public class AlumnoActions extends ActionSupport {
    
    //The asignatura that is currently being viewed
    private Asignaturas current;
    
    
    public AlumnoActions() {
    }
    
    /*
    Loads all the Asignaturas of the Alumno
    */
    public String execute() throws Exception {
        AlumnosJerseyClient alumnoJersey = new AlumnosJerseyClient();
        GenericType<List<Asignaturas>> genericType = new GenericType<List<Asignaturas>>(){};
        
        //Get the usuario we are working with
        Map session = (Map) ActionContext.getContext().get("session");
        Usuario current = (Usuario) session.get("usuario");

        
        //This is saved in  session so that we don't have to load the Asignaturas again
        session.put("asignaturas",alumnoJersey.findAsignaturas_XML(genericType,current.getIdUsuario().toString()));
        
        return "success";
        
    }

    public Asignaturas getCurrent() {
        return current;
    }

    public void setCurrent(Asignaturas current) {
        this.current = current;
    }

    
    
  
    
    
    
}
