package com.tiendaelectrodomesticos.producto.repository;

import com.tiendaelectrodomesticos.producto.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
