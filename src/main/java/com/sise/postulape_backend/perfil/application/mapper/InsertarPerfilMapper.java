package com.sise.postulape_backend.perfil.application.mapper;

import org.springframework.stereotype.Component;
import com.sise.postulape_backend.perfil.application.dto.request.InsertarPerfilRequestDto;
import com.sise.postulape_backend.perfil.application.dto.response.InsertarPerfilResponseDto;
import com.sise.postulape_backend.perfil.domain.entities.Perfil;
import com.sise.postulape_backend.common.application.IEntityDtoMapper;

@Component
public class InsertarPerfilMapper implements IEntityDtoMapper<Perfil, InsertarPerfilRequestDto, InsertarPerfilResponseDto> {

    @Override
    public Perfil requestToEntity(InsertarPerfilRequestDto requestDto) {
        Perfil perfil = new Perfil();
        perfil.setNombre(requestDto.getNombre());
        return perfil;
    }

    @Override
    public InsertarPerfilResponseDto entityToResponse(Perfil entity) {
        InsertarPerfilResponseDto response = new InsertarPerfilResponseDto();
        response.setIdPerfil(entity.getIdPerfil());
        response.setNombre(entity.getNombre());
        response.setIdEliminado(entity.getIdEliminado());
        response.setFechaCreacion(entity.getFechaCreacion());
        return response;
    }
}
