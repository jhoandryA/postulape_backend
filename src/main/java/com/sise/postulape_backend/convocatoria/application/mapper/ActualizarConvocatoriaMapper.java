package com.sise.postulape_backend.convocatoria.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.postulape_backend.convocatoria.application.dto.request.ActualizarConvocatoriaRequestDto;
import com.sise.postulape_backend.convocatoria.application.dto.response.ActualizarConvocatoriaResponseDto;
import com.sise.postulape_backend.convocatoria.domain.entities.Convocatoria;
import com.sise.postulape_backend.common.application.IEntityDtoMapper;

@Component
public class ActualizarConvocatoriaMapper implements IEntityDtoMapper<Convocatoria, ActualizarConvocatoriaRequestDto, ActualizarConvocatoriaResponseDto> {

    @Override
    public Convocatoria requestToEntity(ActualizarConvocatoriaRequestDto requestDto) {
        Convocatoria convocatoria = new Convocatoria();
        convocatoria.setTitulo(requestDto.getTitulo());
        convocatoria.setDescripcion(requestDto.getDescripcion());
        convocatoria.setFechaInicio(requestDto.getFechaInicio());
        convocatoria.setFechaFin(requestDto.getFechaFin());
        convocatoria.setIdArea(requestDto.getIdArea());
        return convocatoria;
    }

    @Override
    public ActualizarConvocatoriaResponseDto entityToResponse(Convocatoria entity) {
        ActualizarConvocatoriaResponseDto responseDto = new ActualizarConvocatoriaResponseDto();
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

    public void updateEntityFromRequest(ActualizarConvocatoriaRequestDto requestDto, Convocatoria entity) {
        if (requestDto.getTitulo() != null) {
            entity.setTitulo(requestDto.getTitulo());
        }
        if (requestDto.getDescripcion() != null) {
            entity.setDescripcion(requestDto.getDescripcion());
        }
        if (requestDto.getFechaInicio() != null) {
            entity.setFechaInicio(requestDto.getFechaInicio());
        }
        if (requestDto.getFechaFin() != null) {
            entity.setFechaFin(requestDto.getFechaFin());
        }
        if (requestDto.getIdArea() != null) {
            entity.setIdArea(requestDto.getIdArea());
        }
    }
}