package com.eventhorizon.controller;

import com.eventhorizon.dto.LoginRequest;
import com.eventhorizon.dto.LoginResponse;
import com.eventhorizon.entity.Usuario;
import com.eventhorizon.repository.UsuarioRepository;
import com.eventhorizon.service.JwtService;
import com.eventhorizon.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioService usuarioService;
    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;

    public AuthController(UsuarioService usuarioService,
                          UsuarioRepository usuarioRepository,
                          JwtService jwtService) {

        this.usuarioService = usuarioService;
        this.usuarioRepository = usuarioRepository;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginRequest loginRequest) {

        Map<String, Object> respuesta = new HashMap<>();

        boolean credencialesValidas = usuarioService.validarCredenciales(
                loginRequest.getEmail(),
                loginRequest.getPassword()
        );

        if (!credencialesValidas) {
            respuesta.put("success", false);
            respuesta.put("mensaje", "Correo o contraseña incorrectos");
            return respuesta;
        }

        Optional<Usuario> usuario = usuarioRepository.findByEmail(
                loginRequest.getEmail()
        );

        Usuario usuarioEncontrado = usuario.get();

        // Generar token JWT
        String token = jwtService.generarToken(usuarioEncontrado);

        LoginResponse loginResponse = new LoginResponse(
                usuarioEncontrado.getId(),
                usuarioEncontrado.getNombre(),
                usuarioEncontrado.getApellido(),
                usuarioEncontrado.getEmail(),
                usuarioEncontrado.getRol().name()
        );

        respuesta.put("success", true);
        respuesta.put("mensaje", "Inicio de sesión exitoso");
        respuesta.put("token", token);
        respuesta.put("usuario", loginResponse);

        return respuesta;
    }
}