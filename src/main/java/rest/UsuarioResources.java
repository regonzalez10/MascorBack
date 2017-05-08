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

/**
 *
 * @author Ricardo
 */
@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResources {
    
    @Inject
    private Iuser logic;
    
 
    
    //CRUD
    @POST
    public void createUsuario (UserDTO p )
    {
        System.out.println("Usuario: " + p.toString());
        logic.crearUsuario(p);
    }
    
  
    
    @GET
    @Path("/{idUsuario:\\d+}")
    public UserDTO getUsuario(@PathParam("idUsuario")Long idUsuario)
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
    @Path("{idUsuario:\\d+}")
    public UserDTO updateUsuario(@PathParam("idUsuario") Long idUsuario, UserDTO p)
    {
        return logic.modificarUsuario(idUsuario, p);
    }
    
    @DELETE
    @Path("{idUsuario:\\d+}/")
    public void deleteUsuario(@PathParam("idUsuario")Long idUsuario)
    {
        logic.eliminarUsuario(idUsuario);
        
    }
    
     @GET
    @Path("{idUsuario:\\d+}/perrosFavoritos")
    public List<DogDTO> getListaPerros (@PathParam("idUsuario") Long idUsuario)
    {
        
        List<DogDTO> l = logic.getPerrosUsuario(idUsuario);
       
        return l;
    }
    
       @POST
          @Path("{idUsuario:\\/")
    public void agregarPerro (@PathParam("idPerro") Long idUsuario,DogDTO p )
    {
        System.out.println("Usuario: " + p.toString());
        logic.agregarPerro(idUsuario, p);
    }
       @DELETE
    @Path("{idUsuario:\\/d+/idPerro:\\/d+}/")
    public void deletePerroEnLista(@PathParam("idUsuario")Long idUsuario,@PathParam("idPerro") Long idPerro)
    {
        logic.eliminarPerro(idUsuario,idPerro);
        
    }
   
    
}
