package com.eventhorizon.controller;

import com.eventhorizon.entity.Localidad;
import com.eventhorizon.service.LocalidadService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/localidades")
public class LocalidadController {

    private final LocalidadService localidadService;

    public LocalidadController(LocalidadService localidadService) {
        this.localidadService = localidadService;
    }

    @GetMapping
    public List<Localidad> listarTodas() {
        return localidadService.listarTodas();
    }

    @GetMapping("/{id}")
    public Optional<Localidad> buscarPorId(@PathVariable Long id) {
        return localidadService.buscarPorId(id);
    }

    @GetMapping("/evento/{eventoId}")
    public List<Localidad> listarPorEvento(@PathVariable Long eventoId) {
        return localidadService.listarPorEvento(eventoId);
    }

    @PostMapping
    public Localidad guardar(@RequestBody Localidad localidad) {
        return localidadService.guardar(localidad);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        localidadService.eliminar(id);
    }
}