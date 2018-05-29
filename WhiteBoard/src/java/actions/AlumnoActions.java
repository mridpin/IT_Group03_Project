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
    
    private List<Asignaturas> all = null;
    
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
        
        all = alumnoJersey.findAsignaturas_XML(genericType,current.getIdUsuario().toString());
        
        return "success";
        
    }

    public List<Asignaturas> getAll() {
        return all;
    }

    public void setAll(List<Asignaturas> all) {
        this.all = all;
    }
    
    
    
}
