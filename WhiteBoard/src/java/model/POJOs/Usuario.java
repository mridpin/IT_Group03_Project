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

    void setIdUsuario(Integer idUsuario);

    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);

    int hashCode();

    boolean equals(Object object);

    String toString();
}
