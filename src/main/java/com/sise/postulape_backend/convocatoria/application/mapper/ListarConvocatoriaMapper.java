package com.sise.postulape_backend.convocatoria.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.postulape_backend.convocatoria.application.dto.response.ListarConvocatoriaResponseDto;
import com.sise.postulape_backend.convocatoria.domain.entities.Convocatoria;
import com.sise.postulape_backend.common.application.IEntityDtoMapper;

@Component
public class ListarConvocatoriaMapper implements IEntityDtoMapper<Convocatoria, Void, ListarConvocatoriaResponseDto> {

    @Override
    public Convocatoria requestToEntity(Void requestDto) {
        throw new UnsupportedOperationException("Método no soportado para listar convocatorias");
    }

    @Override
    public ListarConvocatoriaResponseDto entityToResponse(Convocatoria entity) {
        ListarConvocatoriaResponseDto responseDto = new ListarConvocatoriaResponseDto();
        responseDto.setIdConvocatoria(entity.getIdConvocatoria());
        responseDto.setTitulo(entity.getTitulo());
        responseDto.setDescripcion(entity.getDescripcion());
        responseDto.setFechaInicio(entity.getFechaInicio());
        responseDto.setFechaFin(entity.getFechaFin());
        responseDto.setIdArea(entity.getIdArea());
        responseDto.setIdEliminado(entity.getIdEliminado());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
