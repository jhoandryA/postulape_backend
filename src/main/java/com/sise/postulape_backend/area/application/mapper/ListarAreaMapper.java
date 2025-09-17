package com.sise.postulape_backend.area.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.postulape_backend.area.application.dto.request.ListarAreaRequestDto;
import com.sise.postulape_backend.area.application.dto.response.ListarAreaResponseDto;
import com.sise.postulape_backend.area.domain.entities.Area;
import com.sise.postulape_backend.common.application.IEntityDtoMapper;

@Component
public class ListarAreaMapper implements IEntityDtoMapper<Area, ListarAreaRequestDto, ListarAreaResponseDto> {

    @Override
    public Area requestToEntity(ListarAreaRequestDto requestDto) {
        throw new UnsupportedOperationException("Método no soportado para listar áreas");
    }

    @Override
    public ListarAreaResponseDto entityToResponse(Area entity) {
        ListarAreaResponseDto responseDto = new ListarAreaResponseDto();
        responseDto.setIdArea(entity.getIdArea());
        responseDto.setNombre(entity.getNombre());
        responseDto.setDescripcion(entity.getDescripcion());
        responseDto.setIdEliminado(entity.getIdEliminado());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}