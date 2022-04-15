/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo3.repository;

import java.util.List;

/**
 *
 * @author ccolome
 */
public interface BaseRepósitory<T, ID> {
    
    Integer registrar(T objeto);
    
    List<T> listar();
    
    T obtener(ID id);
    
    Integer actualizar(ID id);
    
    Integer eliminar(ID id);
}
