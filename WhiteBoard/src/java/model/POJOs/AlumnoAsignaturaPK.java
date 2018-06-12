/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.POJOs;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ridao
 */
@Embeddable
public class AlumnoAsignaturaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "alumnoId")
    private int alumnoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "asignaturaId")
    private int asignaturaId;

    public AlumnoAsignaturaPK() {
    }

    public AlumnoAsignaturaPK(int alumnoId, int asignaturaId) {
        this.alumnoId = alumnoId;
        this.asignaturaId = asignaturaId;
    }

    public int getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(int alumnoId) {
        this.alumnoId = alumnoId;
    }

    public int getAsignaturaId() {
        return asignaturaId;
    }

    public void setAsignaturaId(int asignaturaId) {
        this.asignaturaId = asignaturaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) alumnoId;
        hash += (int) asignaturaId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlumnoAsignaturaPK)) {
            return false;
        }
        AlumnoAsignaturaPK other = (AlumnoAsignaturaPK) object;
        if (this.alumnoId != other.alumnoId) {
            return false;
        }
        if (this.asignaturaId != other.asignaturaId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.POJOs.AlumnoAsignaturaPK[ alumnoId=" + alumnoId + ", asignaturaId=" + asignaturaId + " ]";
    }
    
}
