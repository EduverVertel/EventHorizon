package com.eventhorizon.controller;

import com.eventhorizon.entity.Evento;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.eventhorizon.service.EventoService;

@RestController
public class PruebaController {

    @GetMapping("/")
    public String inicio() {
        return "¡EventHorizon está funcionando!";
    }

    @GetMapping("/hola")
    public String hola() {
        return "Hola desde Spring Boot";
    }
}