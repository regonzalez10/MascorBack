/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOS;

import Entities.AlertaEntity;
import Entities.MascotapEntity;
import Entities.UsuarioEntity;

/**
 *
 * @author Ricardo
 */
public class AlertaDTO extends BaseDTO 
{
    private String titulo;
    private String descripcion;
    private Double longitud;
    private Double latitud;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
    private UserDTO user;

    public AlertaDTO(String titulo, String descripcion, Double latitud, Double longitud, UserDTO usuario) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.user = usuario;
    }
    public AlertaDTO(){
        
    }

    public AlertaEntity toEntity() {
  
          UsuarioEntity us =null;
        if(user!=null)
        {
            us=user.toEntity();
        }
        AlertaEntity ent = new AlertaEntity(titulo, descripcion, latitud, longitud, us);
        ent.setId(id);
        
        return ent;
    }
    
    
}
