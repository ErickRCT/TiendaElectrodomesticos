package com.tiendaelectrodomesticos.venta.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarritoDto {
    private long idCarrito;
    private int total;
    private List<ProductoDto> productos;
}
