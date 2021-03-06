/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.repository;

import com.grupo2.entity.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

/**
 *
 * @author ccolome
 */
@Service
public class UsuarioRepositoryImpl implements UsuarioRepository {

    private static final Logger LOG = LogManager.getLogger(UsuarioRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Boolean registrar(Usuario objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario obtener(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario obtener(String username) {
        LOG.info("INICIO OBTENER USUARIO");
        Usuario usuario = new Usuario();
        try {
            Query query = entityManager.createQuery("FROM Usuario U WHERE U.username = :username");
            query.setParameter("username", username);
            usuario = (Usuario) query.getSingleResult();
        } catch (DataIntegrityViolationException ex) {
            LOG.error("Ocurrió un error al obtener usuario: " + ex);
        } catch (Exception e) {
            LOG.error("Ocurrió un error al obtener usuario: " + e);
        }
        LOG.info("FIN OBTENER USUARIO");
        return usuario;
    }

    @Override
    public Boolean actualizar(Usuario objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
