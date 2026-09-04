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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fecha;
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    private EstadoReserva estado;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "evento_id", nullable = false)
    private Evento evento;

    @PrePersist
    protected void onCreate() {
        fecha = LocalDateTime.now();

        if (estado == null) {
            estado = EstadoReserva.PENDIENTE;
        }
    }

    // Constructor vacío requerido por JPA
    public Reserva() {
    }

    // Constructor para crear reservas
    public Reserva(BigDecimal total, Usuario usuario, Evento evento) {
        this.total = total;
        this.usuario = usuario;
        this.evento = evento;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}