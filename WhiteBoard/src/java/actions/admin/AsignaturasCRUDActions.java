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
import model.dao.DAOImpl;

/**
 *
 * @author ridao
 */
public class AsignaturasCRUDActions extends ActionSupport {

    List<Asignaturas> asignaturas;
    // Atributos de la entidad

    public AsignaturasCRUDActions() {
    }

    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String loadAsignaturas() {
        // Las llamadas al webservice se hacen siempre a traves de DAOImpl
        asignaturas = DAOImpl.findAllAsignaturas();
        return SUCCESS;
    }

    //Metodos cruds aqui
    // Getter y setters aqui
}
