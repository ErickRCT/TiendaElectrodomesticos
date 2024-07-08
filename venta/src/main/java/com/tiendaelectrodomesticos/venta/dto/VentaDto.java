package com.tiendaelectrodomesticos.venta.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaDto {
    private long idVenta;
    private int total;
    private CarritoDto carrito;
}
