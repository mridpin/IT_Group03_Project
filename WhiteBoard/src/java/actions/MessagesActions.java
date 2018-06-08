/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
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
    String destinatario;
    String contenido;
    Alumnos alumnoDestinatario;
    List<Alumnos> alumnos;

    public MessagesActions() {
    }

    public String loadAlumnos() {
        alumnos = DAOImpl.findAllStudents();
        return SUCCESS;
    }

    public String sendMessage() {
        Map session = (Map) ActionContext.getContext().get("session");
        alumno = (Alumnos) session.get("usuario");
        session.put("origin", "loadMessages");
        Mensajes msg = new Mensajes();
        msg.setContenido(contenido);
        msg.setDestinatarioId(alumnoDestinatario);
        msg.setFecha(new Date());
        msg.setRemitenteId(alumno);
        DAOImpl.crearMensaje(msg);
        return SUCCESS;
    }

    // Busca el usuario a ver si existe
    public void validate() {
        if (destinatario != null) {
            alumnoDestinatario = DAOImpl.findStudentByName(destinatario);
            if (alumnoDestinatario == null) {
                addFieldError("destinatario", "Destinatario no encontrado");
            }
        }
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

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Alumnos getAlumnoDestinatario() {
        return alumnoDestinatario;
    }

    public void setAlumnoDestinatario(Alumnos alumnoDestinatario) {
        this.alumnoDestinatario = alumnoDestinatario;
    }

    public List<Alumnos> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumnos> alumnos) {
        this.alumnos = alumnos;
    }

}
