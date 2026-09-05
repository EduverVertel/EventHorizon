package com.eventhorizon.controller;

import com.eventhorizon.entity.DetalleReserva;
import com.eventhorizon.service.DetalleReservaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detalles-reserva")
public class DetalleReservaController {

    private final Detalle@RequestMapping("/detalles-reserva")
ReservaService detalleReservaService;

    public DetalleReservaController(DetalleReservaService detalleReservaService) {
        this.detalleReservaService = detalleReservaService;
    }

    @GetMapping
    public List<DetalleReserva> listarTodos() {
        return detalleReservaService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<DetalleReserva> buscarPorId(@PathVariable Long id) {
        return detalleReservaService.buscarPorId(id);
    }

    @PostMapping
    public DetalleReserva guardar(@RequestBody DetalleReserva detalleReserva) {
        return detalleReservaService.guardar(detalleReserva);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        detalleReservaService.eliminar(id);
    }
}