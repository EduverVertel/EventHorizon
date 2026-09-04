package com.eventhorizon.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;

@Entity
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fecha;
    private BigDecimal monto;

    @Enumerated(EnumType.STRING)
    private MetodoPago metodo;

    @Enumerated(EnumType.STRING)
    private EstadoPago estado;

    @OneToOne
    @JoinColumn(name = "reserva_id", nullable = false, unique = true)
    private Reserva reserva;

    @PrePersist
    protected void onCreate() {
        fecha = LocalDateTime.now();

        if (estado == null) {
            estado = EstadoPago.PENDIENTE;
        }
    }

    // Constructor vacío requerido por JPA
    public Pago() {
    }

    // Constructor para crear pagos
    public Pago(BigDecimal monto, MetodoPago metodo, Reserva reserva) {
        this.monto = monto;
        this.metodo = metodo;
        this.reserva = reserva;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public MetodoPago getMetodo() {
        return metodo;
    }

    public EstadoPago getEstado() {
        return estado;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public void setMetodo(MetodoPago metodo) {
        this.metodo = metodo;
    }

    public void setEstado(EstadoPago estado) {
        this.estado = estado;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}