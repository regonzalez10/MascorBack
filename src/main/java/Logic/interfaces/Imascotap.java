/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.interfaces;

import DTOS.DogDTO;
import DTOS.MascotapDTO;
import DTOS.UserDTO;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public interface Imascotap {
    
    public MascotapDTO crearMascotap(MascotapDTO  mascotap);
    
    public MascotapDTO buscarMascotap(String id);
    
    public List<MascotapDTO> darMascotaps();
    
    public void eliminarUsuario(String id, String idusuario);
    
    public void agregarPerro(String id, String dog);
    
    public void eliminarPerro(String id,String idperro);
    
    public void agregarUsuario(String id, String usuario);
    
}
