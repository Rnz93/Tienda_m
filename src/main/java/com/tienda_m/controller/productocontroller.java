/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda_m.controller;


import com.tienda_m.domain.Producto;
import com.tienda_m.service.categoriaservice;
import com.tienda_m.service.productoservice;
import com.tienda_m.service.impl.FirebaseStorageServiceImpl;
import static org.hibernate.query.results.ResultsHelper.attributeName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
/**
 *
 * @author Renzo
 */
@Controller
@RequestMapping("/producto")

public class productocontroller {
    @Autowired
    private productoservice productoservice;
    
     @Autowired
    private categoriaservice categoriaservice;
     
    @GetMapping ("/listado")
    public String listado (Model model){
       var lista = productoservice.getProductos(false);
       model.addAttribute("productos", lista);
      model.addAttribute("totalproductos",lista.size());
        
      var categorias=categoriaservice.getCategorias(true);
     model.addAttribute("categorias", categorias);
        return "/producto/listado";
    }      
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageServiceImpl;
    
    @PostMapping ("/guardar")
    public String guardar(Producto producto, 
          @RequestParam("imagenFile") MultipartFile imagenFile ){
        if(!imagenFile.isEmpty()){
            productoservice.save(producto);
            String rutaImagen=
                    firebaseStorageServiceImpl.cargaImagen(imagenFile, "producto", producto.getIdProducto());
       producto.setRutaImangen(rutaImagen);
        
        }
        productoservice.save(producto);
        return "redirect:/producto/listado";
        
    }
    @GetMapping ("/modificar/{idProducto}")
    public String modifica (Producto producto, Model model){
         var categorias=categoriaservice.getCategorias(true);
     model.addAttribute("categorias", categorias);
        producto = productoservice.getproducto(producto);
        model.addAttribute(",producto", producto);
        return "/producto/modifica";
    }
    
        @GetMapping ("/eliminar/{idProducto}")
    public String elimina (Producto producto){
               productoservice.delete(producto);

        return  "redirect:/producto/listado";
    }
}
