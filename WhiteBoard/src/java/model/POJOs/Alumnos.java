/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.POJOs;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "alumnos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alumnos.findAll", query = "SELECT a FROM Alumnos a")
    , @NamedQuery(name = "Alumnos.findByIdUsuario", query = "SELECT a FROM Alumnos a WHERE a.idUsuario = :idUsuario")
    , @NamedQuery(name = "Alumnos.findByUsername", query = "SELECT a FROM Alumnos a WHERE a.username = :username")
    , @NamedQuery(name = "Alumnos.findByNombre", query = "SELECT a FROM Alumnos a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Alumnos.findByApellidos", query = "SELECT a FROM Alumnos a WHERE a.apellidos = :apellidos")
    , @NamedQuery(name = "Alumnos.findByFoto", query = "SELECT a FROM Alumnos a WHERE a.foto = :foto")
    , @NamedQuery(name = "Alumnos.findByPassword", query = "SELECT a FROM Alumnos a WHERE a.password = :password")})
public class Alumnos implements Serializable, Usuario {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 52)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "foto")
    private String foto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "password")
    private String password;
    @JoinTable(name = "alumno_asignatura", joinColumns = {
        @JoinColumn(name = "alumnoId", referencedColumnName = "idUsuario")}, inverseJoinColumns = {
        @JoinColumn(name = "asignaturaId", referencedColumnName = "asignaturaId")})
    @ManyToMany (fetch = FetchType.EAGER)
    private List<Asignaturas> asignaturasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "remitenteId", fetch = FetchType.EAGER)
    private List<Mensajes> mensajesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "destinatarioId")
    private List<Mensajes> mensajesList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumnos")
    private List<Entrega> entregaList;

    public Alumnos() {
    }

    public Alumnos(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Alumnos(Integer idUsuario, String username, String nombre, String apellidos, String foto, String password) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.foto = foto;
        this.password = password;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public List<Asignaturas> getAsignaturasList() {
        return asignaturasList;
    }

    public void setAsignaturasList(List<Asignaturas> asignaturasList) {
        this.asignaturasList = asignaturasList;
    }

    @XmlTransient
    public List<Mensajes> getMensajesList() {
        return mensajesList;
    }

    public void setMensajesList(List<Mensajes> mensajesList) {
        this.mensajesList = mensajesList;
    }

    @XmlTransient
    public List<Mensajes> getMensajesList1() {
        return mensajesList1;
    }

    public void setMensajesList1(List<Mensajes> mensajesList1) {
        this.mensajesList1 = mensajesList1;
    }

    @XmlTransient
    public List<Entrega> getEntregaList() {
        return entregaList;
    }

    public void setEntregaList(List<Entrega> entregaList) {
        this.entregaList = entregaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumnos)) {
            return false;
        }
        Alumnos other = (Alumnos) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.POJOs.Alumnos[ idUsuario=" + idUsuario + " ]";
    }
    
}
