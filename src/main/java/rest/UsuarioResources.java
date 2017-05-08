/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import DTOS.DogDTO;
import DTOS.UserDTO;
import Logic.interfaces.Iuser;
import java.util.Date;
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
@Path("/usuario")
@Produces("application/json")
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResources {
    
    @Inject
    private Iuser logic;
    
 
    
    //CRUD
    @POST
    public Response createUsuario (UserDTO p )
    {
        System.out.println("Usuario: " + p.toString());
        UserDTO us = logic.crearUsuario(p);
        return Response.status(201).entity(us).build();
    }
    
  
    
    @GET
    @Path("/{idUsuario}")
    public UserDTO getUsuario(@PathParam("idUsuario")String idUsuario)
    {
        System.out.println("Resources " + idUsuario);
        return logic.buscarUsuario(idUsuario);
    }
    
    @GET
    public List<UserDTO> getUsuarios()
    {

        return logic.darUsuarios();
    }
            
    @PUT
    @Path("{idUsuario}")
    public UserDTO updateUsuario(@PathParam("idUsuario") String idUsuario, UserDTO p)
    {
        return logic.modificarUsuario(idUsuario, p);
    }
    
    @DELETE
    @Path("{idUsuario}")
    public void deleteUsuario(@PathParam("idUsuario")String idUsuario)
    {
        logic.eliminarUsuario(idUsuario);
        
    }
    
     @GET
    @Path("{idUsuario}/perrosFavoritos")
    public List<DogDTO> getListaPerros (@PathParam("idUsuario") String idUsuario)
    {
        
        List<DogDTO> l = logic.getPerrosUsuario(idUsuario);
       
        return l;
    }
    
       @POST
          @Path("{idUsuario}/perro/{idPerro}")
    public Response agregarPerro (@PathParam("idUsuario") String idUsuario,@PathParam("idPerro") String idPerro )
    {
        System.out.println("Usuario: " + idUsuario);
        logic.agregarPerro(idUsuario, idPerro);
        return Response.status(201).entity(getUsuario(idUsuario)).build();
    }
       @DELETE
    @Path("{idUsuario}/{idPerro}/")
    public void deletePerroEnLista(@PathParam("idUsuario")String idUsuario,@PathParam("idPerro") String idPerro)
    {
        logic.eliminarPerro(idUsuario,idPerro);
        
    }
   
    
}
