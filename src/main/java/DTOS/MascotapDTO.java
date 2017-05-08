/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOS;

import Entities.DogEntity;
import Entities.MascotapEntity;
import Entities.UsuarioEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public class MascotapDTO extends BaseDTO{
    
     private List<DogDTO> dogList;
     
     private List<UserDTO> userList;
     
     private String localidad;

    public MascotapDTO(String localidad) {
       this.dogList = new ArrayList<DogDTO>();
       this.userList = new ArrayList<UserDTO>();
       this.localidad = localidad;
    }
    public MascotapDTO(){
        
    }

    public List<DogDTO> getDogList() {
        return dogList;
    }

    public void setDogList(List<DogDTO> dogList) {
        this.dogList = dogList;
    }

    public List<UserDTO> getUserList() {
        return userList;
    }

    public void setUserList(List<UserDTO> userList) {
        this.userList = userList;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
     
        public void addDog(DogDTO dog)
    {
        dogList.add(dog);
    }
    
    public void removeDog(Long id)
    {
        dogList.remove(id);
    }
    
    public void addUsuario(UserDTO usuario)
    {
        userList.add(usuario);
    }
    
    public void removeUsuario(Long id)
    {
        userList.remove(id);
    }

    
    public List<DogEntity> perrosEntities(){
        ArrayList<DogEntity> nPerros = new ArrayList<DogEntity>();
        if(dogList != null){
            for(int i = 0; i < dogList.size(); i++){
                nPerros.add(dogList.get(i).toEntity());
            }
        }
        return nPerros;
    }
      
    public List<UsuarioEntity> usuariosEntities(){
        ArrayList<UsuarioEntity> nUsuarios = new ArrayList<UsuarioEntity>();
        if(userList != null){
            for(int i = 0; i < userList.size(); i++){
                nUsuarios.add(userList.get(i).toEntity());
            }
        }
        return nUsuarios;
    }
        
        
    public MascotapEntity toEntity() {
   
      
        MascotapEntity ent = new MascotapEntity(id,localidad, perrosEntities(), usuariosEntities());
       ent.setId(id);
        
        return ent;
    }
     
     
     
}
