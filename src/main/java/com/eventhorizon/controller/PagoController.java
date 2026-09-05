package com.eventhorizon.controller;

import com.eventhorizon.entity.Pago;
import com.eventhorizon.service.PagoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @GetMapping
    public List<Pago> listarTodos() {
        return pagoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Pago> buscarPorId(@PathVariable Long id) {
        return pagoService.buscarPorId(id);
    }

    @PostMapping
    public Pago guardar(@RequestBody Pago pago) {
        return pagoService.guardar(pago);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        pagoService.eliminar(id);
    }
}