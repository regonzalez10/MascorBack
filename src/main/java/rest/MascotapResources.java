/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import DTOS.DogDTO;
import DTOS.MascotapDTO;
import DTOS.UserDTO;
import Logic.interfaces.Imascotap;
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
import javax.ws.rs.core.Response;

/**
 *
 * @author Ricardo
 */
@Path("/mascotap")
@Produces("application/json")
@Consumes(MediaType.APPLICATION_JSON)
public class MascotapResources {
    
    @Inject
    private Imascotap logic;
    
 
    
    //CRUD
    @POST
    public Response createMascotap (MascotapDTO p )
    {
        System.out.println("Mascotap: " + p.toString());
        MascotapDTO masco = logic.crearMascotap(p);
        return Response.status(201).entity(masco).build();
    }
    
  
    
    @GET
    @Path("/{idMascotap}")
    public MascotapDTO getMascotap(@PathParam("idMascotap")String idMascotap)
    {
        System.out.println("Resources " + idMascotap);
        return logic.buscarMascotap(idMascotap);
    }
    
    @GET
    public List<MascotapDTO> getMascotaps()
    {

        return logic.darMascotaps();
    }
            
    
    
       @POST
          @Path("{idMascotap}/perro/{idPerro}")
    public void agregarPerro (@PathParam("idMascotap") String idMascotap,@PathParam("idPerro") String idPerro )
    {
        System.out.println("Mascotap: " + idMascotap);
        logic.agregarPerro(idMascotap, idPerro);
    }
       @DELETE
    @Path("{idMascotap}/perro/{idPerro}")
    public void deletePerroEnLista(@PathParam("idMascotap")String idMascotap,@PathParam("idPerro") String idPerro)
    {
        logic.eliminarPerro(idMascotap,idPerro);
        
    }
    
       @POST
          @Path("{idMascotap}/usuario/{idUsuario}")
    public void agregarUsuario (@PathParam("idMascotap") String idMascotap,@PathParam("idUsuario")String idUsuario )
    {
        System.out.println("Mascotap: " + idMascotap);
        logic.agregarUsuario(idMascotap, idUsuario);
    }
       @DELETE
    @Path("{idMascotap}/usuario/{idUsuario}")
    public void deleteUsuarioEnLista(@PathParam("idMascotap")String idMascotap,@PathParam("idUsuario") String idUsuario)
    {
        logic.eliminarUsuario(idMascotap,idUsuario);
        
    }
}
