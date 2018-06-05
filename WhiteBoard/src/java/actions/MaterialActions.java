/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import model.POJOs.Material;
import static model.dao.DAOImpl.*;

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
    
    public MaterialActions() {
    }
    
    //Finds all the materials of the asignatura according to tipo
    public String execute() throws Exception {
        
        
        // No llames al jersey desde la action, mejor crea un metodo estatico en DAOImpl que sea el que llame al jersey
        List<Material> materiales = findMaterialesFromAsignatura(asignaturaId.toString());
        
        all = new ArrayList();

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
        
        return SUCCESS;
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

    
    
    
    
    
}
