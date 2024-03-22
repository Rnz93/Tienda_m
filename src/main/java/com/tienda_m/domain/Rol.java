package com.tienda_m.domain;


import lombok.Data;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
 

/**
 *
 * @author Renzo
 * create table techshop.categoria (
  id_categoria INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(30) NOT NULL,
  ruta_imagen varchar(1024),
  activo bool,
  PRIMARY KEY (id_categoria))
 */
@Data
@Entity
@Table(name="rol")
public class Rol implements Serializable{
    private static final long serialVersionUID= 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name ="id_rol")
  private Long id_Rol;
private String nombre;

 @Column (name ="id_usuario")
private Long idUsuario;
}






