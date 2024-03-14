package com.tienda_m.controller;

import com.tienda_m.domain.Categoria;
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

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = productoservice.getProductos(false);
        model.addAttribute("productos", lista);

        var categorias = categoriaservice.getCategorias(true);
        model.addAttribute("categorias", categorias);
        return "/pruebas/listado";
    }

    @GetMapping("/listado/{idCategoria}")
    public String listadoIds(Categoria categoria, Model model) {
        categoria = categoriaservice.getcategoria(categoria);
        var productos = categoria.getProductos();
        model.addAttribute(",productos", productos);

        var categorias = categoriaservice.getCategorias(true);
        model.addAttribute("categorias", categorias);

        return "/pruebas/listado";
    }

    @GetMapping("/listado2")
    public String listado2(Model model) {
        var lista = productoservice.getProductos(false);
        model.addAttribute("productos", lista);

        return "/pruebas/listado2";

    }

    @PostMapping("/query1")
    public String consultaQuery1(
            @RequestParam(value = "precioInf") double precioInf,
            @RequestParam(value = "precioSup") double precioSup,
            Model model) {
        var lista = productoservice.metodoJPA(precioInf, precioSup);
        model.addAttribute("productos", lista);
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "/pruebas/listado2";
    }

    @PostMapping("/query1")
    public String consultaQuery2(
            @RequestParam(value = "precioInf") double precioInf,
            @RequestParam(value = "precioSup") double precioSup,
            Model model) {
        var lista = productoservice.metodoJPQL(precioInf, precioSup);
        model.addAttribute("productos", lista);
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "/pruebas/listado2";
    }

    @PostMapping("/query1")
    public String consultaQuery3(
            @RequestParam(value = "precioInf") double precioInf,
            @RequestParam(value = "precioSup") double precioSup,
            Model model) {
        var lista = productoservice.metodoSQL(precioInf, precioSup);
        model.addAttribute("productos", lista);
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "/pruebas/listado2";
    }

}
