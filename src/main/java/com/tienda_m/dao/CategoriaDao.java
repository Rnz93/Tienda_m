 
package com.tienda_m.dao;

import com.tienda_m.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Renzo
 */
public interface CategoriaDao  extends JpaRepository<Categoria,Long>
{
    
}