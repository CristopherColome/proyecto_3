/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.repository;

import com.grupo2.entity.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ccolome
 */
@Service
public class ProductoRepositoryImpl implements ProductoRepository {

    private static final Logger LOG = LogManager.getLogger(ProductoRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Boolean registrar(Producto objeto) {
        LOG.info("INICIO DE REGISTRO PRODUCTO");
        Boolean resultado = false;
        try {
            entityManager.persist(objeto);
            resultado = true;
            LOG.info("Se registró correctamente el producto.");
        } catch (DataIntegrityViolationException ex) {
            LOG.error("Ocurrió un error al insertar producto : " + ex);
        } catch (Exception e) {
            LOG.error("Ocurrió un error al insertar producto : " + e);
        }
        LOG.info("FIN DE REGISTRO PRODUCTO");
        return resultado;
    }

    @Override
    @Transactional
    public List<Producto> listar() {
        LOG.info("INICIO DE LISTAR PRODUCTOS");
        List<Producto> productos = new ArrayList<Producto>();
        try {
            productos = entityManager.createQuery("SELECT P FROM Producto P", Producto.class).getResultList();
            LOG.info("Se obtuvo correctamente los productos.");
        } catch (DataIntegrityViolationException ex) {
            LOG.error("Ocurrió un error al listar productos : " + ex);
        } catch (Exception e) {
            LOG.error("Ocurrió un error al listar productos : " + e);
        }
        LOG.info("FIN DE LISTAR PRODUCTOS");
        return productos;
    }

    @Override
    @Transactional
    public Producto obtener(Integer id) {
        LOG.info("INICIO DE OBTENER PRODUCTO : " + id);
        Producto producto = new Producto();
        try {
            producto = entityManager.find(Producto.class, id);
            LOG.info("Se obtuvo correctamente el producto.");
        } catch (DataIntegrityViolationException ex) {
            LOG.error("Ocurrió un error al obtener producto : " + ex);
        } catch (Exception e) {
            LOG.error("Ocurrió un error al obtener producto : " + e);
        }
        LOG.info("FIN DE OBTENER PRODUCTO");
        return producto;
    }

    @Override
    @Transactional
    public Boolean actualizar(Producto objeto) {
        LOG.info("INICIO ACTUALIZACION DE PRODUCTO");
        Boolean resultado = false;
        try {
            if (!objeto.getModificador().isEmpty()) {
                entityManager.merge(objeto);
                resultado = true;
            } else {
                throw new Exception("No se encontró usuario modificador al actualizar");
            }
            LOG.info("Se actualizó correctamente el producto.");
        } catch (DataIntegrityViolationException ex) {
            LOG.error("Ocurrió un error al actualizar producto : " + ex);
        } catch (Exception e) {
            LOG.error("Ocurrió un error al actualizar producto : " + e);
        }
        LOG.info("FIN DE ACTUALIZACION DE PRODUCTO");
        return resultado;
    }

    @Override
    @Transactional
    public Boolean eliminar(Integer id) {
        LOG.info("INICIO ELIMINAR PRODUCTO");
        Boolean resultado = false;
        try {
            Producto producto = obtener(id);
            entityManager.remove(producto);
            resultado = true;
            LOG.info("Se eliminó correctamente el producto.");
        } catch (DataIntegrityViolationException ex) {
            LOG.error("Ocurrió un error al eliminar producto : " + ex);
        } catch (Exception e) {
            LOG.error("Ocurrió un error al eliminar producto : " + e);
        }
        LOG.info("FIN ELIMINAR PRODUCTO");
        return resultado;
    }

}
