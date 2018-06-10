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
import model.POJOs.Usuario;
import static model.dao.DAOImpl.*;

public class AlumnoActions extends ActionSupport {
    
    public AlumnoActions() {
    }
    
    /*
    Loads all the Asignaturas of the Alumno
    */
    public String execute() throws Exception {
        
        //Get the usuario we are working with
        Map session = (Map) ActionContext.getContext().get("session");
        Usuario current = (Usuario) session.get("usuario");

        //This is saved in  session so that we don't have to load the Asignaturas again
        session.put("asignaturas",findAsignaturasFromAlumno(current.getIdUsuario().toString()));
        
        
        
        return SUCCESS;        
    }
    
}
