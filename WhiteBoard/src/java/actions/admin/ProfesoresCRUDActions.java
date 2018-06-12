/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions.admin;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import model.POJOs.Actividades;
import model.POJOs.Alumnos;
import model.POJOs.Asignaturas;
import model.POJOs.Profesores;
import model.dao.DAOImpl;

/**
 *
 * @author ridao
 */
public class ProfesoresCRUDActions extends ActionSupport {

    List<Profesores> profesores;
    // Atributos de la entidad
     private String id;

    private String username;

    private String horaTutoria;

    private String password;
    private String nombre;
    private String apellidos;
    private String foto;


    public ProfesoresCRUDActions() {
    }

    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public String crearProfesor() {
        Profesores al = new Profesores();
        al.setUsername(username);
        al.setNombre(nombre);
        al.setApellidos(apellidos);
        al.setPassword(password);
        al.setFoto(foto);
        al.setHoraTutoria(horaTutoria);
        DAOImpl.crearProfesor(al);
        // Para que postredirectget devuelva a la vista de admin alumnos
        Map session = (Map) ActionContext.getContext().get("session");
        session.put("origin", "loadTeachers");
        return SUCCESS;
    }



    public String editarProfesor() {
        Profesores al = new Profesores();
        al.setIdUsuario(Integer.parseInt(id));
        al.setUsername(username);
        al.setNombre(nombre);
        al.setApellidos(apellidos);
        al.setPassword(password);
        al.setFoto(foto);
        al.setHoraTutoria(horaTutoria);
        DAOImpl.editarProfesor(al);
        return SUCCESS;
    }
    public String loadProfesores() {
        // Las llamadas al webservice se hacen siempre a traves de DAOImpl
        profesores = DAOImpl.findAllProfesores();
        return SUCCESS;
    }

    //Metodos cruds aqui
    // Getter y setters aqui

    public List<Profesores> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesores> profesores) {
        this.profesores = profesores;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHoraTutoria() {
        return horaTutoria;
    }

    public void setHoraTutoria(String horaTutoria) {
        this.horaTutoria = horaTutoria;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
}
