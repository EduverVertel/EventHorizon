package com.eventhorizon.service;

import com.eventhorizon.entity.Evento;
import com.eventhorizon.repository.EventoRepository;
import org.springframework.stereotype.Service;
import com.eventhorizon.entity.Usuario;
import com.eventhorizon.repository.UsuarioRepository;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;
    private final UsuarioRepository usuarioRepository;

    public EventoService(EventoRepository eventoRepository,
                         UsuarioRepository usuarioRepository) {
        this.eventoRepository = eventoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<Evento> listarTodos() {
        return eventoRepository.findAll();
    }

    public Optional<Evento> buscarPorId(Long id) {
        return eventoRepository.findById(id);
    }
    
    public List<Evento> listarPorCategoria(Long categoriaId) {
        return eventoRepository.findByCategoriaId(categoriaId);
    }

    public Evento guardar(Evento evento) {

        Usuario usuario = obtenerUsuarioAutenticado();

        if (evento.getId() == null) {

            evento.setCreador(usuario);

        } else {

            Evento eventoExistente = eventoRepository.findById(evento.getId())
                    .orElseThrow(() ->
                            new RuntimeException("Evento no encontrado"));

            boolean esAdmin = usuario.getRol().name().equals("ADMIN");

            boolean esCreador = eventoExistente.getCreador()
                    .getId()
                    .equals(usuario.getId());

            if (!esAdmin && !esCreador) {
                throw new RuntimeException(
                        "No tienes permiso para modificar este evento"
                );
            }

            evento.setCreador(eventoExistente.getCreador());
        }

        return eventoRepository.save(evento);
    }

    public void eliminar(Long id) {

        Usuario usuario = obtenerUsuarioAutenticado();

        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Evento no encontrado"));

        boolean esAdmin = usuario.getRol().name().equals("ADMIN");

        boolean esCreador = evento.getCreador()
                .getId()
                .equals(usuario.getId());

        if (!esAdmin && !esCreador) {
            throw new RuntimeException(
                    "No tienes permiso para eliminar este evento"
            );
        }

        eventoRepository.deleteById(id);
    }
    
    private Usuario obtenerUsuarioAutenticado() {

        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return usuarioRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("Usuario no encontrado"));
    }
}