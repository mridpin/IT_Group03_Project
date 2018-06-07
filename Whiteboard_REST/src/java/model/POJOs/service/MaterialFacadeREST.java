/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.POJOs.service;

import java.io.File;
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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import model.POJOs.Material;

/**
 *
 * @author ridao
 */
@Stateless
@Path("model.pojos.material")
public class MaterialFacadeREST extends AbstractFacade<Material> {

    @PersistenceContext(unitName = "Whiteboard_RESTPU")
    private EntityManager em;

    public MaterialFacadeREST() {
        super(Material.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Material entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Material entity) {
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
    public Material find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Path("material/{asignaturaId}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Material> findFromAsignatura(@PathParam("asignaturaId") Integer asignaturaId) {

        return (List<Material>) em.createQuery("SELECT m from Material m WHERE m.asignaturaId.asignaturaId = " + asignaturaId).getResultList();
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Material> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Material> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    //WIP https://stackoverflow.com/questions/10100936/file-downloading-in-restful-web-services\
    //Esto coge de la carpeta glassfish\domains\<Tu domain>\config
    @GET
    @Path("get/{filePath}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getFile(@PathParam("filePath")String filePath) {
        
        filePath = filePath.replace("_","/");
        
        File file = new File(filePath);
        return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM)
      .header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"" ) //optional
      .build();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
