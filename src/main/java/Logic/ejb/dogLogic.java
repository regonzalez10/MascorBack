/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.ejb;

import DTOS.DogDTO;
import DTOS.UserDTO;

import Entities.DogEntity;

import Logic.interfaces.Idog;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

/**
 *
 * @author Ricardo
 */
 @Singleton  
public class dogLogic implements Idog {

    
    @PersistenceContext(unitName = "mascorPU", type = PersistenceContextType.TRANSACTION)
    protected EntityManager em = Persistence.createEntityManagerFactory("mascorPU", System.getProperties()).createEntityManager();
    
    @Resource
            UserTransaction userTran;
    
    public dogLogic(){
    }
    
    @Override
    public DogDTO crearPerro(DogDTO dog)
    {
        try{
           userTran.begin();
            DogEntity pe = dog.toEntity();
            System.out.println("Id antes " + pe.getId());
            em.persist(pe);
            userTran.commit();
            System.out.println("Id despues " + pe.getId());
            return pe.toDTO();
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }
    
    @Override
    public DogDTO buscarPerro(String id) {
        System.out.println("Logic " + id);
        DogEntity dog = em.find(DogEntity.class,id);
        if(dog!= null)
        return em.find(DogEntity.class, id).toDTO();
        else
            Logger.getLogger(dogLogic.class.getName()).log(Level.SEVERE, "No se ha encontrado el perro");
        return null;
        }
    
    @Override
    public List<DogDTO> darPerros() 
    {
        List<DogDTO> r = new ArrayList<>();
        
        Query q = em.createQuery("select u from DogEntity u");
        List<DogEntity> lista = q.getResultList();
        for (int i = 0; i < lista.size(); i++) 
        {
            r.add(lista.get(i).toDTO());
        }
        return r;
    }
    
    @Override
    public void eliminarPerro(String id) {
        try{
        userTran.begin();
        em.remove(em.find(DogEntity.class, id));
        userTran.commit();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public DogDTO modificarPerro(String idPerro, UserDTO p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
