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
import model.POJOs.Alumnos;
import model.POJOs.Mensajes;
import model.dao.DAOImpl;

/**
 *
 * @author ridao
 */
public class MessagesActions extends ActionSupport {
    
    Alumnos alumno;
    List<Mensajes> mensajes;
    
    public MessagesActions() {
    }
    
    public String execute() throws Exception {
        Map session = (Map) ActionContext.getContext().get("session");
        alumno = (Alumnos) session.get("usuario");
        mensajes = DAOImpl.findRecievedMessages(alumno);
        return SUCCESS;
    }

    public Alumnos getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumnos alumno) {
        this.alumno = alumno;
    }

    public List<Mensajes> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Mensajes> mensajes) {
        this.mensajes = mensajes;
    }
    
    
    
}
