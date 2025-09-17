package com.sise.postulape_backend.usuario.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.postulape_backend.usuario.domain.entities.Usuario;
import com.sise.postulape_backend.usuario.application.dto.response.EliminarUsuarioResponseDto;
import com.sise.postulape_backend.common.application.IEntityDtoMapper;

@Component
public class EliminarUsuarioMapper implements IEntityDtoMapper<Usuario, Integer, EliminarUsuarioResponseDto> {

    @Override
    public Usuario requestToEntity(Integer id) {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(id);
        return usuario;
    }

    @Override
    public EliminarUsuarioResponseDto entityToResponse(Usuario entity) {
        EliminarUsuarioResponseDto responseDto = new EliminarUsuarioResponseDto();
        responseDto.setIdUsuario(entity.getIdUsuario());
        responseDto.setMensaje("Usuario eliminado con éxito");
        return responseDto;
    }
}