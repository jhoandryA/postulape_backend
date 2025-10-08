package com.sise.postulape_backend.postulante.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.postulape_backend.postulante.domain.entities.Postulante;
import com.sise.postulape_backend.postulante.application.dto.response.EliminarPostulanteResponseDto;
import com.sise.postulape_backend.common.application.IEntityDtoMapper;

@Component
public class EliminarPostulanteMapper implements IEntityDtoMapper<Postulante, Integer, EliminarPostulanteResponseDto> {

    @Override
    public Postulante requestToEntity(Integer id) {
        Postulante postulante = new Postulante();
        postulante.setIdPostulante(id);
        return postulante;
    }

    @Override
    public EliminarPostulanteResponseDto entityToResponse(Postulante entity) {
        EliminarPostulanteResponseDto responseDto = new EliminarPostulanteResponseDto();
        responseDto.setIdPostulante(entity.getIdPostulante());
        responseDto.setMensaje("Postulante eliminado con éxito");
        return responseDto;
    }
}
