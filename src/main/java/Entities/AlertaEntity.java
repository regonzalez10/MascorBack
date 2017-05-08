/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import DTOS.AlertaDTO;
import DTOS.UserDTO;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;
import javax.persistence.ManyToOne;

/**
 *
 * @author ce.gonzalez13
 */

@Entity    

@NoSql(dataFormat=DataFormatType.MAPPED)
public class AlertaEntity implements Serializable
{

    @Id
    @GeneratedValue
    @Field(name="_id")
    private String id;

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

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

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }
 
    @Basic
    private Double latitud;
    @Basic
    private Double longitud;
    @Basic
    private String titulo;
    @Basic
    private String descripcion;  
    
    @ManyToOne
    private UsuarioEntity usuario;
    
    public AlertaEntity()
    {
        
    }

    public AlertaEntity(String titulo, String descripcion, Double latitud, Double longitud, UsuarioEntity usuario) {
      this.titulo = titulo;
      this.descripcion = descripcion;
      this.latitud = latitud;
      this.longitud = longitud;
      this.usuario = usuario;
    }

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
   
    public AlertaDTO toDTO()
    {
       UserDTO pUsuario = null;
        if(usuario != null){
            pUsuario = usuario.toDTO();
        }
       
        AlertaDTO p = new AlertaDTO(titulo, descripcion, latitud, longitud, pUsuario);
        
        p.setId(id);
   
        
        return p;
    }

    @Override
    public String toString() {
        return "'";
    }

   

}

