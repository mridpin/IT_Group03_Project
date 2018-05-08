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
@Table(name = "profesores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesores.findAll", query = "SELECT p FROM Profesores p")
    , @NamedQuery(name = "Profesores.findByIdUsuario", query = "SELECT p FROM Profesores p WHERE p.idUsuario = :idUsuario")
    , @NamedQuery(name = "Profesores.findByUsername", query = "SELECT p FROM Profesores p WHERE p.username = :username")
    , @NamedQuery(name = "Profesores.findByHoraTutoria", query = "SELECT p FROM Profesores p WHERE p.horaTutoria = :horaTutoria")
    , @NamedQuery(name = "Profesores.findByPassword", query = "SELECT p FROM Profesores p WHERE p.password = :password")
    , @NamedQuery(name = "Profesores.findByNombre", query = "SELECT p FROM Profesores p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Profesores.findByApellidos", query = "SELECT p FROM Profesores p WHERE p.apellidos = :apellidos")
    , @NamedQuery(name = "Profesores.findByFoto", query = "SELECT p FROM Profesores p WHERE p.foto = :foto")})
public class Profesores implements Serializable {

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
    @Size(min = 1, max = 11)
    @Column(name = "horaTutoria")
    private String horaTutoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 124)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "foto")
    private String foto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profesorId")
    private Collection<Actividades> actividadesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profesorId")
    private Collection<Asignaturas> asignaturasCollection;

    public Profesores() {
    }

    public Profesores(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Profesores(Integer idUsuario, String username, String horaTutoria, String password, String nombre, String apellidos, String foto) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.horaTutoria = horaTutoria;
        this.password = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.foto = foto;
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

    public String getHoraTutoria() {
        return horaTutoria;
    }

    public void setHoraTutoria(String horaTutoria) {
        this.horaTutoria = horaTutoria;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @XmlTransient
    public Collection<Actividades> getActividadesCollection() {
        return actividadesCollection;
    }

    public void setActividadesCollection(Collection<Actividades> actividadesCollection) {
        this.actividadesCollection = actividadesCollection;
    }

    @XmlTransient
    public Collection<Asignaturas> getAsignaturasCollection() {
        return asignaturasCollection;
    }

    public void setAsignaturasCollection(Collection<Asignaturas> asignaturasCollection) {
        this.asignaturasCollection = asignaturasCollection;
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
        if (!(object instanceof Profesores)) {
            return false;
        }
        Profesores other = (Profesores) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.POJOs.Profesores[ idUsuario=" + idUsuario + " ]";
    }
    
}
