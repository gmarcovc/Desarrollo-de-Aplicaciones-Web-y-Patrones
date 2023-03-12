package com.Tienda.service;

import com.Tienda.dao.ArticuloDao;
import com.Tienda.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticuloServiceImpl implements ArticuloService{
    
 @Autowired
    ArticuloDao articuloDao;

    @Override
    @Transactional(readOnly = true) //para manejar transacciones de solo lectura
    public List<Articulo> getArticulos(boolean activos) {
        var lista = (List<Articulo>)articuloDao.findAll();
        if(activos){ //activos = true, es lo mismo
            lista.removeIf(e -> !e.isActivo()); 
            //remover elemantos donde el elemento donde activo es falso
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true) //para manejar transacciones de solo lectura
    public Articulo getArticulo(Articulo articulo) {
        return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Articulo articulo) {
        articuloDao.save(articulo);
    }

    @Override
    @Transactional
    public void delete(Articulo articulo) {
        articuloDao.deleteById(articulo.getIdArticulo());
    }

}
