/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import model.POJOs.Actividades;
import model.POJOs.Entrega;
import model.POJOs.Usuario;
import static model.dao.DAOImpl.*;

/**
 *
 * @author Portatil
 */
public class ActividadActions extends ActionSupport {
    
    private Actividades current;
    
    private Entrega entrega;
    
    private String actividadId;
    
    public ActividadActions() {
    }
    
    public String execute() throws Exception {
         Map session = (Map) ActionContext.getContext().get("session");
        Usuario alumno = (Usuario) session.get("usuario");
        
        current = findActividad(actividadId);
        
        entrega = getEntregaAlumnoActividad(current.getActividadId().toString(),alumno.getIdUsuario().toString());
        
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

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }
    
    public String cargarTodasActividades()
    {
        
        return SUCCESS;
    }
    
    
    
}
