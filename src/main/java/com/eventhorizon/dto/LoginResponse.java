package com.eventhorizon.dto;

public class LoginResponse {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String rol;

    public LoginResponse() {
    }

    public LoginResponse(Long id, String nombre, String apellido,
                          String email, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getRol() {
        return rol;
    }
}