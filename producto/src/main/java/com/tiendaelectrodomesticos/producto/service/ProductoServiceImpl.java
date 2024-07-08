package com.tiendaelectrodomesticos.producto.service;

import com.tiendaelectrodomesticos.producto.entity.Producto;
import com.tiendaelectrodomesticos.producto.repository.ProductoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductoServiceImpl implements ProductoService{

    private ProductoRepository productoRepository;

    @Override
    public void save(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Producto findById(long id) {
        return productoRepository.findById(id).orElse(null);
    }
}
