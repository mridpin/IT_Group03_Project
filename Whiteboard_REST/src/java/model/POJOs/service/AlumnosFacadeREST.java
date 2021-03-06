/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.POJOs.service;

import java.util.ArrayList;
import java.util.Collection;
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
import model.POJOs.Alumnos;
import model.POJOs.Asignaturas;
import model.POJOs.Entrega;
import model.POJOs.Mensajes;

/**
 *
 * @author ridao
 */
@Stateless
@Path("model.pojos.alumnos")
public class AlumnosFacadeREST extends AbstractFacade<Alumnos> {

    @PersistenceContext(unitName = "Whiteboard_RESTPU")
    private EntityManager em;

    public AlumnosFacadeREST() {
        super(Alumnos.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Alumnos entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Alumnos entity) {
        super.edit(entity);
    }
    
    @PUT
    @Path("{id}/asignaturas")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void matricular(@PathParam("id") Integer id, Asignaturas entity) {
        Alumnos als = this.find(id);
        Collection<Asignaturas> asignaturas = als.getAsignaturasCollection();
        asignaturas.add(entity);
        als.setAsignaturasCollection(asignaturas);
        super.edit(als);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Alumnos find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Path("username/{username}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Alumnos findByUserName(@PathParam("username") String username) {
        List<Alumnos> alumnos = super.findAll();
        for (Alumnos a : alumnos) {
            if (a.getUsername().equals(username)) {
                return a;
            }
        }
        return null;
    }
    
    @GET
    @Path("getEntregaAlumnoActividad/{idact}/{idal}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Entrega getEntregaAlumnoActividad(@PathParam("idact") Integer idact,@PathParam("idal") Integer idal) {
        
        if(this.find(idal)!=null)
        {
            
            List<Entrega> entregas = getEntregaAlumno(idal);
            for(Entrega a : entregas)
            {
                if(a.getActividades().getActividadId()==idact)
                {
                    return a;
                }
            }
            
        }
        return null;
    }
    
    @GET
    @Path("getEntregaAlumno/{idal}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Entrega> getEntregaAlumno(@PathParam("idal") Integer idal) {
        return em.createQuery("SELECT e FROM Entrega e WHERE e.alumnos.idUsuario = "+idal).getResultList();
    }

    @GET
    @Path("{id}/getAsignaturas")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<Asignaturas> findAsignaturas(@PathParam("id") Integer id) {
        Alumnos aux = this.find(id);
        return aux.getAsignaturasCollection();
    }

    @GET
    @Path("{id}/getMensajesRecibidos")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<Mensajes> findMensajesRecibidos(@PathParam("id") Integer id) {
        Alumnos aux = this.find(id);
        return aux.getMensajesCollection1();
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Alumnos> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Alumnos> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @DELETE
    @Path("{from}/{to}")
    public void removeRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        for (Alumnos a : super.findRange(new int[]{from, to})) {
            super.remove(super.find(a.getIdUsuario()));
        }
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
