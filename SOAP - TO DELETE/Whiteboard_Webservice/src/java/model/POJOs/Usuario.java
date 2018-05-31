/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.POJOs;

/**
 *
 * @author ridao
 */
public interface Usuario {

    Integer getIdUsuario();

    String getPassword();

    String getUsername();

    void setIdUsuario(Integer idUsuario);

    void setPassword(String password);

    void setUsername(String username);
    
}
