package com.sise.postulape_backend.perfil.application.mapper;

import org.springframework.stereotype.Component;
import com.sise.postulape_backend.perfil.application.dto.request.ActualizarPerfilRequestDto;
import com.sise.postulape_backend.perfil.application.dto.response.ActualizarPerfilResponseDto;
import com.sise.postulape_backend.perfil.domain.entities.Perfil;
import com.sise.postulape_backend.common.application.IEntityDtoMapper;

@Component
public class ActualizarPerfilMapper implements IEntityDtoMapper<Perfil, ActualizarPerfilRequestDto, ActualizarPerfilResponseDto> {

    @Override
    public Perfil requestToEntity(ActualizarPerfilRequestDto requestDto) {
        Perfil perfil = new Perfil();
        perfil.setNombre(requestDto.getNombre());
        return perfil;
    }

    @Override
    public ActualizarPerfilResponseDto entityToResponse(Perfil entity) {
        ActualizarPerfilResponseDto response = new ActualizarPerfilResponseDto();
        response.setIdPerfil(entity.getIdPerfil());
        response.setNombre(entity.getNombre());
        response.setIdEliminado(entity.getIdEliminado());
        response.setFechaCreacion(entity.getFechaCreacion());
        return response;
    }

    public void updateEntityFromRequest(ActualizarPerfilRequestDto requestDto, Perfil entity) {
        if (requestDto.getNombre() != null) {
            entity.setNombre(requestDto.getNombre());
        }
    }
}