package com.eventhorizon.controller;

import com.eventhorizon.entity.Evento;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.eventhorizon.service.EventoService;

@RestController
public class PruebaController {
    
    private final EventoService eventoService;

    public PruebaController(EventoService eventoService) {
        this.eventoService = eventoService;
    }
    
    @GetMapping("/mensaje")
    public String mensaje() {
        return eventoService.obtenerMensaje();
    }

    @GetMapping("/")
    public String inicio() {
        return "¡EventHorizon está funcionando!";
    }

    @GetMapping("/hola")
    public String hola() {
        return "Hola desde Spring Boot";
    }

    @GetMapping("/eventos")
    public String eventos() {
        return "Aquí estarán los eventos de EventHorizon";
    }
    
    @GetMapping("/eventos/{id}")
    public String evento(@PathVariable Long id) {
        return "Estás consultando el evento con ID: " + id;
    }
    
    @GetMapping("/buscar")
    public String buscar(@RequestParam String nombre) {
        return "Buscando eventos relacionados con: " + nombre;
    } 
}