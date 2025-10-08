package com.sise.postulape_backend.etapa.application.mapper;

import org.springframework.stereotype.Component;
import com.sise.postulape_backend.etapa.application.dto.response.EliminarEtapaResponseDto;
import com.sise.postulape_backend.etapa.domain.entities.Etapa;
import com.sise.postulape_backend.common.application.IEntityDtoMapper;
import java.time.LocalDateTime;

@Component
public class EliminarEtapaMapper implements IEntityDtoMapper<Etapa, Integer, EliminarEtapaResponseDto> {

    @Override
    public Etapa requestToEntity(Integer id) {
        Etapa etapa = new Etapa();
        etapa.setIdEtapa(id);
        etapa.setIdEliminado("1");
        etapa.setFechaCreacion(LocalDateTime.now());
        return etapa;
    }

    @Override
    public EliminarEtapaResponseDto entityToResponse(Etapa entity) {
        EliminarEtapaResponseDto response = new EliminarEtapaResponseDto();
        response.setIdEtapa(entity.getIdEtapa());
        response.setMensaje("Etapa eliminada con éxito");
        return response;
    }
}