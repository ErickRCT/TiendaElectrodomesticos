package com.tiendaelectrodomesticos.carrito.service;

import com.tiendaelectrodomesticos.carrito.dto.CarritoDto;
import com.tiendaelectrodomesticos.carrito.entity.Carrito;

public interface CarritoService {

    void save(Carrito carrito);

    Carrito findCarritoById(long idCarrito);

    CarritoDto findCarritoDtoById(long idCarrito);

    void agregarProducto(long idCarrito,long idProducto);

    void eliminarProducto(long idCarrito ,long idProducto);

}
