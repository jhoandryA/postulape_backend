package com.sise.postulape_backend.convocatoria.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.postulape_backend.convocatoria.application.dto.request.InsertarConvocatoriaRequestDto;
import com.sise.postulape_backend.convocatoria.application.dto.response.InsertarConvocatoriaResponseDto;
import com.sise.postulape_backend.convocatoria.domain.entities.Convocatoria;
import com.sise.postulape_backend.common.application.IEntityDtoMapper;

@Component
public class InsertarConvocatoriaMapper implements IEntityDtoMapper<Convocatoria, InsertarConvocatoriaRequestDto, InsertarConvocatoriaResponseDto> {

    @Override
    public Convocatoria requestToEntity(InsertarConvocatoriaRequestDto requestDto) {
        Convocatoria convocatoria = new Convocatoria();
        convocatoria.setTitulo(requestDto.getTitulo());
        convocatoria.setDescripcion(requestDto.getDescripcion());
        convocatoria.setFechaInicio(requestDto.getFechaInicio());
        convocatoria.setFechaFin(requestDto.getFechaFin());
        convocatoria.setIdArea(requestDto.getIdArea());
        return convocatoria;
    }

    @Override
    public InsertarConvocatoriaResponseDto entityToResponse(Convocatoria entity) {
        InsertarConvocatoriaResponseDto responseDto = new InsertarConvocatoriaResponseDto();
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