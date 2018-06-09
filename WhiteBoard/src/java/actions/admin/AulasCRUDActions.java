/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions.admin;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import model.POJOs.Aulas;
import model.dao.DAOImpl;

/**
 *
 * @author ridao
 */
public class AulasCRUDActions extends ActionSupport {

    List<Aulas> aulas;
    // Atributos de la entidad

    public AulasCRUDActions() {
    }

    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String loadAulas() {
        // Las llamadas al webservice se hacen siempre a traves de DAOImpl
        aulas = DAOImpl.findAllAulas();
        return SUCCESS;
    }
    
    //Metodos cruds aqui

    // Getter y setters aqui
}
