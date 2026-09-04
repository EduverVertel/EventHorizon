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
public class DetalleReserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer cantidad;
    private BigDecimal precio;
    private BigDecimal subtotal;

    @ManyToOne
    @JoinColumn(name = "reserva_id", nullable = false)
    private Reserva reserva;

    @ManyToOne
    @JoinColumn(name = "localidad_id", nullable = false)
    private Localidad localidad;

    @PrePersist
    protected void onCreate() {
        if (subtotal == null && cantidad != null && precio != null) {
            subtotal = precio.multiply(BigDecimal.valueOf(cantidad));
        }
    }

    // Constructor vacío requerido por JPA
    public DetalleReserva() {
    }

    // Constructor para crear detalles de reserva
    public DetalleReserva(Integer cantidad, BigDecimal precio,
                          Reserva reserva, Localidad localidad) {

        this.cantidad = cantidad;
        this.precio = precio;
        this.reserva = reserva;
        this.localidad = localidad;
    }

    public Long getId() {
        return id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
}