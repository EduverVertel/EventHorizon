package com.eventhorizon.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity
public class Boleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private BigDecimal precio;

    @Enumerated(EnumType.STRING)
    private EstadoBoleta estado;

    @ManyToOne
    @JoinColumn(name = "reserva_id", nullable = false)
    private Reserva reserva;

    @ManyToOne
    @JoinColumn(name = "localidad_id", nullable = false)
    private Localidad localidad;

    @PrePersist
    protected void onCreate() {
        if (estado == null) {
            estado = EstadoBoleta.RESERVADA;
        }
    }

    // Constructor vacío requerido por JPA
    public Boleta() {
    }

    // Constructor para crear boletas
    public Boleta(String codigo, BigDecimal precio,
                  Reserva reserva, Localidad localidad) {

        this.codigo = codigo;
        this.precio = precio;
        this.reserva = reserva;
        this.localidad = localidad;
    }

    public Long getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public EstadoBoleta getEstado() {
        return estado;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public void setEstado(EstadoBoleta estado) {
        this.estado = estado;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
}