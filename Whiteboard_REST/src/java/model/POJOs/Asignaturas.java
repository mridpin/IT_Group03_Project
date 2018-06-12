/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.POJOs;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ridao
 */
@Entity
@Table(name = "asignaturas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignaturas.findAll", query = "SELECT a FROM Asignaturas a")
    , @NamedQuery(name = "Asignaturas.findByAsignaturaId", query = "SELECT a FROM Asignaturas a WHERE a.asignaturaId = :asignaturaId")
    , @NamedQuery(name = "Asignaturas.findByNotaMinima", query = "SELECT a FROM Asignaturas a WHERE a.notaMinima = :notaMinima")
    , @NamedQuery(name = "Asignaturas.findByNAlumnos", query = "SELECT a FROM Asignaturas a WHERE a.nAlumnos = :nAlumnos")
    , @NamedQuery(name = "Asignaturas.findBySemestre", query = "SELECT a FROM Asignaturas a WHERE a.semestre = :semestre")
    , @NamedQuery(name = "Asignaturas.findByNombre", query = "SELECT a FROM Asignaturas a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Asignaturas.findByCurso", query = "SELECT a FROM Asignaturas a WHERE a.curso = :curso")})
public class Asignaturas implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignaturas")
    private Collection<AlumnoAsignatura> alumnoAsignaturaCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "asignaturaId")
    private Integer asignaturaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "notaMinima")
    private double notaMinima;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nAlumnos")
    private int nAlumnos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 56)
    @Column(name = "semestre")
    private String semestre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "curso")
    private int curso;
    @ManyToMany(mappedBy = "asignaturasCollection")
    private Collection<Alumnos> alumnosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignaturaId")
    private Collection<Material> materialCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignaturaId")
    private Collection<Aulas> aulasCollection;
    @JoinColumn(name = "profesorId", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Profesores profesorId;

    public Asignaturas() {
    }

    public Asignaturas(Integer asignaturaId) {
        this.asignaturaId = asignaturaId;
    }

    public Asignaturas(Integer asignaturaId, double notaMinima, int nAlumnos, String semestre, String nombre, int curso) {
        this.asignaturaId = asignaturaId;
        this.notaMinima = notaMinima;
        this.nAlumnos = nAlumnos;
        this.semestre = semestre;
        this.nombre = nombre;
        this.curso = curso;
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

    public int getNAlumnos() {
        return nAlumnos;
    }

    public void setNAlumnos(int nAlumnos) {
        this.nAlumnos = nAlumnos;
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

    @XmlTransient
    public Collection<Alumnos> getAlumnosCollection() {
        return alumnosCollection;
    }

    public void setAlumnosCollection(Collection<Alumnos> alumnosCollection) {
        this.alumnosCollection = alumnosCollection;
    }

    @XmlTransient
    public Collection<Material> getMaterialCollection() {
        return materialCollection;
    }

    public void setMaterialCollection(Collection<Material> materialCollection) {
        this.materialCollection = materialCollection;
    }

    @XmlTransient
    public Collection<Aulas> getAulasCollection() {
        return aulasCollection;
    }

    public void setAulasCollection(Collection<Aulas> aulasCollection) {
        this.aulasCollection = aulasCollection;
    }

    public Profesores getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Profesores profesorId) {
        this.profesorId = profesorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asignaturaId != null ? asignaturaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignaturas)) {
            return false;
        }
        Asignaturas other = (Asignaturas) object;
        if ((this.asignaturaId == null && other.asignaturaId != null) || (this.asignaturaId != null && !this.asignaturaId.equals(other.asignaturaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.POJOs.Asignaturas[ asignaturaId=" + asignaturaId + " ]";
    }

    @XmlTransient
    public Collection<AlumnoAsignatura> getAlumnoAsignaturaCollection() {
        return alumnoAsignaturaCollection;
    }

    public void setAlumnoAsignaturaCollection(Collection<AlumnoAsignatura> alumnoAsignaturaCollection) {
        this.alumnoAsignaturaCollection = alumnoAsignaturaCollection;
    }
    
}
