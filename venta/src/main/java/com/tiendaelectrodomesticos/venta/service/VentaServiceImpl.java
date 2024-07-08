package com.tiendaelectrodomesticos.venta.service;

import com.tiendaelectrodomesticos.venta.dto.CarritoDto;
import com.tiendaelectrodomesticos.venta.dto.VentaDto;
import com.tiendaelectrodomesticos.venta.entity.Venta;
import com.tiendaelectrodomesticos.venta.repository.CarritoApi;
import com.tiendaelectrodomesticos.venta.repository.VentaRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VentaServiceImpl implements VentaService {

    private VentaRepository ventaRepository;

    private CarritoApi carritoApi;

    @Override
    public void crearVenta(Venta venta) {
        ventaRepository.save(venta);
    }

    @Override
    public Venta obtenerVenta(long idVenta) {
        return ventaRepository.findById(idVenta).orElse(null);
    }


    @Override
    @CircuitBreaker(name = "carrito",fallbackMethod = "fallbackObtenerVentaDto")
    @Retry(name = "carrito")
    public VentaDto obtenerVentaDto(long idVenta) {
        Venta venta = this.obtenerVenta(idVenta);
        if (venta != null) {
            CarritoDto carritoDto = carritoApi.obtenerCarrito(venta.getIdCarrito());
            VentaDto ventaDto = new VentaDto();
            ventaDto.setIdVenta(venta.getIdVenta());
            ventaDto.setCarrito(carritoDto);
            ventaDto.setTotal(carritoDto.getTotal());
            return ventaDto;
        } else {
            return null;
        }
    }

    public VentaDto fallbackObtenerVentaDto(Throwable throwable) {
        return new VentaDto(1234L,0,null);
    }
}
