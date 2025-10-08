package com.sise.postulape_backend.perfil.application.mapper;

import org.springframework.stereotype.Component;
import com.sise.postulape_backend.perfil.application.dto.response.EliminarPerfilResponseDto;
import com.sise.postulape_backend.perfil.domain.entities.Perfil;
import com.sise.postulape_backend.common.application.IEntityDtoMapper;

import java.time.LocalDateTime;

@Component
public class EliminarPerfilMapper implements IEntityDtoMapper<Perfil, Integer, EliminarPerfilResponseDto> {

    @Override
    public Perfil requestToEntity(Integer id) {
        Perfil perfil = new Perfil();
        perfil.setIdPerfil(id);
        perfil.setIdEliminado("1");
        perfil.setFechaCreacion(LocalDateTime.now());
        return perfil;
    }

    @Override
    public EliminarPerfilResponseDto entityToResponse(Perfil entity) {
        EliminarPerfilResponseDto response = new EliminarPerfilResponseDto();
        response.setIdPerfil(entity.getIdPerfil());
        response.setMensaje("Perfil eliminado con éxito");
        return response;
    }
}
