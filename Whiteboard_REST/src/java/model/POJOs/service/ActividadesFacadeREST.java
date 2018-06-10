/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.POJOs.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.POJOs.Actividades;

/**
 *
 * @author ridao
 */
@Stateless
@Path("model.pojos.actividades")
public class ActividadesFacadeREST extends AbstractFacade<Actividades> {

    @PersistenceContext(unitName = "Whiteboard_RESTPU")
    private EntityManager em;

    public ActividadesFacadeREST() {
        super(Actividades.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Actividades entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Actividades entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Actividades find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @GET
    @Path("getActividadesAsignatura/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Actividades> actividadesFromAsignatura(@PathParam("id") Integer id) {
        List<Actividades> all = this.findAll();
        
        List<Actividades> result = new ArrayList<>();
        
        for(Actividades current: all)
        {
            if(current.getAsignaturaId().getAsignaturaId()==id)
            {
                result.add(current);
            }
        }
        
        return result;
    }
    
    @GET
    @Path("getProximasActividadesAsignatura/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Actividades> proximasActividadesFromAsignatura(@PathParam("id") Integer id) {
        List<Actividades> all = this.actividadesFromAsignatura(id);
        
        Date fecha = new Date();
        
        List<Actividades> result = new ArrayList<>();
        
        for(Actividades current: all)
        {
            if(current.getFechaFin().after(fecha))
            {
                result.add(current);
            }
        }
        
        return result;
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Actividades> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Actividades> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
