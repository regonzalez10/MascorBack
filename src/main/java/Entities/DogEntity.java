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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author Ricardo
 */
@Entity
public class DogEntity extends BaseEntity implements Serializable
{

    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="perros_seq_gen")
    @SequenceGenerator(name="perros_seq_gen", sequenceName="PERROS_SEQU")
    private Long id;
 
    private String race;
    private String name;
    private Long age;
    private String description;
    private Long health;
    
    
    
    @ManyToOne
    @PodamExclude
    private MascotapEntity mascotap;
    
    
    
    
    public DogEntity()
    {
        
    }

    public DogEntity(String race, String name, long age, String description, long health, MascotapEntity mascotap) {
        this.race = race;
        this.name = name;
        this.age = age;
        this.description = description;
        this.health = health;
        this.mascotap = mascotap;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getHealth() {
        return health;
    }

    public void setHealth(long health) {
        this.health = health;
    }
    
  
    public MascotapEntity getMascotap() {
        return mascotap;
    }
    
    public void setMascotap(MascotapEntity mascotap) {
        this.mascotap = mascotap;
    }
       
          
    public DogDTO toDTO()
    {
       MascotapDTO pMascotap = null;
        if(mascotap != null){
            pMascotap = mascotap.toDTO();
        }
       
        DogDTO p = new DogDTO(race, name, age, health, pMascotap);
        
        p.setId(id);
   
        
        return p;
    }

    @Override
    public String toString() {
        return "'";
    }

   

    public DogDTO toDTODetail() 
    {
        return new DogDTO(race, name, age, health, mascotap.toDTO());
    }

    
}
