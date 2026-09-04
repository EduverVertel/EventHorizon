package com.eventhorizon.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity
public class Localidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private Integer capacidad;
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "evento_id", nullable = false)
    private Evento evento;

    @PrePersist
    protected void onCreate() {
        if (estado == null) {
            estado = true;
        }
    }

    // Constructor vacío requerido por JPA
    public Localidad() {
    }

    // Constructor para crear localidades
    public Localidad(String nombre, String descripcion,
                     BigDecimal precio, Integer capacidad,
                     Evento evento) {

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.capacidad = capacidad;
        this.evento = evento;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public Boolean getEstado() {
        return estado;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}