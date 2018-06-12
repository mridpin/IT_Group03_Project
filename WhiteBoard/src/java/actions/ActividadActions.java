/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionSupport;
import model.POJOs.Actividades;
import static model.dao.DAOImpl.*;

/**
 *
 * @author Portatil
 */
public class ActividadActions extends ActionSupport {
    
    private Actividades current;
    
    private boolean entregado;
    
    private String actividadId;
    
    public ActividadActions() {
    }
    
    public String execute() throws Exception {
        current = findActividad(actividadId);
        return SUCCESS;
    }

    public Actividades getCurrent() {
        return current;
    }

    public void setCurrent(Actividades current) {
        this.current = current;
    }

    public String getActividadId() {
        return actividadId;
    }

    public void setActividadId(String actividadId) {
        this.actividadId = actividadId;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }
    
    
    
    
    
}
