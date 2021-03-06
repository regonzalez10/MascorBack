/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import DTOS.DogDTO;
import DTOS.UserDTO;
import Logic.ejb.dogLogic;
import Logic.interfaces.Idog;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import javax.inject.Inject;
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

/**
 *
 * @author Ricardo
 */
@Path("/perros")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PerrosResources {
    
    @Inject
    private Idog logic;
    
 
    
    //CRUD
    @POST
    public Response createPerro (DogDTO p )
    {
        Logger.getLogger(dogLogic.class.getName()).log(Level.SEVERE, "Crealo pls");
        DogDTO prro =logic.crearPerro(p);
        return Response.status(201).entity(prro).build();
    }
    
    @GET
    @Path("/{idPerro}")
    public DogDTO getPerro(@PathParam("idPerro")String idPerro)
    {
        System.out.println("Resources " + idPerro);
        return logic.buscarPerro(idPerro);
    }
    
    @GET
    public List<DogDTO> getPerros()
    {

        return logic.darPerros();
    }
            
    @PUT
    @Path("{idPerro}")
    public DogDTO updatePerro(@PathParam("idPerro") String idPerro, UserDTO p)
    {
        return logic.modificarPerro(idPerro, p);
    }
    
    @DELETE
    @Path("{idPerro}")
    public void deleteUsuario(@PathParam("idPerro")String idPerro)
    {
        logic.eliminarPerro(idPerro);
        
    }
    
}
