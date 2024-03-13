/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda_m.service.impl;

import com.tienda_m.dao.ProductoDao;
import com.tienda_m.domain.Producto;
import com.tienda_m.service.productoservice;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Renzo
 */
@Service
@Transactional(readOnly = true) 
public class ProductoServicesImpl implements productoservice {

    
    @Autowired
    private ProductoDao ProductoDao;
    @Override
    public List<Producto> getProductos(boolean activo) {
     var lista=ProductoDao.findAll();
     
     if (activo){
         lista.removeIf(c -> !c.isActivo());
     }  
      return lista;          
                
    }

    @Override
    @Transactional(readOnly = true) 
    public Producto getproducto(Producto producto) {
 
        return ProductoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
       ProductoDao.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        ProductoDao.delete(producto);
    }
    
    
}
