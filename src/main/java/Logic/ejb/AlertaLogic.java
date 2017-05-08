/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.ejb;

import DTOS.AlertaDTO;
import DTOS.DogDTO;
import DTOS.UserDTO;

import Entities.AlertaEntity;
import Entities.UsuarioEntity;
import Logic.interfaces.IAlerta;

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
public class AlertaLogic implements IAlerta {

    
    @PersistenceContext(unitName = "mascorPU", type = PersistenceContextType.TRANSACTION)
    protected EntityManager em = Persistence.createEntityManagerFactory("mascorPU", System.getProperties()).createEntityManager();
    
    @Resource
            UserTransaction userTran;
    
    public AlertaLogic(){
    }
    
    @Override
    public AlertaDTO crearAlerta(AlertaDTO dog, String usuario)
    {
        try{
           userTran.begin();
            AlertaEntity pe = dog.toEntity();
            pe.setUsuario(em.find(UsuarioEntity.class, usuario));
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
    public AlertaDTO buscarAlerta(String id) {
        System.out.println("Logic " + id);
        AlertaEntity dog = em.find(AlertaEntity.class,id);
        if(dog!= null)
        return em.find(AlertaEntity.class, id).toDTO();
        else
            Logger.getLogger(AlertaLogic.class.getName()).log(Level.SEVERE, "No se ha encontrado el perro");
        return null;
        }
    
    @Override
    public List<AlertaDTO> darAlertas() 
    {
        List<AlertaDTO> r = new ArrayList<>();
        
        Query q = em.createQuery("select u from AlertaEntity u");
        List<AlertaEntity> lista = q.getResultList();
        for (int i = 0; i < lista.size(); i++) 
        {
            r.add(lista.get(i).toDTO());
        }
        return r;
    }
    
    @Override
    public void eliminarAlerta(String id) {
        try{
        userTran.begin();
        em.remove(em.find(AlertaEntity.class, id));
        userTran.commit();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public AlertaDTO modificarAlerta(String idAlerta, UserDTO p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
