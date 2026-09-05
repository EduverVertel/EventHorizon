package com.eventhorizon.service;

import com.eventhorizon.entity.DetalleReserva;
import com.eventhorizon.repository.DetalleReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleReservaService {

    private final DetalleReservaRepository detalleReservaRepository;

    public DetalleReservaService(DetalleReservaRepository detalleReservaRepository) {
        this.detalleReservaRepository = detalleReservaRepository;
    }

    public List<DetalleReserva> listarTodos() {
        return detalleReservaRepository.findAll();
    }

    public Optional<DetalleReserva> buscarPorId(Long id) {
        return detalleReservaRepository.findById(id);
    }

    public DetalleReserva guardar(DetalleReserva detalleReserva) {
        return detalleReservaRepository.save(detalleReserva);
    }

    public void eliminar(Long id) {
        detalleReservaRepository.deleteById(id);
    }
}