/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import DTOS.AlertaDTO;
import DTOS.UserDTO;
import Logic.ejb.dogLogic;
import Logic.interfaces.IAlerta;
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
@Path("/usuario/{idUsuario}/alertas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AlertasResources {
    
    @Inject
    private IAlerta logic;
   
    //CRUD
    @POST
    public Response createAlerta (AlertaDTO p, @PathParam("idUsuario") String idUsuario )
    {
        Logger.getLogger(dogLogic.class.getName()).log(Level.SEVERE, "Crealo pls");
        AlertaDTO prro =logic.crearAlerta(p,idUsuario);
        return Response.status(201).entity(prro).build();
    }
    
    @GET
    @Path("/{idAlerta}")
    public AlertaDTO getAlerta(@PathParam("idAlerta")String idAlerta)
    {
        System.out.println("Resources " + idAlerta);
        return logic.buscarAlerta(idAlerta);
    }
    
    @GET
    public List<AlertaDTO> getAlertas()
    {

        return logic.darAlertas();
    }
            
    @PUT
    @Path("{idAlerta}")
    public AlertaDTO updateAlerta(@PathParam("idAlerta") String idAlerta, UserDTO p)
    {
        return logic.modificarAlerta(idAlerta, p);
    }
    
}
