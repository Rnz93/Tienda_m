/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda_m.dao;

import com.tienda_m.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Renzo
 */
public interface ProductoDao  extends JpaRepository<Producto,Long>
{
    
}