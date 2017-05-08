/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import DTOS.DogDTO;
import DTOS.MascotapDTO;
import DTOS.UserDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.ElementCollection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.SequenceGenerator;
import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author Ricardo
 */
@Entity
@NoSql(dataFormat=DataFormatType.MAPPED)
public class UsuarioEntity implements Serializable
{

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public Long getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Long puntaje) {
        this.puntaje = puntaje;
    }

    public MascotapEntity getMascotap() {
        return mascotap;
    }

    public void setMascotap(MascotapEntity mascotap) {
        this.mascotap = mascotap;
    }

     
    @Id
    @GeneratedValue
    @Field(name="_id")
    private String id;
    
    @Basic
    private String nombre;
    @Basic
    private String apellido;
    @Basic
    private String email;
    @Basic
    private String password;
    @Basic
    private String tipo;
     @Basic
    private String localidad;
    @Basic
    private String contacto;
    @Basic
    private Long puntaje;
    
    @ElementCollection
    private List<DogEntity> perros;
    
    @ManyToOne
    private MascotapEntity mascotap;
    
    
    public UsuarioEntity()
    {
        perros = new ArrayList<>();
    }

    public UsuarioEntity(String nombre, String apellido, String email, String password, String tipo, String localidad, String contacto, Long puntaje, List<DogEntity> perros, MascotapEntity mascotap) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.tipo = tipo;
        this.localidad = localidad;
        this.contacto = contacto;
        this.puntaje = puntaje;
        this.perros = perros;
        this.mascotap = mascotap;
    }

     public UsuarioEntity(String nombre, String apellido, String email, String password, String tipo, String localidad, String contacto, Long puntaje, MascotapEntity mascotap) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.tipo = tipo;
        this.localidad = localidad;
        this.contacto = contacto;
        this.puntaje = puntaje;
        this.perros = new ArrayList<DogEntity>();
        this.mascotap = mascotap;
    }
public String getId(){
        return id;
    }
public void setId(String id){
    this.id=id;
}

  
    
  
    

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public List<DogEntity> getPerros() {
        return perros;
    }
    
    public void setPerros(List<DogEntity> perros) {
        this.perros = perros;
    }
        
    public void agregarPerro(DogEntity toEntity) {
        perros.add(toEntity);
    }
    public void eliminarPerro(String id){
        for(int i = 0; i < perros.size();i++){
            DogEntity actual = perros.get(i);
            if(actual.getId().equals(id)){
                perros.remove(actual);
            }
        }
    }
          
    public UserDTO toDTO()
    {
        ArrayList<DogDTO> pPerros = new ArrayList<DogDTO>();
        if(perros != null)
        {
            for(int i = 0; i < perros.size(); i++){
                pPerros.add(perros.get(i).toDTO());
            }
        }
        MascotapDTO pMascotap = null;
        if(mascotap != null){
            pMascotap = mascotap.toDTO();
        }
      
        UserDTO p = new  UserDTO(tipo, nombre, apellido, email, password, localidad, contacto, puntaje, pMascotap);
        p.setPerros(pPerros);
        p.setId(id);
   
        
        return p;
    }

    @Override
    public String toString() {
        return "'";
    }


    
}
