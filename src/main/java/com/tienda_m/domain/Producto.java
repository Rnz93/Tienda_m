package com.tienda_m.domain;


import lombok.Data;
import jakarta.persistence.*;
import java.io.Serializable;


/**
 *
 * @author Renzo
 * create table techshop.producto (
  id_producto INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(30) NOT NULL,
  ruta_imagen varchar(1024),
  activo bool,
  PRIMARY KEY (id_producto))
 */
@Data
@Entity
@Table(name="producto")
public class Producto implements Serializable{
    private static final long serialVersionUID= 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name ="id_producto")
  private Long idProducto;
  //  private Long idCategoria;
private String descripcion;
private String detalle;
private double precio;
private int existencias;
private String rutaImangen;
private boolean activo;

@ManyToOne
@JoinColumn(name ="id_Categoria")
private Categoria categoria;
}






