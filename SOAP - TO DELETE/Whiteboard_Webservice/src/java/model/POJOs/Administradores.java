package model.POJOs;
// Generated May 6, 2018 8:06:22 PM by Hibernate Tools 4.3.1



/**
 * Administradores generated by hbm2java
 */
public class Administradores  implements java.io.Serializable {


     private Integer idUsuario;
     private String username;
     private String password;

    public Administradores() {
    }

    public Administradores(String username, String password) {
       this.username = username;
       this.password = password;
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
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }




}

