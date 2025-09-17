package com.sise.postulape_backend.area.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.postulape_backend.area.application.dto.request.InsertarAreaRequestDto;
import com.sise.postulape_backend.area.application.dto.response.InsertarAreaResponseDto;
import com.sise.postulape_backend.area.domain.entities.Area;
import com.sise.postulape_backend.common.application.IEntityDtoMapper;

@Component
public class InsertarAreaMapper implements IEntityDtoMapper<Area, InsertarAreaRequestDto, InsertarAreaResponseDto> {
    
    @Override
    public Area requestToEntity(InsertarAreaRequestDto requestDto) {
        Area area = new Area();
        if (requestDto != null) {
            area.setNombre(requestDto.getNombre());
            area.setDescripcion(requestDto.getDescripcion());
        }
        
        return area;
    }

    @Override
    public InsertarAreaResponseDto entityToResponse(Area entity) {
        InsertarAreaResponseDto responseDto = new InsertarAreaResponseDto();
        if (entity != null) {
            responseDto.setIdArea(entity.getIdArea());
            responseDto.setNombre(entity.getNombre());
            responseDto.setDescripcion(entity.getDescripcion());
            responseDto.setIdEliminado(entity.getIdEliminado()); // Solo lectura
            responseDto.setFechaCreacion(entity.getFechaCreacion()); // Solo lectura
        }
        return responseDto;
    }
}