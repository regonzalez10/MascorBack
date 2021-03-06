/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.ejb;

import DTOS.DogDTO;
import DTOS.UserDTO;
import Entities.DogEntity;
import Entities.UsuarioEntity;
import Logic.interfaces.Idog;
import Logic.interfaces.Iuser;
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
public class userLogic implements Iuser 
    {
    
    @PersistenceContext(unitName = "mascorPU", type = PersistenceContextType.TRANSACTION)
    protected EntityManager em = Persistence.createEntityManagerFactory("mascorPU", System.getProperties()).createEntityManager();
    
  @Resource
            UserTransaction userTran;
            
    @Inject
    private Idog logic;
    
    public userLogic(){
    }
    
    @Override
    public UserDTO crearUsuario(UserDTO usuario)
    {
        try{
            userTran.begin();
            UsuarioEntity pe = usuario.toEntity();
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
    public UserDTO buscarUsuario(String id) {
        System.out.println("Logic " + id);
        return em.find(UsuarioEntity.class, id).toDTO();
    }
    
    @Override
    public List<UserDTO> darUsuarios() 
    {
        List<UserDTO> r = new ArrayList<>();
        
        Query q = em.createQuery("select u from UsuarioEntity u");
        List<UsuarioEntity> lista = q.getResultList();
        for (int i = 0; i < lista.size(); i++) 
        {
            r.add(lista.get(i).toDTO());
        }
        return r;
    }
    
    @Override
    public void eliminarUsuario(String id) {
        try{
        userTran.begin();
        em.remove(em.find(UsuarioEntity.class, id));
        userTran.commit();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
  
    
    public List<DogDTO> getPerrosUsuario(String idUsuario)
    {
        ArrayList r = new ArrayList<DogDTO>();
        
        UsuarioEntity p= em.find(UsuarioEntity.class,idUsuario);
     
        List<DogEntity> z = p.getPerros();
        for (int i = 0; i < z.size(); i++) {
            r.add(z.get(i).toDTO());
            
        }
      
        return r;
    }
    


    @Override
    public void agregarPerro(String id, String dog) {
         try{
             DogDTO perro = null;
            userTran.begin();
        UsuarioEntity usuario = em.find(UsuarioEntity.class, id);
            DogEntity prro = em.find(DogEntity.class, dog);            
        usuario.agregarPerro(prro);
        em.merge(usuario);
        userTran.commit();
        }
        catch(Exception e){

        }
    }

    @Override
    public void eliminarPerro(String id, String idPerro) {
         try{
            userTran.begin();
          UsuarioEntity usuario = em.find(UsuarioEntity.class, id);
          
        usuario.eliminarPerro(idPerro);
         em.merge(usuario);
      userTran.commit();
        }
        catch(Exception e){

        }
    }

    @Override
    public UserDTO modificarUsuario(String idUsuario, UserDTO p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    }
    


