/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author ccolome
 */

@Entity
@Table(name = "tb_producto")
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "precio")
    private Double precio;
        
    @Column(name = "cantidad")
    private Double cantidad;
    
    @Column(name = "creador")
    private String creador;
      
    @Column(name = "modificador")
    private String modificador;
    
    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    
    @UpdateTimestamp
    @Column(name = "fecha_modificacion", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
        
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public String getModificador() {
        return modificador;
    }

    public void setModificador(String modificador) {
        this.modificador = modificador;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", descripcion=" + descripcion + ", precio=" + precio + ", cantidad=" + cantidad + ", creador=" + creador + ", modificador=" + modificador + ", fechaCreacion=" + fechaCreacion + ", fechaModificacion=" + fechaModificacion + '}';
    }
}
