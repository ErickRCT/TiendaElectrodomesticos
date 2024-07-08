package com.tiendaelectrodomesticos.carrito.controller;

import com.tiendaelectrodomesticos.carrito.dto.CarritoDto;
import com.tiendaelectrodomesticos.carrito.entity.Carrito;
import com.tiendaelectrodomesticos.carrito.service.CarritoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrito")
@AllArgsConstructor
public class CarritoController {

    private CarritoService carritoService;

    @PostMapping("/crear")
    public ResponseEntity<String> crear(@RequestBody Carrito carrito) {
        carritoService.save(carrito);
        return ResponseEntity.ok("Carrito creado correctamente");
    }

    @PutMapping("/agregarProducto/{idCarrito}/{idProducto}")
    public ResponseEntity<String> agregarProducto(@PathVariable long idCarrito, @PathVariable long idProducto) {
        Carrito carrito = carritoService.findCarritoById(idCarrito);
        if (carrito != null) {
            carritoService.agregarProducto(idCarrito, idProducto);
            return ResponseEntity.ok("Producto agregado correctamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/eliminarProducto/{idCarrito}/{idProducto}")
    public ResponseEntity<String> eliminarProducto(@PathVariable long idCarrito, @PathVariable long idProducto) {
        Carrito carrito = carritoService.findCarritoById(idCarrito);
        if (carrito != null) {
            carritoService.eliminarProducto(idCarrito, idProducto);
            return ResponseEntity.ok("Producto eliminado correctamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/verCarrito/{idCarrito}")
    public ResponseEntity<CarritoDto> verCarrito(@PathVariable long idCarrito) {
        CarritoDto carritoDto = carritoService.findCarritoDtoById(idCarrito);
        if (carritoDto != null) {
            return ResponseEntity.ok(carritoDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
