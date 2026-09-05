package com.eventhorizon.repository;

import com.eventhorizon.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {

    List<Evento> findByCategoriaId(Long categoriaId);
}