package com.Tienda.service;

import com.Tienda.dao.CategoriaDao;
import com.Tienda.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //Esto ayuda a reconoce los metodos, va pegada a public class
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    @Transactional(readOnly = true) //para manejar transacciones de solo lectura
    public List<Categoria> getCategorias(boolean activos) {
        var lista = (List<Categoria>)categoriaDao.findAll();
        if(activos){ //activos = true, es lo mismo
            lista.removeIf(e -> !e.isActivo()); 
            //remover elemantos donde el elemento donde activo es falso
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true) //para manejar transacciones de solo lectura
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {
        categoriaDao.deleteById(categoria.getIdCategoria());
    }

}