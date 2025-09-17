package com.sise.postulape_backend.usuario.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.postulape_backend.usuario.application.dto.request.InsertarUsuarioRequestDto;
import com.sise.postulape_backend.usuario.application.dto.response.InsertarUsuarioResponseDto;
import com.sise.postulape_backend.usuario.domain.entities.Usuario;
import com.sise.postulape_backend.common.application.IEntityDtoMapper;

@Component
public class InsertarUsuarioMapper implements IEntityDtoMapper<Usuario, InsertarUsuarioRequestDto, InsertarUsuarioResponseDto> {

    @Override
    public Usuario requestToEntity(InsertarUsuarioRequestDto requestDto) {
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
    public InsertarUsuarioResponseDto entityToResponse(Usuario entity) {
        InsertarUsuarioResponseDto responseDto = new InsertarUsuarioResponseDto();
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
