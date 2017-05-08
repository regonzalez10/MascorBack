/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.interfaces;

import DTOS.AlertaDTO;
import DTOS.UserDTO;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public interface IAlerta {
    
    public AlertaDTO crearAlerta(AlertaDTO perro, String usuario);
    
    public AlertaDTO buscarAlerta(String id);
    
    public List<AlertaDTO> darAlertas();
    
    public void eliminarAlerta(String id);

    public AlertaDTO modificarAlerta(String idAlerta, UserDTO p);

    
    
}
