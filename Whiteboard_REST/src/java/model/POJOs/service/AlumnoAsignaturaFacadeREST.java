/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.POJOs.service;

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
import model.POJOs.AlumnoAsignatura;
import model.POJOs.AlumnoAsignaturaPK;

/**
 *
 * @author ridao
 */
@Stateless
@Path("model.pojos.alumnoasignatura")
public class AlumnoAsignaturaFacadeREST extends AbstractFacade<AlumnoAsignatura> {

    @PersistenceContext(unitName = "Whiteboard_RESTPU")
    private EntityManager em;

    private AlumnoAsignaturaPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;alumnoId=alumnoIdValue;asignaturaId=asignaturaIdValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        model.POJOs.AlumnoAsignaturaPK key = new model.POJOs.AlumnoAsignaturaPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> alumnoId = map.get("alumnoId");
        if (alumnoId != null && !alumnoId.isEmpty()) {
            key.setAlumnoId(new java.lang.Integer(alumnoId.get(0)));
        }
        java.util.List<String> asignaturaId = map.get("asignaturaId");
        if (asignaturaId != null && !asignaturaId.isEmpty()) {
            key.setAsignaturaId(new java.lang.Integer(asignaturaId.get(0)));
        }
        return key;
    }

    public AlumnoAsignaturaFacadeREST() {
        super(AlumnoAsignatura.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(AlumnoAsignatura entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, AlumnoAsignatura entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        model.POJOs.AlumnoAsignaturaPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public AlumnoAsignatura find(@PathParam("id") PathSegment id) {
        model.POJOs.AlumnoAsignaturaPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<AlumnoAsignatura> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<AlumnoAsignatura> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
