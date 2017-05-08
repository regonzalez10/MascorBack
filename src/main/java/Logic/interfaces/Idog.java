/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.interfaces;

import DTOS.DogDTO;
import DTOS.UserDTO;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public interface Idog {
    
    public DogDTO crearPerro(DogDTO perro);
    
    public DogDTO buscarPerro(Long id);
    
    public List<DogDTO> darPerros();
    
    public void eliminarPerro(Long id);

    public DogDTO modificarPerro(Long idPerro, UserDTO p);

    
    
}
