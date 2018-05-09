/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.POJOs;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ridao
 */
@Entity
@Table(name = "aulas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aulas.findAll", query = "SELECT a FROM Aulas a")
    , @NamedQuery(name = "Aulas.findByAulaId", query = "SELECT a FROM Aulas a WHERE a.aulaId = :aulaId")
    , @NamedQuery(name = "Aulas.findByCapacidad", query = "SELECT a FROM Aulas a WHERE a.capacidad = :capacidad")
    , @NamedQuery(name = "Aulas.findByLocalizacion", query = "SELECT a FROM Aulas a WHERE a.localizacion = :localizacion")})
public class Aulas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "aulaId")
    private Integer aulaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "capacidad")
    private int capacidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "localizacion")
    private String localizacion;
    @JoinColumn(name = "asignaturaId", referencedColumnName = "asignaturaId")
    @ManyToOne(optional = false)
    private Asignaturas asignaturaId;

    public Aulas() {
    }

    public Aulas(Integer aulaId) {
        this.aulaId = aulaId;
    }

    public Aulas(Integer aulaId, int capacidad, String localizacion) {
        this.aulaId = aulaId;
        this.capacidad = capacidad;
        this.localizacion = localizacion;
    }

    public Integer getAulaId() {
        return aulaId;
    }

    public void setAulaId(Integer aulaId) {
        this.aulaId = aulaId;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public Asignaturas getAsignaturaId() {
        return asignaturaId;
    }

    public void setAsignaturaId(Asignaturas asignaturaId) {
        this.asignaturaId = asignaturaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aulaId != null ? aulaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aulas)) {
            return false;
        }
        Aulas other = (Aulas) object;
        if ((this.aulaId == null && other.aulaId != null) || (this.aulaId != null && !this.aulaId.equals(other.aulaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.POJOs.Aulas[ aulaId=" + aulaId + " ]";
    }
    
}
