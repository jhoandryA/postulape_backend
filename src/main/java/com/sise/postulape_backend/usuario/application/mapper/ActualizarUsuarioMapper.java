package com.sise.postulape_backend.usuario.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.postulape_backend.usuario.application.dto.request.ActualizarUsuarioRequestDto;
import com.sise.postulape_backend.usuario.application.dto.response.ActualizarUsuarioResponseDto;
import com.sise.postulape_backend.usuario.domain.entities.Usuario;
import com.sise.postulape_backend.common.application.IEntityDtoMapper;

@Component
public class ActualizarUsuarioMapper implements IEntityDtoMapper<Usuario, ActualizarUsuarioRequestDto, ActualizarUsuarioResponseDto> {

    @Override
    public Usuario requestToEntity(ActualizarUsuarioRequestDto requestDto) {
        Usuario usuario = new Usuario();
        usuario.setUsuario(requestDto.getUsuario());
        usuario.setClave(requestDto.getClave());
        usuario.setApellidoPaterno(requestDto.getApellidoPaterno());
        usuario.setApellidoMaterno(requestDto.getApellidoMaterno());
        usuario.setNombre(requestDto.getNombre());
        usuario.setIdPerfil(requestDto.getIdPerfil());
        return usuario;
    }

    @Override
    public ActualizarUsuarioResponseDto entityToResponse(Usuario entity) {
        ActualizarUsuarioResponseDto responseDto = new ActualizarUsuarioResponseDto();
        responseDto.setIdUsuario(entity.getIdUsuario());
        responseDto.setUsuario(entity.getUsuario());
        responseDto.setClave(entity.getClave());
        responseDto.setApellidoPaterno(entity.getApellidoPaterno());
        responseDto.setApellidoMaterno(entity.getApellidoMaterno());
        responseDto.setNombre(entity.getNombre());
        responseDto.setIdPerfil(entity.getIdPerfil());
        responseDto.setIdEliminado(entity.getIdEliminado());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }

    public void updateEntityFromRequest(ActualizarUsuarioRequestDto requestDto, Usuario entity) {
        if (requestDto.getUsuario() != null) {
            entity.setUsuario(requestDto.getUsuario());
        }
        if (requestDto.getClave() != null) {
            entity.setClave(requestDto.getClave());
        }
        if (requestDto.getApellidoPaterno() != null) {
            entity.setApellidoPaterno(requestDto.getApellidoPaterno());
        }
        if (requestDto.getApellidoMaterno() != null) {
            entity.setApellidoMaterno(requestDto.getApellidoMaterno());
        }
        if (requestDto.getNombre() != null) {
            entity.setNombre(requestDto.getNombre());
        }
        if (requestDto.getIdPerfil() != null) {
            entity.setIdPerfil(requestDto.getIdPerfil());
        }
    }
}

