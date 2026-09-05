package com.eventhorizon.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            .sessionManagement(session ->
                session.sessionCreationPolicy(
                    SessionCreationPolicy.STATELESS
                )
            )

            .authorizeHttpRequests(auth -> auth

                // =========================
                // RUTAS PÚBLICAS
                // =========================

                .requestMatchers("/auth/**").permitAll()

                // Registro de usuarios
                .requestMatchers(HttpMethod.POST, "/usuarios").permitAll()

                // =========================
                // EVENTOS
                // =========================

                .requestMatchers(HttpMethod.GET, "/eventos/**")
                .authenticated()

                .requestMatchers(HttpMethod.POST, "/eventos/**")
                .hasAnyRole("ORGANIZADOR", "ADMIN")

                .requestMatchers(HttpMethod.PUT, "/eventos/**")
                .hasAnyRole("ORGANIZADOR", "ADMIN")

                .requestMatchers(HttpMethod.DELETE, "/eventos/**")
                .hasAnyRole("ORGANIZADOR", "ADMIN")

                // =========================
                // RESERVAS
                // =========================

                .requestMatchers("/reservas/**")
                .hasAnyRole("CLIENTE", "ADMIN")

                // =========================
                // BOLETAS
                // =========================

                .requestMatchers("/boletas/**")
                .hasAnyRole("CLIENTE", "ADMIN")

                // =========================
                // PAGOS
                // =========================

                .requestMatchers("/pagos/**")
                .hasAnyRole("CLIENTE", "ADMIN")

                // =========================
                // LOCALIDADES
                // =========================

                .requestMatchers("/localidades/**")
                .hasAnyRole("ORGANIZADOR", "ADMIN")

                // =========================
                // CATEGORÍAS
                // =========================

                .requestMatchers("/categorias/**")
                .hasRole("ADMIN")

                // =========================
                // LUGARES
                // =========================

                .requestMatchers("/lugares/**")
                .hasRole("ADMIN")

                // =========================
                // USUARIOS
                // =========================

                .requestMatchers("/usuarios/**")
                .hasRole("ADMIN")

                // Todo lo demás requiere autenticación
                .anyRequest().authenticated()
            )

            .addFilterBefore(
                jwtAuthenticationFilter,
                UsernamePasswordAuthenticationFilter.class
            );

        return http.build();
    }
}