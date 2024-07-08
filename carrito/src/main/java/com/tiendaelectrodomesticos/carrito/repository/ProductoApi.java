package com.tiendaelectrodomesticos.carrito.repository;

import com.tiendaelectrodomesticos.carrito.dto.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "producto")
public interface ProductoApi {

    @GetMapping("/producto/obtenerPorId/{idProducto}")
    Producto findByIdProducto(@PathVariable("idProducto") long idProducto);

}
