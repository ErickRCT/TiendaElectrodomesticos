package com.tiendaelectrodomesticos.venta.repository;

import com.tiendaelectrodomesticos.venta.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
}
