/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.POJOs.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
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
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;
import model.POJOs.Entrega;
import model.POJOs.EntregaPK;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 *
 * @author ridao
 */
@Stateless
@Path("model.pojos.entrega")
public class EntregaFacadeREST extends AbstractFacade<Entrega> {

    @PersistenceContext(unitName = "Whiteboard_RESTPU")
    private EntityManager em;

    private EntregaPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;alumnoId=alumnoIdValue;actividadId=actividadIdValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        model.POJOs.EntregaPK key = new model.POJOs.EntregaPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> alumnoId = map.get("alumnoId");
        if (alumnoId != null && !alumnoId.isEmpty()) {
            key.setAlumnoId(new java.lang.Integer(alumnoId.get(0)));
        }
        java.util.List<String> actividadId = map.get("actividadId");
        if (actividadId != null && !actividadId.isEmpty()) {
            key.setActividadId(new java.lang.Integer(actividadId.get(0)));
        }
        return key;
    }

    public EntregaFacadeREST() {
        super(Entrega.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Entrega entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Entrega entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        model.POJOs.EntregaPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Entrega find(@PathParam("id") PathSegment id) {
        model.POJOs.EntregaPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Entrega> findAll() {
        return super.findAll();
    }

    @GET
    @Path("getEntregasActividad/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Entrega> getEntregasActividad(@PathParam("id") Integer id) {
        List<Entrega> all = this.findAll();

        List<Entrega> result = new ArrayList<>();
        
        for(Entrega current: all)
        {
            if(current.getActividades().getActividadId()==id)
            {
                result.add(current);
            }
        }
        
        return result;
    }
    
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Entrega> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
