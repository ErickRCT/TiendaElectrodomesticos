package com.tiendaelectrodomesticos.venta.controller;

import com.tiendaelectrodomesticos.venta.dto.VentaDto;
import com.tiendaelectrodomesticos.venta.entity.Venta;
import com.tiendaelectrodomesticos.venta.service.VentaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/venta")
@AllArgsConstructor
public class VentaController {

    private VentaService ventaService;

    @PostMapping("/crear")
    public String crearVenta(@RequestBody Venta venta) {
        ventaService.crearVenta(venta);
        return "Venta Creada!";
    }

    @GetMapping("/obtenerVenta/{idVenta}")
    public VentaDto obtenerVenta(@PathVariable int idVenta) {
        return ventaService.obtenerVentaDto(idVenta);
    }

}
