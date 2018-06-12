/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.POJOs.service;

import java.util.Set;
import javax.ws.rs.core.Application;



/**
 *
 * @author ridao
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(model.POJOs.service.ActividadesFacadeREST.class);
        resources.add(model.POJOs.service.AdministradoresFacadeREST.class);
        resources.add(model.POJOs.service.AlumnosFacadeREST.class);
        resources.add(model.POJOs.service.AsignaturasFacadeREST.class);
        resources.add(model.POJOs.service.AulasFacadeREST.class);
        resources.add(model.POJOs.service.EntregaFacadeREST.class);
        resources.add(model.POJOs.service.MaterialFacadeREST.class);
        resources.add(model.POJOs.service.MensajesFacadeREST.class);
        resources.add(model.POJOs.service.ProfesoresFacadeREST.class);
    }
    
}
