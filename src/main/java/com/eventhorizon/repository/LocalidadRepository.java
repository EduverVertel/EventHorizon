package com.eventhorizon.repository;

import com.eventhorizon.entity.Localidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalidadRepository extends JpaRepository<Localidad, Long> {
    
}