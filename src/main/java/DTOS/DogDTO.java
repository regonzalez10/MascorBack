/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOS;

import Entities.DogEntity;
import Entities.MascotapEntity;

/**
 *
 * @author Ricardo
 */
public class DogDTO extends BaseDTO 
{
    private String race;
    private String name;
    private Long age;
    private String description;
    private Long health;
    private MascotapDTO mascotap;

    public DogDTO(String race, String name, Long age, Long health, MascotapDTO mascotap) {
        this.race = race;
        this.name = name;
        this.age = age;
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

    public void setAge(Long age) {
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

    public void setHealth(Long health) {
        this.health = health;
    }

    public MascotapDTO getMascotap() {
        return mascotap;
    }

    public void setMascotap(MascotapDTO mascotap) {
        this.mascotap = mascotap;
    }

    public DogEntity toEntity() {
  
          MascotapEntity mas =null;
        if(mascotap!=null)
        {
            mas=mascotap.toEntity();
        }
        DogEntity ent = new DogEntity(race, name, age, description, health, mas);
        
//        ent.setId(id);
        
        return ent;
    }
    
    
}
