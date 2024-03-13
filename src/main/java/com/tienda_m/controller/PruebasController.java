 
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
@RequestMapping("/pruebas")

public class PruebasController {
    @Autowired
    private productoservice productoservice;
    
     @Autowired
    private categoriaservice categoriaservice;
     
    @GetMapping ("/listado")
    public String listado (Model model){
       var lista = productoservice.getProductos(false);
       model.addAttribute("productos", lista);
         
      var categorias=categoriaservice.getCategorias(true);
     model.addAttribute("categorias", categorias);
        return "/pruebas/listado";
    }   
}
