package com.sise.postulape_backend.usuario.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.postulape_backend.usuario.application.dto.request.InsertarUsuarioRequestDto;
import com.sise.postulape_backend.usuario.application.dto.response.InsertarUsuarioResponseDto;
import com.sise.postulape_backend.usuario.application.dto.response.ListarUsuarioResponseDto;
import com.sise.postulape_backend.usuario.application.dto.request.ActualizarUsuarioRequestDto;
import com.sise.postulape_backend.usuario.application.dto.response.ActualizarUsuarioResponseDto;
import com.sise.postulape_backend.usuario.application.dto.response.EliminarUsuarioResponseDto;
import com.sise.postulape_backend.usuario.application.mapper.InsertarUsuarioMapper;
import com.sise.postulape_backend.usuario.application.mapper.ListarUsuarioMapper;
import com.sise.postulape_backend.usuario.application.mapper.ActualizarUsuarioMapper;
import com.sise.postulape_backend.usuario.application.mapper.EliminarUsuarioMapper;
import com.sise.postulape_backend.usuario.domain.entities.Usuario;
import com.sise.postulape_backend.usuario.domain.service.UsuarioDomainService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioApplicationService {

    @Autowired
    private UsuarioDomainService usuarioDomainService;

    @Autowired
    private InsertarUsuarioMapper insertarUsuarioMapper;

    @Autowired
    private ListarUsuarioMapper listarUsuarioMapper;

    @Autowired
    private ActualizarUsuarioMapper actualizarUsuarioMapper;

    @Autowired
    private EliminarUsuarioMapper eliminarUsuarioMapper;

    public InsertarUsuarioResponseDto insertarUsuario(InsertarUsuarioRequestDto requestDto) {
        Usuario usuario = usuarioDomainService.insertarUsuario(insertarUsuarioMapper.requestToEntity(requestDto));
        return insertarUsuarioMapper.entityToResponse(usuario);
    }

    public List<ListarUsuarioResponseDto> listarUsuarios() {
        List<Usuario> usuarios = usuarioDomainService.listarUsuarios();
        return usuarios.stream()
                .map(listarUsuarioMapper::entityToResponse)
                .collect(Collectors.toList());
    }

    public ActualizarUsuarioResponseDto actualizarUsuario(Integer id, ActualizarUsuarioRequestDto requestDto) {
        Usuario usuarioExistente = usuarioDomainService.obtenerUsuarioPorId(id);
        actualizarUsuarioMapper.updateEntityFromRequest(requestDto, usuarioExistente);
        Usuario usuarioActualizado = usuarioDomainService.actualizarUsuario(usuarioExistente);
        return actualizarUsuarioMapper.entityToResponse(usuarioActualizado);
    }

    public EliminarUsuarioResponseDto eliminarUsuario(Integer id) {
        Usuario usuario = usuarioDomainService.obtenerUsuarioPorId(id);
        usuario.setIdEliminado("1");
        usuarioDomainService.eliminarUsuario(id);
        Usuario usuarioActualizado = usuarioDomainService.obtenerUsuarioPorId(id);
        return eliminarUsuarioMapper.entityToResponse(usuarioActualizado);
    }
}
