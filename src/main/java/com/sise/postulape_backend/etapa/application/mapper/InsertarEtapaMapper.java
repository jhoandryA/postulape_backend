package com.sise.postulape_backend.etapa.application.mapper;

import org.springframework.stereotype.Component;
import com.sise.postulape_backend.etapa.application.dto.request.InsertarEtapaRequestDto;
import com.sise.postulape_backend.etapa.application.dto.response.InsertarEtapaResponseDto;
import com.sise.postulape_backend.etapa.domain.entities.Etapa;
import com.sise.postulape_backend.common.application.IEntityDtoMapper;

@Component
public class InsertarEtapaMapper implements IEntityDtoMapper<Etapa, InsertarEtapaRequestDto, InsertarEtapaResponseDto> {

    @Override
    public Etapa requestToEntity(InsertarEtapaRequestDto requestDto) {
        Etapa etapa = new Etapa();
        etapa.setNombre(requestDto.getNombre());
        return etapa;
    }

    @Override
    public InsertarEtapaResponseDto entityToResponse(Etapa entity) {
        InsertarEtapaResponseDto response = new InsertarEtapaResponseDto();
        response.setIdEtapa(entity.getIdEtapa());
        response.setNombre(entity.getNombre());
        response.setIdEliminado(entity.getIdEliminado());
        response.setFechaCreacion(entity.getFechaCreacion());
        return response;
    }
}
