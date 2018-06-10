/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions.admin;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
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
    
    

}
