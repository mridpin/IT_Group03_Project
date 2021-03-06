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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import model.POJOs.Alumnos;
import model.POJOs.Asignaturas;
import model.POJOs.Aulas;
import model.POJOs.Material;
import model.POJOs.Profesores;
import model.dao.DAOImpl;

/**
 *
 * @author ridao
 */
public class AsignaturasCRUDActions extends ActionSupport {

    List<Asignaturas> asignaturas;
    private Integer asignaturaId;
    private double notaMinima;

    private Integer numAlumnos;

    private String semestre;

    private String nombre;
    private String profesorSeleccionado;
    private int curso;
    private List<Alumnos> alumnosList;
    private List<Material> materialList;
    private List<Aulas> aulasList;
    private Profesores profesorId;
    // Atributos de la entidad

    public AsignaturasCRUDActions() {
    }

    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
        public String crearAsignatura() {
        Asignaturas a = new Asignaturas();
        a.setAsignaturaId(asignaturaId);
        a.setNotaMinima(notaMinima);
        a.setNAlumnos(numAlumnos);
        a.setSemestre(semestre);
        a.setNombre(nombre);
        a.setCurso(curso);
        profesorId = DAOImpl.findProfesor(profesorSeleccionado);
        a.setProfesorId(profesorId);
        DAOImpl.crearAsignatura(a);
        // Para que postredirectget devuelva a la vista de admin alumnos
        Map session = (Map) ActionContext.getContext().get("session");
        session.put("origin", "loadCourses");
        return SUCCESS;
    }

    public String editarAsignatura() {
        Asignaturas a = new Asignaturas();
        a.setAsignaturaId(asignaturaId);
        a.setNotaMinima(notaMinima);
        a.setNAlumnos(numAlumnos);
        a.setSemestre(semestre);
        a.setNombre(nombre);
        a.setCurso(curso);
        profesorId = DAOImpl.findProfesor(profesorSeleccionado);
        a.setProfesorId(profesorId);
        DAOImpl.editarAsignatura(a);
        return SUCCESS;
    }


    //Metodos cruds aqui
    // Getter y setters aqui

    public List<Asignaturas> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignaturas> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public Integer getAsignaturaId() {
        return asignaturaId;
    }

    public void setAsignaturaId(Integer asignaturaId) {
        this.asignaturaId = asignaturaId;
    }

    public double getNotaMinima() {
        return notaMinima;
    }

    public void setNotaMinima(double notaMinima) {
        this.notaMinima = notaMinima;
    }

    public Integer getNumAlumnos() {
        return numAlumnos;
    }

    public void setNumAlumnos(Integer numAlumnos) {
        this.numAlumnos = numAlumnos;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public List<Alumnos> getAlumnosList() {
        return alumnosList;
    }

    public void setAlumnosList(List<Alumnos> alumnosList) {
        this.alumnosList = alumnosList;
    }

    public List<Material> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(List<Material> materialList) {
        this.materialList = materialList;
    }

    public List<Aulas> getAulasList() {
        return aulasList;
    }

    public void setAulasList(List<Aulas> aulasList) {
        this.aulasList = aulasList;
    }

    public Profesores getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Profesores profesorId) {
        this.profesorId = profesorId;
    }

    public String getProfesorSeleccionado() {
        return profesorSeleccionado;
    }

    public void setProfesorSeleccionado(String profesorSeleccionado) {
        this.profesorSeleccionado = profesorSeleccionado;
    } 
    
}
