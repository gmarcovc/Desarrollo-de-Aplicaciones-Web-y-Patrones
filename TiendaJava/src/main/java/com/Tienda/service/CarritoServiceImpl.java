package com.Tienda.service;

import com.Tienda.dao.CarritoDao;
import com.Tienda.domain.Carrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarritoServiceImpl implements CarritoService {

    @Autowired
    CarritoDao carritoDao;

    @Override
    public Carrito getCarrito(Carrito carrito) {
        return carritoDao.findById(carrito.getIdCarrito()).orElse(null);
    }

    @Override
    public Carrito getCarritoCliente(Long idCliente) {//idCliente =3
        Carrito carritoCliente = carritoDao.findByIdCliente(idCliente).orElse(null);
        
        //Evaluar si existe el carrito, de lo contrario, lo mandamos a crear
        if (carritoCliente == null){
            Carrito carritoNuevo = new Carrito(idCliente);//idCarrito = 0, idCliente =3
            carritoCliente = carritoDao.save(carritoNuevo);//idCarrito = 1, idCliente =3 y para cada carrito le va sumando 1
        }
        return carritoCliente;
    }

}
