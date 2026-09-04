package com.eventhorizon.repository;

import com.eventhorizon.entity.DetalleReserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleReservaRepository extends JpaRepository<DetalleReserva, Long> {
    
}