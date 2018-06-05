/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;
import model.POJOs.Administradores;
import model.POJOs.Alumnos;
import model.POJOs.Asignaturas;
import model.POJOs.Material;
import model.POJOs.Mensajes;
import model.POJOs.Usuario;
import model.dao.AdministradoresJerseyClient;
import model.dao.AlumnosJerseyClient;

/**
 *
 * @author ridao
 */
public class DAOImpl {

    public static Administradores findAdmin(String user, String password) {
        AdministradoresJerseyClient client = new AdministradoresJerseyClient();
        GenericType<List<Administradores>> genericType = new GenericType<List<Administradores>>() {
        };
        List<Administradores> data = new ArrayList<>();
        data = client.findAll_XML(genericType);
        // Hash password here
        for (Administradores a : data) {
            if (a.getUsername().equals(user) && a.getPassword().equals(password)) {
                client.close();
                return a;
            }
        }
        client.close();
        return null;
    }

    public static Alumnos findStudent(String user, String password) {
        AlumnosJerseyClient client = new AlumnosJerseyClient();
        GenericType<List<Alumnos>> genericType = new GenericType<List<Alumnos>>() {
        };
        List<Alumnos> data = new ArrayList<>();
        data = client.findAll_XML(genericType);
        for (Alumnos a : data) {
            if (a.getUsername().equals(user) && a.getPassword().equals(password)) {
                client.close();
                return a;
            }
        }
        client.close();
        return null;
    }

    public static Usuario findProf(String user, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static List<Asignaturas> findAsignaturas(Alumnos al) {
        AlumnosJerseyClient client = new AlumnosJerseyClient();
        GenericType<List<Asignaturas>> genericType = new GenericType<List<Asignaturas>>() {
        };
        List<Asignaturas> data = new ArrayList<>();
        data = client.findAsignaturas_XML(genericType, al.getIdUsuario().toString());
        return data;
    }

    public static List<Mensajes> findRecievedMessages(Alumnos al) {
        AlumnosJerseyClient client = new AlumnosJerseyClient();
        GenericType<List<Mensajes>> genericType = new GenericType<List<Mensajes>>() {
        };
        List<Mensajes> data = new ArrayList<>();
        data = client.findMensajesRecibidos_XML(genericType, al.getIdUsuario().toString());
        return data;
    }
    
    public static List<Asignaturas> findAsignaturasFromAlumno(String idUsuario)
    {
        AlumnosJerseyClient alumnoJersey = new AlumnosJerseyClient();
        GenericType<List<Asignaturas>> genericType = new GenericType<List<Asignaturas>>(){};
        
        
        return alumnoJersey.findAsignaturas_XML(genericType,idUsuario);
    }
    
    public static Asignaturas findAsignatura(String id)
    {
        AsignaturasJerseyClient asignaturaJersey = new AsignaturasJerseyClient();
        GenericType<Asignaturas> genericTypeAsignatura = new GenericType<Asignaturas>(){};
        
        
        return asignaturaJersey.find_XML(genericTypeAsignatura,id);
    }
    
    public static List<Material> findMaterialesFromAsignatura(String id)
    {
        MaterialJerseyClient materialJersey = new MaterialJerseyClient();
        GenericType<List<Material>> genericTypeMaterial = new GenericType<List<Material>>(){};
        
        
        return materialJersey.findFromAsignatura_XML(genericTypeMaterial,id);
    }
}
