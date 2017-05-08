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
import javax.persistence.Embeddable;
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
public class DogEntity implements Serializable
{

    
    @Id
    @GeneratedValue
    @Field(name="_id")
    private String id;
 
    @Basic
    private String race;
    @Basic
    private String name;
    @Basic
    private Long age;
    @Basic
    private String description;
    @Basic
    private Long health;
    @Basic
    private String url;
    @Basic
    private Long numContacto;
    
    @ManyToOne
    private MascotapEntity mascotap;
    
    
    
    
    public DogEntity()
    {
        
    }

    public DogEntity(String race, String name, Long age, String description, Long health,String url, Long numContacto, MascotapEntity mascotap) {
        this.race = race;
        this.name = name;
        this.age = age;
        this.description = description;
        this.health = health;
        this.mascotap = mascotap;
        this.url = url;
        this.numContacto = numContacto;
       
    }

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
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

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getHealth() {
        return health;
    }

    public void setHealth(Long health) {
        this.health = health;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getNumContacto() {
        return numContacto;
    }

    public void setNumContacto(Long numContacto) {
        this.numContacto = numContacto;
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
       
        DogDTO p = new DogDTO(race, name,description, age, health,url, numContacto, pMascotap);
        
        p.setId(id);
   
        
        return p;
    }

    @Override
    public String toString() {
        return "'";
    }

   

   
}
