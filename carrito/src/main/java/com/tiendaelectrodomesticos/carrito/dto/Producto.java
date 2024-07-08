package com.tiendaelectrodomesticos.carrito.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    private long idProducto;
    private String nombre;
    private String marca;
    private int precio;
}
