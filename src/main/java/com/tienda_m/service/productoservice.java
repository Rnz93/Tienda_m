/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda_m.service;

import com.tienda_m.domain.Producto;
import java.util.List;

/**
 *
 * @author Renzo
 */
public interface productoservice {
    //Se define la firma del metodo para obtenener los regostros de firma
    public List<Producto> getProductos(boolean activo);
  
    // se recupera un registro tomado el idproducto como clave de busqueda
    public Producto getproducto(Producto producto);
    
    // si idproducto tiene un valorse modifica ese registro
    // si idproducto no tiene valor, se inserta un nuevo registro
    public void save( Producto producto);
    
    // se elimina el registro que tenga el valor de idproducto pasado
    public void delete(Producto producto);
    
    
}
