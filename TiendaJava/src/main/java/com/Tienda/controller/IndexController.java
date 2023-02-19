package com.Tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {

    @GetMapping("/")
    public String inicio(Model model) {
        log.info("Ahora utilizando MVC");
        String mensaje = "Estamos en semana 4, saludos!";
        model.addAttribute("MensajeSaludo", mensaje);
        return "index";
    }

}

