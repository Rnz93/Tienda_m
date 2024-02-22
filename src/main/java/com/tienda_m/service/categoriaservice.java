/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda_m.service;

import com.tienda_m.domain.Categoria;
import java.util.List;

/**
 *
 * @author Renzo
 */
public interface categoriaservice {
    //Se define la firma del metodo para obtenener los regostros de firma
    public List<Categoria> getCategorias(boolean activo);
  
    // se recupera un registro tomado el idcategoria como clave de busqueda
    public Categoria getcategoria(Categoria categoria);
    
    // si idcategoria tiene un valorse modifica ese registro
    // si idcategoria no tiene valor, se inserta un nuevo registro
    public void save( Categoria categoria);
    
    // se elimina el registro que tenga el valor de idcategoria pasado
    public void delete(Categoria categoria);
    
    
}
