package com.Tienda.service;

import com.Tienda.dao.ClienteDao;
import com.Tienda.dao.CreditoDao;
import com.Tienda.domain.Cliente;
import com.Tienda.domain.Credito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //Esto ayuda a reconoce los metodos, va pegada a public class
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteDao clienteDao;
    
    @Autowired
    CreditoDao creditoDao; //Lamar la clase Credito

    @Override
    @Transactional(readOnly = true) //para manejar transacciones de solo lectura
    public List<Cliente> getClientes() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true) //para manejar transacciones de solo lectura
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {//Funciona para agregar o modificar credito 
        Credito credito = cliente.getCredito();//Obtener atributo del credito del cliente
        credito = creditoDao.save(credito);//Actualiza el credito
        cliente.setCredito(credito);//Setearlo al c
        clienteDao.save(cliente);//Actualiza el dato del credito cliente
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.deleteById(cliente.getIdCliente());

    }
    @Override
    public List<Cliente> getClienteCorreo(String correo) {
        return (List<Cliente>)clienteDao.findByCorreo(correo);
    }

    @Override
    public List<Cliente> getNombreAndApellidos(String nombre, String apellidos) {
        return (List<Cliente>)clienteDao.findByNombreAndApellidos(nombre, apellidos);
    }

    @Override
    public List<Cliente> getApellidos(String apellidos) {
        return (List<Cliente>)clienteDao.findByApellidos(apellidos);
    }
}
    
