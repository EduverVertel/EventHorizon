package com.eventhorizon.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private LocalDate fecha;
    private LocalTime hora;
    private String imagen;
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "creador_id", nullable = false)
    private Usuario creador;
    
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;
    
    @ManyToOne
    @JoinColumn(name = "lugar_id", nullable = false)
    private Lugar lugar;

    @PrePersist
    protected void onCreate() {
        if (estado == null) {
            estado = true;
        }
    }

    // Constructor vacío requerido por JPA
    public Evento() {
    }

    // Constructor para crear eventos
    public Evento(String nombre, String descripcion, LocalDate fecha,
              LocalTime hora, String imagen, Usuario creador,
              Categoria categoria, Lugar lugar) {

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.imagen = imagen;
        this.creador = creador;
        this.categoria = categoria;
        this.lugar = lugar;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getImagen() {
        return imagen;
    }

    public Boolean getEstado() {
        return estado;
    }

    public Usuario getCreador() {
        return creador;
    }
    
    public Categoria getCategoria() {
        return categoria;
    }
    
    public Lugar getLugar() {
        return lugar;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }
}