package com.eventhorizon.repository;

import com.eventhorizon.entity.Lugar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LugarRepository extends JpaRepository<Lugar, Long> {
    
}