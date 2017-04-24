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
    
    public MascotapDTO buscarMascotap(Long id);
    
    public List<MascotapDTO> darMascotaps();
    
    public void eliminarUsuario(Long id);
    
    public void agregarPerro(Long id, DogDTO dog);
    
    public void eliminarPerro(Long id);
    
    public void agregarUsuario(Long id, UserDTO usuario);
    
}
