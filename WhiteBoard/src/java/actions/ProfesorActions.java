/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import model.POJOs.Usuario;
import static model.dao.DAOImpl.*;

/**
 *
 * @author Portatil
 */
public class ProfesorActions extends ActionSupport {
    
    public ProfesorActions() {
    }
    
    public String execute() throws Exception {
        
         //Get the usuario we are working with
        Map session = (Map) ActionContext.getContext().get("session");
        Usuario current = (Usuario) session.get("usuario");

        //This is saved in  session so that we don't have to load the Asignaturas again
        session.put("asignaturas",findAsignaturasFromProfesor(current.getIdUsuario().toString()));
        
        return SUCCESS;
    }
    
}
