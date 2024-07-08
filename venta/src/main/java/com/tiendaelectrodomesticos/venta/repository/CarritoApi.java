package com.tiendaelectrodomesticos.venta.repository;

import com.tiendaelectrodomesticos.venta.dto.CarritoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "carrito")
public interface CarritoApi {

    @GetMapping("/carrito/verCarrito/{idCarrito}")
    CarritoDto obtenerCarrito(@PathVariable("idCarrito") Long idCarrito);
}
