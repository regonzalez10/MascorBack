/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.interfaces;

import DTOS.DogDTO;
import DTOS.UserDTO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public interface Iuser {
    
    public UserDTO crearUsuario(UserDTO usuario);
    
    public UserDTO buscarUsuario(String id);
    
    public List<UserDTO> darUsuarios();
    
    public void eliminarUsuario(String id);

    public List<DogDTO> getPerrosUsuario(String idPaciente);
    
    public void agregarPerro(String id, String dog);
    
    public void eliminarPerro(String id, String idPerro);

    public UserDTO modificarUsuario(String idUsuario, UserDTO p);
    
}
