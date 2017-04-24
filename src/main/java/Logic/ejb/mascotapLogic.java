/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.ejb;

import DTOS.DogDTO;
import DTOS.MascotapDTO;
import DTOS.UserDTO;
import Entities.DogEntity;
import Entities.MascotapEntity;
import Entities.UsuarioEntity;
import Logic.interfaces.Idog;
import Logic.interfaces.Imascotap;
import java.util.ArrayList;
import java.util.List;
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
public class mascotapLogic implements Imascotap {

    
    @PersistenceContext(unitName = "Oracle final", type = PersistenceContextType.TRANSACTION)
    protected EntityManager em = Persistence.createEntityManagerFactory("Oracle final", System.getProperties()).createEntityManager();
    
    @Resource
            UserTransaction userTran;
    
    @Inject
            mascotapLogic mascotapLogic;
    
    public mascotapLogic(){
    }
    
    @Override
    public MascotapDTO crearMascotap(MascotapDTO mascotap)
    {
        try{
            userTran.begin();
            MascotapEntity pe = mascotap.toEntity();
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
    public MascotapDTO buscarMascotap(Long id) {
        System.out.println("Logic " + id);
        return em.find(MascotapEntity.class, id).toDTODetail();
    }
    
    @Override
    public List<MascotapDTO> darMascotaps() 
    {
        List<MascotapDTO> r = new ArrayList<>();
        
        Query q = em.createQuery("select u from MascotapEntity u");
        List<MascotapEntity> lista = q.getResultList();
        for (int i = 0; i < lista.size(); i++) 
        {
            r.add(lista.get(i).toDTODetail());
        }
        return r;
    }


     @Override
    public void agregarPerro(Long id, DogDTO dog) {
        MascotapEntity mascotap = em.find(MascotapEntity.class, id);
        mascotap.agregarPerro(dog.toEntity());
        try{
            userTran.begin();
        em.merge(mascotap);
        userTran.commit();
        }
        catch(Exception e){

        }
    }

    @Override
    public void eliminarPerro(Long id) {
          MascotapEntity mascotap = em.find(MascotapEntity.class, id);
        mascotap.eliminarPerro(id);
        try{
            userTran.begin();
         em.merge(mascotap);
userTran.commit();
        }
        catch(Exception e){

        }
      
    }
    
     @Override
    public void agregarUsuario(Long id, UserDTO usuario) {
        MascotapEntity mascotap = em.find(MascotapEntity.class, id);
        mascotap.agregarUsuario(usuario.toEntity());
        try{
            userTran.begin();
        em.merge(mascotap);
userTran.commit();
        }
        catch(Exception e){

        }
    }

    @Override
    public void eliminarUsuario(Long id) {
          MascotapEntity mascotap = em.find(MascotapEntity.class, id);
try{
            userTran.begin();
        mascotap.eliminarUsuario(id);
         em.merge(mascotap);
userTran.commit();
        }
        catch(Exception e){

        }
      
    }

 
    
    
    
}
