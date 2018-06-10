/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions.admin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import model.POJOs.Alumnos;
import model.dao.DAOImpl;

/**
 *
 * @author ridao
 */
public class AlumnosCRUDActions extends ActionSupport {

    String username;
    String nombre;
    String apellidos;
    String password;
    String foto;
    String id;
    String desde;
    String hasta;

    public AlumnosCRUDActions() {
    }

    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // CRUD methods here
    public String crearAlumno() {
        Alumnos al = new Alumnos();
        al.setUsername(username);
        al.setNombre(nombre);
        al.setApellidos(apellidos);
        al.setPassword(password);
        al.setFoto(foto);
        DAOImpl.crearAlumno(al);
        // Para que postredirectget devuelva a la vista de admin alumnos
        Map session = (Map) ActionContext.getContext().get("session");
        session.put("origin", "loadStudents");
        return SUCCESS;
    }

    public String editarAlumno() {
        Alumnos al = new Alumnos();
        al.setIdUsuario(Integer.parseInt(id));
        al.setUsername(username);
        al.setNombre(nombre);
        al.setApellidos(apellidos);
        al.setPassword(password);
        al.setFoto(foto);
        DAOImpl.editarAlumno(al);
        return SUCCESS;
    }

    public String borrarAlumnos() {
        DAOImpl.borrarAlumno(desde, hasta);
        return SUCCESS;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getHasta() {
        return hasta;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
    }

}
