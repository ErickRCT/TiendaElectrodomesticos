package com.tiendaelectrodomesticos.producto.service;

import com.tiendaelectrodomesticos.producto.entity.Producto;

import java.util.List;

public interface ProductoService {

    void save(Producto producto);

    List<Producto> findAll();

    Producto findById(long id);

}
