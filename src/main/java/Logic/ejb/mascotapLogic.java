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

    
    @PersistenceContext(unitName = "mascorPU", type = PersistenceContextType.TRANSACTION)
    protected EntityManager em = Persistence.createEntityManagerFactory("mascorPU", System.getProperties()).createEntityManager();
    
    @Resource
            UserTransaction userTran;
    
    
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
    public MascotapDTO buscarMascotap(String id) {
        System.out.println("Logic " + id);
        return em.find(MascotapEntity.class, id).toDTO();
    }
    
    @Override
    public List<MascotapDTO> darMascotaps() 
    {
        List<MascotapDTO> r = new ArrayList<>();
        
        Query q = em.createQuery("select u from MascotapEntity u");
        List<MascotapEntity> lista = q.getResultList();
        for (int i = 0; i < lista.size(); i++) 
        {
            r.add(lista.get(i).toDTO());
        }
        return r;
    }


     @Override
    public void agregarPerro(String id, String dog) {
        MascotapEntity mascotap = em.find(MascotapEntity.class, id);
        DogEntity doggo = em.find(DogEntity.class, dog);
        mascotap.agregarPerro(doggo);
        try{
            userTran.begin();
        em.merge(mascotap);
        
        userTran.commit();
        }
        catch(Exception e){

        }
    }

    @Override
    public void eliminarPerro(String id,String idperro) {
          MascotapEntity mascotap = em.find(MascotapEntity.class, id);
        mascotap.eliminarPerro(idperro);
        try{
            userTran.begin();
         em.merge(mascotap);
userTran.commit();
        }
        catch(Exception e){

        }
      
    }
    
     @Override
    public void agregarUsuario(String id, String usuario) {
        MascotapEntity mascotap = em.find(MascotapEntity.class, id);
        UsuarioEntity user = em.find(UsuarioEntity.class, usuario);
        mascotap.agregarUsuario(user);
        try{
            userTran.begin();
        em.merge(mascotap);
userTran.commit();
        }
        catch(Exception e){

        }
    }

    @Override
    public void eliminarUsuario(String id, String idusuario) {
          MascotapEntity mascotap = em.find(MascotapEntity.class, id);
try{
            userTran.begin();
        mascotap.eliminarUsuario(idusuario);
         em.merge(mascotap);
userTran.commit();
        }
        catch(Exception e){

        }
      
    }

 
    
    
    
}
