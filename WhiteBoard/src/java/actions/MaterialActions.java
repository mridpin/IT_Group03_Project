/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import model.POJOs.Asignaturas;
import model.POJOs.Material;
import static model.dao.DAOImpl.*;
import static org.apache.commons.lang3.StringUtils.stripAccents;
import static org.apache.struts2.ServletActionContext.getServletContext;

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
    
    private String materialId;
    
    private String nombreActividad;
    
    private File file;
    
    String fileContentType;

    String fileFileName;
    
    private List<String> tipos;
    
    public MaterialActions() {
    }
    
    //Finds all the materials of the asignatura according to tipo
    public String execute() throws Exception {
        List<Material> materiales = findMaterialesFromAsignatura(asignaturaId.toString());
        
        all = new ArrayList();

        for (Material current : materiales) {

            if(current.getRutaArchivo().contains(tipo))
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

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    
    public String cargarTodoMaterial()
    {
        all = findMaterialesFromAsignatura(asignaturaId.toString());
        tipos = new ArrayList<>();
        tipos.add("Enseñanzas Básicas");
        tipos.add("Enseñanzas Prácticas");
        return SUCCESS;
    }
    
    public String subirMaterial()
    {
        if(tipo.equals("Enseñanzas Básicas"))
        {
            tipo="eb";
        }
        else
        {
            tipo="epd";
        }
        
        Asignaturas asignatura = findAsignatura(asignaturaId.toString());
        
        String fullPath = getServletContext().getRealPath(File.separator) + (path + stripAccents(asignatura.getNombre())+"/"+tipo);

        file.renameTo(new File(fullPath + "/" + fileFileName));

        int startPath = (fullPath + "/" + fileFileName).indexOf("files");
        
        Material newMaterial = new Material();
        
        newMaterial.setAsignaturaId(asignatura);
        newMaterial.setNombre(nombreActividad);
        newMaterial.setRutaArchivo((fullPath + "/" + fileFileName).substring(startPath));
        
        crearMaterial(newMaterial);
        
        return SUCCESS;
    }
    
    public String borrarMaterial()
    {
        deleteMaterial(materialId);
        return SUCCESS;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public List<String> getTipos() {
        return tipos;
    }

    public void setTipos(List<String> tipos) {
        this.tipos = tipos;
    }

    
    
    
}
