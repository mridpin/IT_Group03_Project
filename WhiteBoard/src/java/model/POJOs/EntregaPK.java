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
public class EntregaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "alumnoId")
    private int alumnoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "actividadId")
    private int actividadId;

    public EntregaPK() {
    }

    public EntregaPK(int alumnoId, int actividadId) {
        this.alumnoId = alumnoId;
        this.actividadId = actividadId;
    }

    public int getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(int alumnoId) {
        this.alumnoId = alumnoId;
    }

    public int getActividadId() {
        return actividadId;
    }

    public void setActividadId(int actividadId) {
        this.actividadId = actividadId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) alumnoId;
        hash += (int) actividadId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntregaPK)) {
            return false;
        }
        EntregaPK other = (EntregaPK) object;
        if (this.alumnoId != other.alumnoId) {
            return false;
        }
        if (this.actividadId != other.actividadId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.POJOs.EntregaPK[ alumnoId=" + alumnoId + ", actividadId=" + actividadId + " ]";
    }
    
}
