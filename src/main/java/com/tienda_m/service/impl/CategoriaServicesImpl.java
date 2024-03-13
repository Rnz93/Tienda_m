
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

public class CategoriaServicesImpl implements categoriaservice {

    
    @Autowired
    private CategoriaDao CategoriaDao;
    @Override
    @Transactional(readOnly = true) 
    public List<Categoria> getCategorias(boolean activos) {
     var lista=CategoriaDao.findAll();
     
     if (activos){
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
