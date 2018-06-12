/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.POJOs;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ridao
 */
@Entity
@Table(name = "alumno_asignatura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlumnoAsignatura.findAll", query = "SELECT a FROM AlumnoAsignatura a")
    , @NamedQuery(name = "AlumnoAsignatura.findByAlumnoId", query = "SELECT a FROM AlumnoAsignatura a WHERE a.alumnoAsignaturaPK.alumnoId = :alumnoId")
    , @NamedQuery(name = "AlumnoAsignatura.findByAsignaturaId", query = "SELECT a FROM AlumnoAsignatura a WHERE a.alumnoAsignaturaPK.asignaturaId = :asignaturaId")
    , @NamedQuery(name = "AlumnoAsignatura.findByDummy", query = "SELECT a FROM AlumnoAsignatura a WHERE a.dummy = :dummy")})
public class AlumnoAsignatura implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AlumnoAsignaturaPK alumnoAsignaturaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dummy")
    private int dummy;
    @JoinColumn(name = "alumnoId", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alumnos alumnos;
    @JoinColumn(name = "asignaturaId", referencedColumnName = "asignaturaId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Asignaturas asignaturas;

    public AlumnoAsignatura() {
    }

    public AlumnoAsignatura(AlumnoAsignaturaPK alumnoAsignaturaPK) {
        this.alumnoAsignaturaPK = alumnoAsignaturaPK;
    }

    public AlumnoAsignatura(AlumnoAsignaturaPK alumnoAsignaturaPK, int dummy) {
        this.alumnoAsignaturaPK = alumnoAsignaturaPK;
        this.dummy = dummy;
    }

    public AlumnoAsignatura(int alumnoId, int asignaturaId) {
        this.alumnoAsignaturaPK = new AlumnoAsignaturaPK(alumnoId, asignaturaId);
    }

    public AlumnoAsignaturaPK getAlumnoAsignaturaPK() {
        return alumnoAsignaturaPK;
    }

    public void setAlumnoAsignaturaPK(AlumnoAsignaturaPK alumnoAsignaturaPK) {
        this.alumnoAsignaturaPK = alumnoAsignaturaPK;
    }

    public int getDummy() {
        return dummy;
    }

    public void setDummy(int dummy) {
        this.dummy = dummy;
    }

    public Alumnos getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Alumnos alumnos) {
        this.alumnos = alumnos;
    }

    public Asignaturas getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(Asignaturas asignaturas) {
        this.asignaturas = asignaturas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alumnoAsignaturaPK != null ? alumnoAsignaturaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlumnoAsignatura)) {
            return false;
        }
        AlumnoAsignatura other = (AlumnoAsignatura) object;
        if ((this.alumnoAsignaturaPK == null && other.alumnoAsignaturaPK != null) || (this.alumnoAsignaturaPK != null && !this.alumnoAsignaturaPK.equals(other.alumnoAsignaturaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.POJOs.AlumnoAsignatura[ alumnoAsignaturaPK=" + alumnoAsignaturaPK + " ]";
    }
    
}
