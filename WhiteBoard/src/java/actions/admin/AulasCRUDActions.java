/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions.admin;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import model.POJOs.Asignaturas;
import model.POJOs.Aulas;
import model.dao.DAOImpl;

/**
 *
 * @author ridao
 */
public class AulasCRUDActions extends ActionSupport {

    List<Aulas> aulas;
        private Integer aulaId;

    private int capacidad;

    private String localizacion;

    private Asignaturas asignaturaId;
    // Atributos de la entidad

    public AulasCRUDActions() {
        
    }

    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
        public String crearAula() {
        Aulas a = new Aulas();
        a.setAulaId(aulaId);
        a.setCapacidad(capacidad);
        a.setLocalizacion(localizacion);
        a.setAsignaturaId(asignaturaId);
        DAOImpl.crearAula(a);
        // Para que postredirectget devuelva a la vista de admin alumnos
        Map session = (Map) ActionContext.getContext().get("session");
        session.put("origin", "loadRooms");
        return SUCCESS;
    }



    public String editarAula() {
        Aulas a = new Aulas();
        a.setAulaId(aulaId);
        a.setCapacidad(capacidad);
        a.setLocalizacion(localizacion);
        a.setAsignaturaId(asignaturaId);
        DAOImpl.editarAula(a);
        return SUCCESS;
    }

    public String loadAulas() {
        // Las llamadas al webservice se hacen siempre a traves de DAOImpl
        aulas = DAOImpl.findAllAulas();
        return SUCCESS;
    }
    
    //Metodos cruds aqui

    // Getter y setters aqui

    public List<Aulas> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aulas> aulas) {
        this.aulas = aulas;
    }

    public Integer getAulaId() {
        return aulaId;
    }

    public void setAulaId(Integer aulaId) {
        this.aulaId = aulaId;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public Asignaturas getAsignaturaId() {
        return asignaturaId;
    }

    public void setAsignaturaId(Asignaturas asignaturaId) {
        this.asignaturaId = asignaturaId;
    }
    
}
