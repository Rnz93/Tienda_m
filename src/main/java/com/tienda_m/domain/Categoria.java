package com.tienda_m.domain;


import lombok.Data;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

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
@Table(name="categoria")
public class Categoria implements Serializable{
    private static final long serialVersionUID= 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name ="id_categoria")
  private Long idCategoria;
private String descripcion;
private String rutaImangen;
private boolean activo;

@OneToMany
@JoinColumn(name ="id_Categoria",updatable = false)
private List <Producto> productos;

}






