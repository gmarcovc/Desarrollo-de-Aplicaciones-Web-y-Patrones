package com.Tienda.controller;

import com.Tienda.dao.ClienteDao;
import com.Tienda.domain.Cliente;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    ClienteDao clienteDao;

    @GetMapping("/")
    public String inicio(Model model) {
        log.info("Ahora utilizando MVC");
        String mensaje = "Estamos en semana 4, saludos!";
        model.addAttribute("MensajeSaludo", mensaje);

//        Cliente cliente = new Cliente("Gian Marco", "Vasquez Carrillo", "gmarcovc@gmail.com", "84168055");
//        Cliente cliente2 = new Cliente("Francisco", "Montero Ramirez", "fran@gmail.com", "85638263");
//        Cliente cliente3= new Cliente("Juan", "Montero Ramirez", "fran@gmail.com", "85638263");
//        //model.addAttribute("cliente", cliente);
//        
//        List<Cliente> clientes = Arrays.asList(cliente, cliente2, cliente3);
//        model.addAttribute("clientes", clientes);

        var clientes = clienteDao.findAll();
        model.addAttribute("clientes", clientes);

        return "index";
    }

}
