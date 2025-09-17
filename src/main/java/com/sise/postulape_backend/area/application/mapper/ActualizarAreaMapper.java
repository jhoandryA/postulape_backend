package com.sise.postulape_backend.area.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.postulape_backend.area.application.dto.request.ActualizarAreaRequestDto;
import com.sise.postulape_backend.area.application.dto.response.ActualizarAreaResponseDto;
import com.sise.postulape_backend.area.domain.entities.Area;
import com.sise.postulape_backend.common.application.IEntityDtoMapper;

@Component
public class ActualizarAreaMapper implements IEntityDtoMapper<Area, ActualizarAreaRequestDto, ActualizarAreaResponseDto> {

    @Override
    public Area requestToEntity(ActualizarAreaRequestDto requestDto) {
        Area area = new Area();
        area.setNombre(requestDto.getNombre());
        area.setDescripcion(requestDto.getDescripcion());
        return area;
    }

    @Override
    public ActualizarAreaResponseDto entityToResponse(Area entity) {
        ActualizarAreaResponseDto responseDto = new ActualizarAreaResponseDto();
        responseDto.setIdArea(entity.getIdArea());
        responseDto.setNombre(entity.getNombre());
        responseDto.setDescripcion(entity.getDescripcion());
        responseDto.setIdEliminado(entity.getIdEliminado());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }

    public void updateEntityFromRequest(ActualizarAreaRequestDto requestDto, Area entity) {
        if (requestDto.getNombre() != null) {
            entity.setNombre(requestDto.getNombre());
        }
        if (requestDto.getDescripcion() != null) {
            entity.setDescripcion(requestDto.getDescripcion());
        }
    }
}