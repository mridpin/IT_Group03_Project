/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;
import model.POJOs.Actividades;
import model.POJOs.Administradores;
import model.POJOs.Alumnos;
import model.POJOs.Asignaturas;
import model.POJOs.Aulas;
import model.POJOs.Material;
import model.POJOs.Mensajes;
import model.POJOs.Profesores;
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
        ProfesoresJerseyClient client = new ProfesoresJerseyClient();
        GenericType<List<Profesores>> genericType = new GenericType<List<Profesores>>() {
        };
        List<Profesores> data = new ArrayList<>();
        data = client.findAll_XML(genericType);
        for (Profesores a : data) {
            if (a.getUsername().equals(user) && a.getPassword().equals(password)) {
                client.close();
                return a;
            }
        }
        client.close();
        return null;
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

    public static List<Asignaturas> findAsignaturasFromAlumno(String idUsuario) {
        AlumnosJerseyClient alumnoJersey = new AlumnosJerseyClient();
        GenericType<List<Asignaturas>> genericType = new GenericType<List<Asignaturas>>() {
        };

        return alumnoJersey.findAsignaturas_XML(genericType, idUsuario);
    }
    
    public static List<Asignaturas> findAsignaturasFromProfesor(String idUsuario) {
        ProfesoresJerseyClient alumnoJersey = new ProfesoresJerseyClient();
        GenericType<List<Asignaturas>> genericType = new GenericType<List<Asignaturas>>() {
        };

        return alumnoJersey.findAsignaturas_XML(genericType, idUsuario);
    }

    public static Asignaturas findAsignatura(String id) {
        AsignaturasJerseyClient asignaturaJersey = new AsignaturasJerseyClient();
        GenericType<Asignaturas> genericTypeAsignatura = new GenericType<Asignaturas>() {
        };

        return asignaturaJersey.find_XML(genericTypeAsignatura, id);
    }

    public static List<Material> findMaterialesFromAsignatura(String id) {
        MaterialJerseyClient materialJersey = new MaterialJerseyClient();
        GenericType<List<Material>> genericTypeMaterial = new GenericType<List<Material>>() {
        };

        return materialJersey.findFromAsignatura_XML(genericTypeMaterial, id);
    }

    public static void crearMensaje(Mensajes msg) {
        MensajesJerseyClient mensajesJersey = new MensajesJerseyClient();
        mensajesJersey.create_JSON(msg);
        mensajesJersey.close();
    }

    public static Alumnos findStudentByName(String destinatario) {
        AlumnosJerseyClient client = new AlumnosJerseyClient();
        GenericType<Alumnos> genericType = new GenericType<Alumnos>() {
        };
        return client.findByUserName_XML(genericType, destinatario);
    }
    
    public static List<Actividades> getProximasActividadesFromAsignatura(String id)
    {
        ActividadesJerseyClient client = new ActividadesJerseyClient();
        GenericType<List<Actividades>> genericType = new GenericType<List<Actividades>>() {
        };
        return client.proximasActividadesFromAsignatura_XML(genericType, id);
    }

    public static List<Alumnos> findAllStudents() {
        AlumnosJerseyClient client = new AlumnosJerseyClient();
        GenericType<List<Alumnos>> genericType = new GenericType<List<Alumnos>>() {
        };
        return client.findAll_XML(genericType);
    }

    public static List<Asignaturas> findAllAsignaturas() {
        throw new UnsupportedOperationException("Not supported yet."); // Implementar igual que findAllStudents
    }

    public static List<Aulas> findAllAulas() {
        throw new UnsupportedOperationException("Not supported yet."); // Implementar igual que findAllStudents
    }

    public static List<Profesores> findAllProfesores() {
        throw new UnsupportedOperationException("Not supported yet."); // Implementar igual que findAllStudents
    }
    
    public static void downloadMaterial(String materialId) throws IOException
    {
        MaterialJerseyClient client = new MaterialJerseyClient();
               
        GenericType<File> genericType = new GenericType<File>() {
        };
        
        GenericType<Material> genericTypeMaterial = new GenericType<Material>() {
        };
        
        Material current = client.find_XML(genericTypeMaterial, materialId);
        
        File file = client.getFile(genericType,current.getRutaArchivo());
        
        File ff = new File("C:\test.png");
        file.renameTo(ff);
        
        FileWriter fr = new FileWriter(file);
        fr.flush();
        
    }
    
    public static Actividades findActividad(String id)
    {
        ActividadesJerseyClient client = new ActividadesJerseyClient();
        GenericType<Actividades> genericType = new GenericType<Actividades>() {
        };
        return client.find_XML(genericType, id);
    }
    
    public static void realizarEntrega(String alumnoId, File entrega)
    {
        new EntregasJerseyClient().uploadFile(alumnoId);
    }
    
    public static List<Alumnos> alumnosFromAsignatura(String asignaturaId)
    {
        AsignaturasJerseyClient client = new AsignaturasJerseyClient();
        GenericType<List<Alumnos>> genericType = new GenericType<List<Alumnos>>() {
        };
        return client.alumnosFromAsignatura_JSON(genericType, asignaturaId);
    }

    public static void crearAlumno(Alumnos al) {
        AlumnosJerseyClient client = new AlumnosJerseyClient();
        client.create_JSON(al);
        //client.close();
    }
    public static void editarAlumno(Alumnos al) {
        AlumnosJerseyClient client = new AlumnosJerseyClient();
        client.edit_JSON(al, al.getIdUsuario().toString());
        client.close();
    }
    public static void borrarAlumno(String desde, String hasta) {
        AlumnosJerseyClient client = new AlumnosJerseyClient();
        client.removeRange(desde, hasta);
        client.close();
    }
    public static void crearProfesor(Profesores p){
        ProfesoresJerseyClient client = new ProfesoresJerseyClient();
        client.create_JSON(p);
        //client.close();
    }
    public static void editarProfesor(Profesores p) {
        ProfesoresJerseyClient client = new ProfesoresJerseyClient();
        client.edit_JSON(p, p.getIdUsuario().toString());
        client.close();
    }
}
