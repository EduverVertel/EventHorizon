package com.eventhorizon.service;

import com.eventhorizon.entity.Lugar;
import com.eventhorizon.repository.LugarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LugarService {

    private final LugarRepository lugarRepository;

    public LugarService(LugarRepository lugarRepository) {
        this.lugarRepository = lugarRepository;
    }

    public List<Lugar> listarTodos() {
        return lugarRepository.findAll();
    }

    public Optional<Lugar> buscarPorId(Long id) {
        return lugarRepository.findById(id);
    }

    public Lugar guardar(Lugar lugar) {
        return lugarRepository.save(lugar);
    }

    public void eliminar(Long id) {
        lugarRepository.deleteById(id);
    }
}