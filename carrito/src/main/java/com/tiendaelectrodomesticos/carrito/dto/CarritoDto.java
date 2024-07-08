package com.tiendaelectrodomesticos.carrito.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarritoDto {

    private long idCarrito;
    private int total;
    private List<Producto> productos;
}
