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

/**
 *
 * @author Ricardo
 */
@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MascotapResources {
    
    @Inject
    private Imascotap logic;
    
 
    
    //CRUD
    @POST
    public void createMascotap (MascotapDTO p )
    {
        System.out.println("Usuario: " + p.toString());
        logic.crearMascotap(p);
    }
    
  
    
    @GET
    @Path("/{idMascotap:\\d+}")
    public MascotapDTO getMascotap(@PathParam("idMascotap")Long idMascotap)
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
          @Path("{idMascotap:\\/")
    public void agregarPerro (@PathParam("idMascotap") Long idMascotap,DogDTO p )
    {
        System.out.println("Mascotap: " + p.toString());
        logic.agregarPerro(idMascotap, p);
    }
       @DELETE
    @Path("{idMascotap:\\/d+/idPerro:\\/d+}/")
    public void deletePerroEnLista(@PathParam("idMascotap")Long idMascotap,@PathParam("idPerro") Long idPerro)
    {
        logic.eliminarPerro(idMascotap,idPerro);
        
    }
    
       @POST
          @Path("{idMascotap:\\/")
    public void agregarUsuario (@PathParam("idMascotap") Long idMascotap,UserDTO p )
    {
        System.out.println("Mascotap: " + p.toString());
        logic.agregarUsuario(idMascotap, p);
    }
       @DELETE
    @Path("{idMascotap:\\/d+/idUsuario:\\/d+}/")
    public void deleteUsuarioEnLista(@PathParam("idMascotap")Long idMascotap,@PathParam("idUsuario") Long idUsuario)
    {
        logic.eliminarUsuario(idMascotap,idUsuario);
        
    }
}
