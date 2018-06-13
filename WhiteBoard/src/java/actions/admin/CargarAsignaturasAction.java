/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions.admin;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import model.POJOs.Asignaturas;
import model.POJOs.Aulas;
import model.POJOs.Profesores;
import model.dao.DAOImpl;

/**
 *
 * @author ridao
 */
public class CargarAsignaturasAction extends ActionSupport {

    List<Profesores> profesores;
    List<Asignaturas> asignaturas;
    public CargarAsignaturasAction() {
    }

    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String loadAsignaturas() {
        // Las llamadas al webservice se hacen siempre a traves de DAOImpl
        profesores = DAOImpl.findAllProfesores();
        asignaturas = DAOImpl.findAllAsignaturas();
        return SUCCESS;
    }

    public List<Profesores> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesores> profesores) {
        this.profesores = profesores;
    }

    public List<Asignaturas> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignaturas> asignaturas) {
        this.asignaturas = asignaturas;
    }
    


}
