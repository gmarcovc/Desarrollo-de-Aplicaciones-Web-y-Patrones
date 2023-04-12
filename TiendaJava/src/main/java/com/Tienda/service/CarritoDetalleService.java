package com.Tienda.service;

import com.Tienda.domain.Articulo;
import com.Tienda.domain.CarritoDetalle;
import java.util.List;

public interface CarritoDetalleService {

    public CarritoDetalle getCarritoDetalle(CarritoDetalle carritoDetalle);

    public CarritoDetalle getCarritoDetalleArticulo(Long idCarrito, Articulo articulo);

    public List<CarritoDetalle> getCarritoDetalles(Long idCarrito);

    public void save(CarritoDetalle carritoDetalle);

    public void delete(CarritoDetalle carritoDetalle);

    public void deleteAll(Long idCarrito);

}
