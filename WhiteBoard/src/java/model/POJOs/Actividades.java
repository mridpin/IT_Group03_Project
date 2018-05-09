/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.POJOs;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ridao
 */
@Entity
@Table(name = "actividades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actividades.findAll", query = "SELECT a FROM Actividades a")
    , @NamedQuery(name = "Actividades.findByFechaFin", query = "SELECT a FROM Actividades a WHERE a.fechaFin = :fechaFin")
    , @NamedQuery(name = "Actividades.findByActividadId", query = "SELECT a FROM Actividades a WHERE a.actividadId = :actividadId")
    , @NamedQuery(name = "Actividades.findByTipo", query = "SELECT a FROM Actividades a WHERE a.tipo = :tipo")
    , @NamedQuery(name = "Actividades.findByNotaMax", query = "SELECT a FROM Actividades a WHERE a.notaMax = :notaMax")
    , @NamedQuery(name = "Actividades.findByNombre", query = "SELECT a FROM Actividades a WHERE a.nombre = :nombre")})
public class Actividades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaFin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "actividadId")
    private Integer actividadId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 56)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "notaMax")
    private double notaMax;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actividades")
    private List<Entrega> entregaList;
    @JoinColumn(name = "profesorId", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Profesores profesorId;

    public Actividades() {
    }

    public Actividades(Integer actividadId) {
        this.actividadId = actividadId;
    }

    public Actividades(Integer actividadId, Date fechaFin, String tipo, double notaMax, String nombre) {
        this.actividadId = actividadId;
        this.fechaFin = fechaFin;
        this.tipo = tipo;
        this.notaMax = notaMax;
        this.nombre = nombre;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getActividadId() {
        return actividadId;
    }

    public void setActividadId(Integer actividadId) {
        this.actividadId = actividadId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getNotaMax() {
        return notaMax;
    }

    public void setNotaMax(double notaMax) {
        this.notaMax = notaMax;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Entrega> getEntregaList() {
        return entregaList;
    }

    public void setEntregaList(List<Entrega> entregaList) {
        this.entregaList = entregaList;
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
        hash += (actividadId != null ? actividadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividades)) {
            return false;
        }
        Actividades other = (Actividades) object;
        if ((this.actividadId == null && other.actividadId != null) || (this.actividadId != null && !this.actividadId.equals(other.actividadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.POJOs.Actividades[ actividadId=" + actividadId + " ]";
    }
    
}
