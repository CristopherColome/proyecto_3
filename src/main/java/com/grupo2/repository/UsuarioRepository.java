/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.repository;

import com.grupo2.entity.Usuario;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ccolome
 */
@Repository
public interface UsuarioRepository extends BaseRepósitory<Usuario, Integer>{
    
    Usuario obtener(String username);
    
}
