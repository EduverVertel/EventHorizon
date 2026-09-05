package com.eventhorizon.controller;

import com.eventhorizon.entity.Evento;
import com.eventhorizon.service.EventoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    private final EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping
    public List<Evento> listarTodos() {
        return eventoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Evento> buscarPorId(@PathVariable Long id) {
        return eventoService.buscarPorId(id);
    }

    @GetMapping("/categoria/{categoriaId}")
    public List<Evento> listarPorCategoria(@PathVariable Long categoriaId) {
        return eventoService.listarPorCategoria(categoriaId);
    }

    @PostMapping
    public Evento guardar(@RequestBody Evento evento) {
        return eventoService.guardar(evento);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        eventoService.eliminar(id);
    }
}