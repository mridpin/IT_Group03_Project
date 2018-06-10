/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions.admin;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import model.POJOs.Alumnos;
import model.dao.DAOImpl;

/**
 *
 * @author ridao
 */
public class CargarBorrarAlumnosAction extends ActionSupport {

    List<Alumnos> alumnos;
    String desde;
    String hasta;
    File file;
    String contentType;
    String filename;

    public CargarBorrarAlumnosAction() {
    }

    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String loadAlumnos() {
        // Las llamadas al webservice se hacen siempre a traves de DAOImpl
        alumnos = DAOImpl.findAllStudents();
        return SUCCESS;
    }

    public String crearAlumnos() {
//        Alumnos al = new Alumnos();
//        al.setUsername(username);
//        al.setNombre(nombre);
//        al.setApellidos(apellidos);
//        al.setPassword(password);
//        al.setFoto(foto);
//        DAOImpl.crearAlumno(al);
//        // Para que postredirectget devuelva a la vista de admin alumnos
//        Map session = (Map) ActionContext.getContext().get("session");
//        session.put("origin", "loadStudents");
        if (contentType != null) {
            if (contentType.equals("text/plain") || contentType.equals("application/csv") || contentType.equals("text/csv") || contentType.equals("application/vnd.ms-excel")) {
                String line = "";
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    while ((line = br.readLine()) != null) {
                        // use comma as separator
                        String[] alumno = line.split(",");
                        Alumnos al = new Alumnos();
                        al.setUsername(alumno[0]);
                        al.setNombre(alumno[1]);
                        al.setApellidos(alumno[2]);
                        al.setPassword(alumno[3]);
                        al.setFoto(alumno[4]);
                        DAOImpl.crearAlumno(al);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

// Para que postredirectget devuelva a la vista de admin alumnos
                Map session = (Map) ActionContext.getContext().get("session");
                session.put("origin", "loadStudents");
                return SUCCESS;
            } else {
                addFieldError("fichero", "Fichero debe ser de tipo CSV");
                return INPUT;
            }
        }
        addFieldError("fichero", "No se ha subido ningún fichero");
        return INPUT;
    }

    public String borrarAlumnos() { //RETOMAR: desde y hasta son nulls
        DAOImpl.borrarAlumno(desde, hasta);
        return SUCCESS;
    }

    public List<Alumnos> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumnos> alumnos) {
        this.alumnos = alumnos;
    }

    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getHasta() {
        return hasta;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
    }

    public void setFichero(File file) {
        this.file = file;
    }

    public void setFicheroContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setFicheroFileName(String filename) {
        this.filename = filename;
    }

}
