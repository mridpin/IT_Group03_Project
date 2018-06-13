/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions.admin;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import model.POJOs.Profesores;
import model.dao.DAOImpl;

/**
 *
 * @author ridao
 */
public class CargarProfesoresAction extends ActionSupport {

    List<Profesores> profesores;

    public CargarProfesoresAction() {
    }

    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String loadProfesores() {
        // Las llamadas al webservice se hacen siempre a traves de DAOImpl
        profesores = DAOImpl.findAllProfesores();
        return SUCCESS;
    }

    public List<Profesores> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesores> profesores) {
        this.profesores = profesores;
    }

}
