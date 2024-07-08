package com.tiendaelectrodomesticos.venta.service;

import com.tiendaelectrodomesticos.venta.dto.VentaDto;
import com.tiendaelectrodomesticos.venta.entity.Venta;

public interface VentaService {

    void crearVenta(Venta venta);

    Venta obtenerVenta(long idVenta);

    VentaDto obtenerVentaDto(long idVenta);

}
