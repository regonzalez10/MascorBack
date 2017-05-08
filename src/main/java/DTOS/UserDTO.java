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
public class UserDTO extends BaseDTO

{
    
   
    private String tipo;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String localidad;
    private String contacto;
    private Long puntaje;
    private List<DogDTO> perros;
    private MascotapDTO mascotap;

    public UserDTO(String tipo, String nombre, String apellido, String email, String password, String localidad, String contacto, Long puntaje, MascotapDTO mascotap) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.localidad = localidad;
        this.contacto = contacto;
        this.puntaje = puntaje;
         this.perros = new ArrayList<DogDTO>();
        this.mascotap = mascotap;
    }
    public UserDTO(){
        
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

     
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<DogDTO> getPerros() {
        return perros;
    }

    public void setPerros(List<DogDTO> perros) {
        this.perros = perros;
    }

    public MascotapDTO getMascotap() {
        return mascotap;
    }

    public void setMascotap(MascotapDTO mascotap) {
        this.mascotap = mascotap;
    }

    public void addDog(DogDTO dog)
    {
        perros.add(dog);
    }
    
    public void removeDog(Long id)
    {
        perros.remove(id);
    }

        public List<DogEntity> perrosEntities(){
        ArrayList<DogEntity> nPerros = new ArrayList<DogEntity>();
        if(perros != null){
            for(int i = 0; i < perros.size(); i++){
                nPerros.add(perros.get(i).toEntity());
            }
        }
        return nPerros;
    }
    public UsuarioEntity toEntity() {
        MascotapEntity mas =null;
        if(mascotap!=null)
        {
            mas=mascotap.toEntity();
        }
      
        UsuarioEntity ent = new UsuarioEntity(nombre, apellido, email, password, tipo, localidad, contacto, puntaje,perrosEntities(), mas);
        ent.setId(id);
        
        return ent;
    }
    
}
