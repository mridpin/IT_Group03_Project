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
public class CargarAulasAction extends ActionSupport {

    List<Aulas> aulas;
    List<Asignaturas> asignaturas;
    public CargarAulasAction() {
    }

    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String loadAulas() {
        // Las llamadas al webservice se hacen siempre a traves de DAOImpl
        aulas = DAOImpl.findAllAulas();
        asignaturas = DAOImpl.findAllAsignaturas();
        return SUCCESS;
    }

    public List<Aulas> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aulas> aulas) {
        this.aulas = aulas;
    }

    public List<Asignaturas> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignaturas> asignaturas) {
        this.asignaturas = asignaturas;
    }

}
