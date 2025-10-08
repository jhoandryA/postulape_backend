package com.sise.postulape_backend.usuario.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.postulape_backend.usuario.application.dto.response.ListarUsuarioResponseDto;
import com.sise.postulape_backend.usuario.domain.entities.Usuario;
import com.sise.postulape_backend.common.application.IEntityDtoMapper;

@Component
public class ListarUsuarioMapper implements IEntityDtoMapper<Usuario, Void, ListarUsuarioResponseDto> {

    @Override
    public Usuario requestToEntity(Void requestDto) {
        throw new UnsupportedOperationException("Método no soportado para listar usuarios");
    }

    @Override
    public ListarUsuarioResponseDto entityToResponse(Usuario entity) {
        ListarUsuarioResponseDto responseDto = new ListarUsuarioResponseDto();
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
}