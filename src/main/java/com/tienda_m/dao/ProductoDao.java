
package com.tienda_m.dao;

import com.tienda_m.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Renzo
 */
public interface ProductoDao  extends JpaRepository<Producto,Long>
{
    //Utiliza sentencia consultas ampliadas
    public List <Producto> findByPrecioBetweenOrderByDescripcion
        (double precioInf,double precioSup);
        
        
       //Utiliza sentencia consultas JPQL
        @Query(value="SELECT p from Producto p WHERE p.precio Between :precioInf"
                + " and precioSup ORDER BY p.descripcion ASC")
        public List <Producto> metodoJPQL (double precioInf,double precioSup);
        
          //Utiliza sentencia consultas SQL
        @Query(nativeQuery=true,
                value="SELECT p from Producto p WHERE p.precio Between :precioInf"
                + " and precioSup ORDER BY p.descripcion ASC")
        public List <Producto>
                metodoSQL (double precioInf,double precioSup);
                        
    
}