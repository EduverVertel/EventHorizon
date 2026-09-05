package com.eventhorizon.repository;

import com.eventhorizon.entity.Localidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocalidadRepository extends JpaRepository<Localidad, Long> {
    List<Localidad> findByEventoId(Long eventoId);
}