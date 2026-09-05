package com.eventhorizon.controller;

import com.eventhorizon.entity.Lugar;
import com.eventhorizon.service.LugarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lugares")
public class LugarController {

    private final LugarService lugarService;

    public LugarController(LugarService lugarService) {
        this.lugarService = lugarService;
    }

    @GetMapping
    public List<Lugar> listarTodos() {
        return lugarService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Lugar> buscarPorId(@PathVariable Long id) {
        return lugarService.buscarPorId(id);
    }

    @PostMapping
    public Lugar guardar(@RequestBody Lugar lugar) {
        return lugarService.guardar(lugar);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        lugarService.eliminar(id);
    }
}