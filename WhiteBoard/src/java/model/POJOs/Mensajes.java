/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.POJOs;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ridao
 */
@Entity
@Table(name = "mensajes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mensajes.findAll", query = "SELECT m FROM Mensajes m")
    , @NamedQuery(name = "Mensajes.findByIdMensaje", query = "SELECT m FROM Mensajes m WHERE m.idMensaje = :idMensaje")
    , @NamedQuery(name = "Mensajes.findByFecha", query = "SELECT m FROM Mensajes m WHERE m.fecha = :fecha")})
public class Mensajes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMensaje")
    private Integer idMensaje;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "contenido")
    private String contenido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "remitenteId", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Alumnos remitenteId;
    @JoinColumn(name = "destinatarioId", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Alumnos destinatarioId;

    public Mensajes() {
    }

    public Mensajes(Integer idMensaje) {
        this.idMensaje = idMensaje;
    }

    public Mensajes(Integer idMensaje, String contenido, Date fecha) {
        this.idMensaje = idMensaje;
        this.contenido = contenido;
        this.fecha = fecha;
    }

    public Integer getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(Integer idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Alumnos getRemitenteId() {
        return remitenteId;
    }

    public void setRemitenteId(Alumnos remitenteId) {
        this.remitenteId = remitenteId;
    }

    public Alumnos getDestinatarioId() {
        return destinatarioId;
    }

    public void setDestinatarioId(Alumnos destinatarioId) {
        this.destinatarioId = destinatarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMensaje != null ? idMensaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensajes)) {
            return false;
        }
        Mensajes other = (Mensajes) object;
        if ((this.idMensaje == null && other.idMensaje != null) || (this.idMensaje != null && !this.idMensaje.equals(other.idMensaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.POJOs.Mensajes[ idMensaje=" + idMensaje + " ]";
    }
    
}
