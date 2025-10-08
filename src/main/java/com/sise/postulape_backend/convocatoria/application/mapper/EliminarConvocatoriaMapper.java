package com.sise.postulape_backend.convocatoria.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.postulape_backend.convocatoria.domain.entities.Convocatoria;
import com.sise.postulape_backend.convocatoria.application.dto.response.EliminarConvocatoriaResponseDto;
import com.sise.postulape_backend.common.application.IEntityDtoMapper;

@Component
public class EliminarConvocatoriaMapper implements IEntityDtoMapper<Convocatoria, Integer, EliminarConvocatoriaResponseDto> {

    @Override
    public Convocatoria requestToEntity(Integer id) {
        Convocatoria convocatoria = new Convocatoria();
        convocatoria.setIdConvocatoria(id);
        return convocatoria;
    }

    @Override
    public EliminarConvocatoriaResponseDto entityToResponse(Convocatoria entity) {
        EliminarConvocatoriaResponseDto responseDto = new EliminarConvocatoriaResponseDto();
        responseDto.setIdConvocatoria(entity.getIdConvocatoria());
        responseDto.setMensaje("Convocatoria eliminada con éxito");
        return responseDto;
    }
}
