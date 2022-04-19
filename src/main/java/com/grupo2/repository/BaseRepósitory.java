/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.repository;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ccolome
 */
@Repository
public interface BaseRepósitory<T, ID> {
    
    Integer registrar(T objeto);
    
    List<T> listar();
    
    T obtener(ID id);
    
    Integer actualizar(ID id);
    
    Integer eliminar(ID id);
}
