package com.tiendaelectrodomesticos.producto.controller;

import com.tiendaelectrodomesticos.producto.entity.Producto;
import com.tiendaelectrodomesticos.producto.service.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
@AllArgsConstructor
public class ProductoController {

    private ProductoService productoService;

    @PostMapping("/crear")
    public ResponseEntity<String> crearProducto(@RequestBody Producto producto) {
        productoService.save(producto);
        return ResponseEntity.ok("Producto creado correctamente");
    }

    @GetMapping("/obtenerTodo")
    public ResponseEntity<List<Producto>> obtenerProductos() {
        return ResponseEntity.ok(productoService.findAll());
    }

    @GetMapping("/obtenerPorId/{idProducto}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable long idProducto) {
        return ResponseEntity.ok(productoService.findById(idProducto));
    }
}
