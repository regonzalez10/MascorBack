/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import DTOS.DogDTO;
import DTOS.UserDTO;
import Logic.interfaces.Idog;
import Logic.interfaces.Iuser;
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

/**
 *
 * @author Ricardo
 */
@Path("/perros")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PerrosResources {
    
    @Inject
    private Idog logic;
    
 
    
    //CRUD
    @POST
    public void createPerro (DogDTO p )
    {
        System.out.println("Perro: " + p.toString());
        logic.crearPerro(p);
    }
    
  
    
    @GET
    @Path("/{idPerro:\\d+}")
    public DogDTO getPerro(@PathParam("idPerro")Long idPerro)
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
    @Path("{idPerro:\\d+}")
    public DogDTO updatePerro(@PathParam("idPerro") Long idPerro, UserDTO p)
    {
        return logic.modificarPerro(idPerro, p);
    }
    
    @DELETE
    @Path("{idPerro:\\d+}/")
    public void deleteUsuario(@PathParam("idPerro")Long idPerro)
    {
        logic.eliminarPerro(idPerro);
        
    }
    
}
