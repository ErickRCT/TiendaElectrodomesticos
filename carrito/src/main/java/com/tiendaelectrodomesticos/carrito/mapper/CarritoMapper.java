package com.tiendaelectrodomesticos.carrito.mapper;

import com.tiendaelectrodomesticos.carrito.dto.CarritoDto;
import com.tiendaelectrodomesticos.carrito.entity.Carrito;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class CarritoMapper {

    public CarritoDto carritoToCarritoDto(Carrito carrito) {
        CarritoDto carritoDto = new CarritoDto();
        carritoDto.setIdCarrito(carrito.getIdCarrito());
        return carritoDto;
    }

}
