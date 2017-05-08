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
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.NoSql;
import uk.co.jemos.podam.common.PodamExclude;


/**
 *
 * @author Ricardo
 */
@Entity
@NoSql(dataFormat=DataFormatType.MAPPED)
public class MascotapEntity implements Serializable
{

    @Id
    @GeneratedValue
    private Long id;

    @Basic
    private String localidad;
 
    @ElementCollection
    private List<DogEntity> perros = new ArrayList<>();
    
    @ElementCollection
    private List<UsuarioEntity> usuarios = new ArrayList<>();

    public MascotapEntity() {
    }

    public MascotapEntity(Long id, List<DogEntity> perros, List<UsuarioEntity> usuarios) {
        this.id = id;
        this.perros = perros;
        this.usuarios = usuarios;
    }
    public Long getId(){
        return id;
    }
   

    public List<DogEntity> getPerros() {
        return perros;
    }

    public void setPerros(List<DogEntity> perros) {
        this.perros = perros;
    }

    public List<UsuarioEntity> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuarioEntity> usuarios) {
        this.usuarios = usuarios;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
 
 
 public MascotapDTO toDTO() {
         ArrayList<DogDTO> pPerros = new ArrayList<DogDTO>();
        if(perros != null)
        {
            for(int i = 0; i < perros.size(); i++){
                pPerros.add(perros.get(i).toDTO());
            }
        }
           ArrayList<UserDTO> pUsuarios = new ArrayList<UserDTO>();
        if(usuarios != null)
        {
            for(int i = 0; i < usuarios.size(); i++){
                pUsuarios.add(usuarios.get(i).toDTO());
            }
        }
        MascotapDTO p = new MascotapDTO(localidad);
        p.setDogList(pPerros);
        p.setUserList(pUsuarios);
        p.setId(id);
   
        
        return p;
    }

    public MascotapDTO toDTODetail() {
          return new MascotapDTO(localidad);
    }

        
    public void agregarPerro(DogEntity toEntity) {
        perros.add(toEntity);
    }
    public void eliminarPerro(Long id) {
        perros.remove(id);
    }

          
    public void agregarUsuario(UsuarioEntity toEntity) {
        usuarios.add(toEntity);
    }
    public void eliminarUsuario(Long id) {
        usuarios.remove(id);
    }
    
}
