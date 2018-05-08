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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ridao
 */
@Entity
@Table(name = "entrega")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entrega.findAll", query = "SELECT e FROM Entrega e")
    , @NamedQuery(name = "Entrega.findByAlumnoId", query = "SELECT e FROM Entrega e WHERE e.entregaPK.alumnoId = :alumnoId")
    , @NamedQuery(name = "Entrega.findByActividadId", query = "SELECT e FROM Entrega e WHERE e.entregaPK.actividadId = :actividadId")
    , @NamedQuery(name = "Entrega.findByNota", query = "SELECT e FROM Entrega e WHERE e.nota = :nota")
    , @NamedQuery(name = "Entrega.findByRutaArchivo", query = "SELECT e FROM Entrega e WHERE e.rutaArchivo = :rutaArchivo")})
public class Entrega implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EntregaPK entregaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nota")
    private double nota;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "rutaArchivo")
    private String rutaArchivo;
    @JoinColumn(name = "actividadId", referencedColumnName = "actividadId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Actividades actividades;
    @JoinColumn(name = "alumnoId", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alumnos alumnos;

    public Entrega() {
    }

    public Entrega(EntregaPK entregaPK) {
        this.entregaPK = entregaPK;
    }

    public Entrega(EntregaPK entregaPK, double nota, String rutaArchivo) {
        this.entregaPK = entregaPK;
        this.nota = nota;
        this.rutaArchivo = rutaArchivo;
    }

    public Entrega(int alumnoId, int actividadId) {
        this.entregaPK = new EntregaPK(alumnoId, actividadId);
    }

    public EntregaPK getEntregaPK() {
        return entregaPK;
    }

    public void setEntregaPK(EntregaPK entregaPK) {
        this.entregaPK = entregaPK;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public Actividades getActividades() {
        return actividades;
    }

    public void setActividades(Actividades actividades) {
        this.actividades = actividades;
    }

    public Alumnos getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Alumnos alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entregaPK != null ? entregaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entrega)) {
            return false;
        }
        Entrega other = (Entrega) object;
        if ((this.entregaPK == null && other.entregaPK != null) || (this.entregaPK != null && !this.entregaPK.equals(other.entregaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.POJOs.Entrega[ entregaPK=" + entregaPK + " ]";
    }
    
}
