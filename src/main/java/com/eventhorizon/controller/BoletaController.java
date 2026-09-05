package com.eventhorizon.controller;

import com.eventhorizon.entity.Boleta;
import com.eventhorizon.service.BoletaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/boletas")
public class BoletaController {

    private final BoletaService boletaService;

    public BoletaController(BoletaService boletaService) {
        this.boletaService = boletaService;
    }

    @GetMapping
    public List<Boleta> listarTodas() {
        return boletaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Optional<Boleta> buscarPorId(@PathVariable Long id) {
        return boletaService.buscarPorId(id);
    }

    @PostMapping
    public Boleta guardar(@RequestBody Boleta boleta) {
        return boletaService.guardar(boleta);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        boletaService.eliminar(id);
    }
}