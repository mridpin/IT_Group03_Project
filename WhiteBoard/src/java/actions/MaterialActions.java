/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.ws.rs.core.GenericType;
import model.POJOs.Asignaturas;
import model.POJOs.Material;
import model.dao.MaterialJerseyClient;

/**
 *
 * @author Portatil
 */
public class MaterialActions extends ActionSupport {
    
    //eb or epd
    private String tipo;
    
    //current asignatura id
    private Integer asignaturaId;
    
    //all the material
    private List<Material> all;
    
    //current asignatura
    private Asignaturas asignatura;
    
    public MaterialActions() {
    }
    
    //Finds all the materials of the asignatura according to tipo
    public String execute() throws Exception {
        MaterialJerseyClient materialJersey = new MaterialJerseyClient();
        GenericType<List<Material>> genericTypeMaterial = new GenericType<List<Material>>(){};
        
        List<Material> materiales = materialJersey.findFromAsignatura_XML(genericTypeMaterial, asignaturaId.toString());

        for (Material current : materiales) {
            
            String[] path = current.getRutaArchivo().split("/");
            
            if(path[3].equals(tipo))
            {
                all.add(current);
            }
            
            
        }
        
        if(tipo.equals("eb"))
        {
            tipo="Enseñanzas Básicas";
        }
        else
        {
            tipo="Enseñanzas Prácticas";
        }
        
        return "success";
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getAsignaturaId() {
        return asignaturaId;
    }

    public void setAsignaturaId(Integer asignaturaId) {
        this.asignaturaId = asignaturaId;
    }

    public List<Material> getAll() {
        return all;
    }

    public void setAll(List<Material> all) {
        this.all = all;
    }

    public Asignaturas getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignaturas asignatura) {
        this.asignatura = asignatura;
    }
    
    
    
    
    
}