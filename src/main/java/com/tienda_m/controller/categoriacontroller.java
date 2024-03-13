/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda_m.controller;


import com.tienda_m.domain.Categoria;
import com.tienda_m.service.categoriaservice;
import com.tienda_m.service.impl.FirebaseStorageServiceImpl;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/categoria")
public class categoriacontroller {
    @Autowired
    private categoriaservice categoriaservice;
    
    @GetMapping ("/listado")
    public String listado (Model model){
       var lista = categoriaservice.getCategorias(false);
       model.addAttribute("categorias", lista);
      model.addAttribute("totalcategorias",lista.size());
        
        return "/categoria/listado";
    }      
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageServiceImpl;
    
     @GetMapping("/nuevo")
    public String categoriaNuevo(Categoria categoria) {
        return "/categoria/modifica";
    }
    
    @PostMapping ("/guardar")
    public String guardar(Categoria categoria, 
          @RequestParam("imagenFile") MultipartFile imagenFile ){
        if(!imagenFile.isEmpty()){
            categoriaservice.save(categoria);
            String rutaImagen=
                    firebaseStorageServiceImpl.cargaImagen(imagenFile, "categoria", categoria.getIdCategoria());
       categoria.setRutaImangen(rutaImagen);
        
        }
        categoriaservice.save(categoria);
        return "redirect:/categoria/listado";
        
    }
    @GetMapping ("/modificar/{idCategoria}")
    public String modifica (Categoria categoria, Model model){
        categoria = categoriaservice.getcategoria(categoria);
        model.addAttribute(",categoria", categoria);
        return "/categoria/modifica";
    }
    
        @GetMapping ("/eliminar/{idCategoria}")
    public String elimina (Categoria categoria){
               categoriaservice.delete(categoria);

        return  "redirect:/categoria/listado";
    }
}
