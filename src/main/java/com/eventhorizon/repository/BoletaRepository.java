package com.eventhorizon.repository;

import com.eventhorizon.entity.Boleta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoletaRepository extends JpaRepository<Boleta, Long> {
    
}