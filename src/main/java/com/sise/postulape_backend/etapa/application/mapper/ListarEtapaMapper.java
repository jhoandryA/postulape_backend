package com.sise.postulape_backend.etapa.application.mapper;

import org.springframework.stereotype.Component;
import com.sise.postulape_backend.etapa.application.dto.response.ListarEtapaResponseDto;
import com.sise.postulape_backend.etapa.domain.entities.Etapa;
import com.sise.postulape_backend.common.application.IEntityDtoMapper;

@Component
public class ListarEtapaMapper implements IEntityDtoMapper<Etapa, Object, ListarEtapaResponseDto> {

    @Override
    public Etapa requestToEntity(Object requestDto) {
        throw new UnsupportedOperationException("Método no soportado para listar etapas");
    }

    @Override
    public ListarEtapaResponseDto entityToResponse(Etapa entity) {
        ListarEtapaResponseDto response = new ListarEtapaResponseDto();
        response.setIdEtapa(entity.getIdEtapa());
        response.setNombre(entity.getNombre());
        response.setIdEliminado(entity.getIdEliminado());
        response.setFechaCreacion(entity.getFechaCreacion());
        return response;
    }
}