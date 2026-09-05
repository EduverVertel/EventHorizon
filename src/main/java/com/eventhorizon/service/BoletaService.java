package com.eventhorizon.service;

import com.eventhorizon.entity.Boleta;
import com.eventhorizon.repository.BoletaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoletaService {

    private final BoletaRepository boletaRepository;

    public BoletaService(BoletaRepository boletaRepository) {
        this.boletaRepository = boletaRepository;
    }

    public List<Boleta> listarTodas() {
        return boletaRepository.findAll();
    }

    public Optional<Boleta> buscarPorId(Long id) {
        return boletaRepository.findById(id);
    }

    public Boleta guardar(Boleta boleta) {
        return boletaRepository.save(boleta);
    }

    public void eliminar(Long id) {
        boletaRepository.deleteById(id);
    }
}