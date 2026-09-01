package com.eventhorizon.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Evento {

    private Long id;
    private String nombre;
    private String lugar;

    public Evento(Long id, String nombre, String lugar) {
        this.id = id;
        this.nombre = nombre;
        this.lugar = lugar;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLugar() {
        return lugar;
    }
}
