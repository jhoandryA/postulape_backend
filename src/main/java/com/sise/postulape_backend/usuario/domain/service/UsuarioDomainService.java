package com.sise.postulape_backend.usuario.domain.service;

import com.sise.postulape_backend.common.domain.exception.BusinessException;
import com.sise.postulape_backend.usuario.domain.entities.Usuario;
import com.sise.postulape_backend.usuario.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioDomainService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario insertarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll().stream()
                .filter(usuario -> !"1".equals(usuario.getIdEliminado()))
                .collect(Collectors.toList());
    }

    public Usuario obtenerUsuarioPorId(Integer id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Postulante no encontrado con id: " + id));
    }

    public Usuario actualizarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(Integer id) {
        Usuario usuario = obtenerUsuarioPorId(id);
        usuario.setIdEliminado("1");
        actualizarUsuario(usuario);
    }
}
