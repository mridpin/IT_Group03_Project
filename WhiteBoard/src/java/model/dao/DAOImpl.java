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
import model.POJOs.Entrega;
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

    public static String path = "/files/asignaturas/";

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

    public static double calcularNota(Alumnos al) {
        AlumnosJerseyClient client = new AlumnosJerseyClient();
        GenericType<List<Entrega>> genericType = new GenericType<List<Entrega>>() {
        };
        List<Entrega> entregas = client.getEntregaAlumno_JSON(genericType, al.getIdUsuario().toString());

        double nota = 0.0;

        for (Entrega e : entregas) {
            nota += (e.getNota() * 10) / e.getActividades().getNotaMax();
        }

        return nota;
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

    public static List<Actividades> getProximasActividadesFromAsignatura(String id) {
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
        AsignaturasJerseyClient client = new AsignaturasJerseyClient();
        GenericType<List<Asignaturas>> genericType = new GenericType<List<Asignaturas>>() {
        };
        return client.findAll_XML(genericType);
    }

    public static List<Aulas> findAllAulas() {
        AulasJerseyClient client = new AulasJerseyClient();
        GenericType<List<Aulas>> genericType = new GenericType<List<Aulas>>() {
        };
        return client.findAll_XML(genericType);
    }

    public static List<Profesores> findAllProfesores() {
        ProfesoresJerseyClient client = new ProfesoresJerseyClient();
        GenericType<List<Profesores>> genericType = new GenericType<List<Profesores>>() {
        };
        return client.findAll_XML(genericType);
    }

    public static Entrega getEntregaAlumnoActividad(String act, String al) {
        AlumnosJerseyClient client = new AlumnosJerseyClient();
        GenericType<Entrega> genericType = new GenericType<Entrega>() {
        };
        return client.getEntregaAlumnoActividad_JSON(genericType, act, al);

    }

    public static List<Entrega> getTodasEntregasActividad(String act) {
        EntregasJerseyClient client = new EntregasJerseyClient();
        GenericType<List<Entrega>> genericType = new GenericType<List<Entrega>>() {
        };
        return client.entregasActividad_JSON(genericType, act);
    }

    public static Actividades findActividad(String id) {
        ActividadesJerseyClient client = new ActividadesJerseyClient();
        GenericType<Actividades> genericType = new GenericType<Actividades>() {
        };
        return client.find_XML(genericType, id);
    }

    public static List<Actividades> findActividadesAsignatura(String id) {
        ActividadesJerseyClient client = new ActividadesJerseyClient();
        GenericType<List<Actividades>> genericType = new GenericType<List<Actividades>>() {
        };
        return client.actividadesFromAsignatura_JSON(genericType, id);
    }

    public static Material findMaterial(String id) {
        MaterialJerseyClient client = new MaterialJerseyClient();
        GenericType<Material> genericType = new GenericType<Material>() {
        };
        return client.find_JSON(genericType, id);
    }

    public static List<Alumnos> alumnosFromAsignatura(String asignaturaId) {
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

    public static void modificarActividad(Actividades al) {
        ActividadesJerseyClient client = new ActividadesJerseyClient();
        client.edit_JSON(al, al.getActividadId().toString());
        client.close();
    }

    public static void crearActividad(Actividades al) {
        ActividadesJerseyClient client = new ActividadesJerseyClient();
        client.create_XML(al);
        //client.close();
    }

    public static void crearMaterial(Material al) {
        MaterialJerseyClient client = new MaterialJerseyClient();
        client.create_JSON(al);
        //client.close();
    }

    public static void deleteMaterial(String al) {
        MaterialJerseyClient client = new MaterialJerseyClient();
        client.remove(al);
        //client.close();
    }

    public static void editMaterial(Material al) {
        MaterialJerseyClient client = new MaterialJerseyClient();
        client.edit_JSON(al, al.getMaterialId().toString());
        client.close();
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

    public static void crearProfesor(Profesores p) {
        ProfesoresJerseyClient client = new ProfesoresJerseyClient();
        client.create_JSON(p);
        //client.close();
    }

    public static void editarProfesor(Profesores p) {
        ProfesoresJerseyClient client = new ProfesoresJerseyClient();
        client.edit_JSON(p, p.getIdUsuario().toString());
        client.close();
    }

    public static void crearAula(Aulas a) {
        AulasJerseyClient client = new AulasJerseyClient();
        client.create_JSON(a);
        //client.close();
    }

    public static void crearEntrega(Entrega a) {
        EntregasJerseyClient client = new EntregasJerseyClient();
        client.create_JSON(a);
        //client.close();
    }

    public static void editarAula(Aulas a) {
        AulasJerseyClient client = new AulasJerseyClient();
        client.edit_JSON(a, a.getAulaId().toString());
        client.close();
    }

    public static void modificarEntrega(Entrega a) {
        EntregasJerseyClient client = new EntregasJerseyClient();
        client.edit_XML(a, a.getEntregaPK().toString());
        client.close();
    }

    public static void matricularAlumno(Alumnos al, Asignaturas a) {
        AlumnosJerseyClient client = new AlumnosJerseyClient();
        client.matricular_JSON(a, al.getIdUsuario().toString());
        client.close();
    }

    public static void crearAsignatura(Asignaturas a) {
        AsignaturasJerseyClient client = new AsignaturasJerseyClient();
        client.create_JSON(a);
        //client.close();
    }

    public static void editarAsignatura(Asignaturas a) {
        AsignaturasJerseyClient client = new AsignaturasJerseyClient();
        client.edit_JSON(a, a.getAsignaturaId().toString());
        client.close();
    }

    public static Profesores findProfesor(String id) {
        ProfesoresJerseyClient client = new ProfesoresJerseyClient();
        GenericType<Profesores> genericType = new GenericType<Profesores>() {
        };
        return client.find_JSON(genericType, id);
    }
}
