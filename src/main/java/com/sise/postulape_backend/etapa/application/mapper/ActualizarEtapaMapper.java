package com.sise.postulape_backend.etapa.application.mapper;

import org.springframework.stereotype.Component;
import com.sise.postulape_backend.etapa.application.dto.request.ActualizarEtapaRequestDto;
import com.sise.postulape_backend.etapa.application.dto.response.ActualizarEtapaResponseDto;
import com.sise.postulape_backend.etapa.domain.entities.Etapa;
import com.sise.postulape_backend.common.application.IEntityDtoMapper;

@Component
public class ActualizarEtapaMapper implements IEntityDtoMapper<Etapa, ActualizarEtapaRequestDto, ActualizarEtapaResponseDto> {

    @Override
    public Etapa requestToEntity(ActualizarEtapaRequestDto requestDto) {
        Etapa etapa = new Etapa();
        etapa.setNombre(requestDto.getNombre());
        return etapa;
    }

    @Override
    public ActualizarEtapaResponseDto entityToResponse(Etapa entity) {
        ActualizarEtapaResponseDto response = new ActualizarEtapaResponseDto();
        response.setIdEtapa(entity.getIdEtapa());
        response.setNombre(entity.getNombre());
        response.setIdEliminado(entity.getIdEliminado());
        response.setFechaCreacion(entity.getFechaCreacion());
        return response;
    }

    public void updateEntityFromRequest(ActualizarEtapaRequestDto requestDto, Etapa entity) {
        if (requestDto.getNombre() != null) {
            entity.setNombre(requestDto.getNombre());
        }
    }
}