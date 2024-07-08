package com.tiendaelectrodomesticos.carrito.service;

import com.tiendaelectrodomesticos.carrito.dto.CarritoDto;
import com.tiendaelectrodomesticos.carrito.dto.Producto;
import com.tiendaelectrodomesticos.carrito.entity.Carrito;
import com.tiendaelectrodomesticos.carrito.mapper.CarritoMapper;
import com.tiendaelectrodomesticos.carrito.repository.CarritoRepository;
import com.tiendaelectrodomesticos.carrito.repository.ProductoApi;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CarritoServiceImpl implements CarritoService {

    private CarritoRepository carritoRepository;

    private ProductoApi productoApi;

    @Override
    public void save(Carrito carrito) {
        carritoRepository.save(carrito);
    }

    @Override
    public Carrito findCarritoById(long idCarrito) {
        return carritoRepository.findById(idCarrito).orElse(null);
    }

    @Override
    @CircuitBreaker(name = "producto",fallbackMethod = "fallbackfindCarritoDtoById")
    @Retry(name = "producto")
    public CarritoDto findCarritoDtoById(long idCarrito) {
        Carrito carrito = this.findCarritoById(idCarrito);
        if (carrito == null){
            return null;
        } else {
            CarritoMapper mapper = new CarritoMapper();
            CarritoDto carritoDto = mapper.carritoToCarritoDto(carrito);
            List<Producto> productos = new ArrayList<>();
            for (Long productoId : carrito.getProductos()) {
                Producto producto = productoApi.findByIdProducto(productoId);
                productos.add(producto);
            }
            carritoDto.setProductos(productos);
            int total = 0;
            for (Producto producto : carritoDto.getProductos()) {
                total = total + producto.getPrecio();
            }
            carritoDto.setTotal(total);
            return carritoDto;
        }
    }

    public CarritoDto fallbackfindCarritoDtoById(Throwable throwable){
        return new CarritoDto(1234L,0,null);
    }

    @Override
    public void agregarProducto(long idCarrito,long idProducto) {
        Carrito carrito = this.findCarritoById(idCarrito);
        carrito.getProductos().add(idProducto);
        this.save(carrito);
    }

    @Override
    public void eliminarProducto(long idCarrito,long idProducto) {
        Carrito carrito = this.findCarritoById(idCarrito);
        carrito.getProductos().remove(idProducto);
        this.save(carrito);
    }
}
