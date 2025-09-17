package com.sise.postulape_backend.area.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.postulape_backend.area.application.dto.response.EliminarAreaResponseDto;
import com.sise.postulape_backend.area.domain.entities.Area;
import com.sise.postulape_backend.common.application.IEntityDtoMapper;

import java.time.LocalDateTime;

@Component
public class EliminarAreaMapper implements IEntityDtoMapper<Area, Integer, EliminarAreaResponseDto> {

    @Override
    public Area requestToEntity(Integer id) {
        Area area = new Area();
        area.setIdArea(id);
        area.setIdEliminado("1"); 
        area.setFechaCreacion(LocalDateTime.now()); 
        return area;
    }

    @Override
    public EliminarAreaResponseDto entityToResponse(Area entity) {
        EliminarAreaResponseDto responseDto = new EliminarAreaResponseDto();
        responseDto.setIdArea(entity.getIdArea());
        responseDto.setMensaje("Área eliminada con éxito");
        return responseDto;
    }
}