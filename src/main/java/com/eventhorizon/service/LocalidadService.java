package com.eventhorizon.service;

import com.eventhorizon.entity.Localidad;
import com.eventhorizon.repository.LocalidadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalidadService {

    private final LocalidadRepository localidadRepository;

    public LocalidadService(LocalidadRepository localidadRepository) {
        this.localidadRepository = localidadRepository;
    }

    public List<Localidad> listarTodas() {
        return localidadRepository.findAll();
    }

    public Optional<Localidad> buscarPorId(Long id) {
        return localidadRepository.findById(id);
    }

    public Localidad guardar(Localidad localidad) {
        return localidadRepository.save(localidad);
    }

    public void eliminar(Long id) {
        localidadRepository.deleteById(id);
    }
}