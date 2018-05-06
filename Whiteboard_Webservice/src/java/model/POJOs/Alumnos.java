package model.POJOs;
// Generated May 6, 2018 5:08:57 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Alumnos generated by hbm2java
 */
public class Alumnos  implements java.io.Serializable {


     private Integer idUsuario;
     private String username;
     private String nombre;
     private String apellidos;
     private String foto;
     private String password;
     private Set actividadAlumnos = new HashSet(0);
     private Set asignaturases = new HashSet(0);
     private Set mensajesesForRemitenteId = new HashSet(0);
     private Set mensajesesForDestinatarioId = new HashSet(0);

    public Alumnos() {
    }

	
    public Alumnos(String username, String nombre, String apellidos, String foto, String password) {
        this.username = username;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.foto = foto;
        this.password = password;
    }
    public Alumnos(String username, String nombre, String apellidos, String foto, String password, Set actividadAlumnos, Set asignaturases, Set mensajesesForRemitenteId, Set mensajesesForDestinatarioId) {
       this.username = username;
       this.nombre = nombre;
       this.apellidos = apellidos;
       this.foto = foto;
       this.password = password;
       this.actividadAlumnos = actividadAlumnos;
       this.asignaturases = asignaturases;
       this.mensajesesForRemitenteId = mensajesesForRemitenteId;
       this.mensajesesForDestinatarioId = mensajesesForDestinatarioId;
    }
   
    public Integer getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getFoto() {
        return this.foto;
    }
    
    public void setFoto(String foto) {
        this.foto = foto;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public Set getActividadAlumnos() {
        return this.actividadAlumnos;
    }
    
    public void setActividadAlumnos(Set actividadAlumnos) {
        this.actividadAlumnos = actividadAlumnos;
    }
    public Set getAsignaturases() {
        return this.asignaturases;
    }
    
    public void setAsignaturases(Set asignaturases) {
        this.asignaturases = asignaturases;
    }
    public Set getMensajesesForRemitenteId() {
        return this.mensajesesForRemitenteId;
    }
    
    public void setMensajesesForRemitenteId(Set mensajesesForRemitenteId) {
        this.mensajesesForRemitenteId = mensajesesForRemitenteId;
    }
    public Set getMensajesesForDestinatarioId() {
        return this.mensajesesForDestinatarioId;
    }
    
    public void setMensajesesForDestinatarioId(Set mensajesesForDestinatarioId) {
        this.mensajesesForDestinatarioId = mensajesesForDestinatarioId;
    }




}


