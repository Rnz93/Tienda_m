/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda_m.service.impl;

import com.tienda_m.dao.CategoriaDao;
import com.tienda_m.domain.Categoria;
import com.tienda_m.service.categoriaservice;
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
public class CategoriaServicesImpl implements categoriaservice {

    
    @Autowired
    private CategoriaDao CategoriaDao;
    @Override
    public List<Categoria> getCategorias(boolean activo) {
     var lista=CategoriaDao.findAll();
     
     if (activo){
         lista.removeIf(c -> !c.isActivo());
     }  
      return lista;          
                
    }

    @Override
    @Transactional(readOnly = true) 
    public Categoria getcategoria(Categoria categoria) {
 
        return CategoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Categoria categoria) {
       CategoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {
        CategoriaDao.delete(categoria);
    }
    
    
}
