package com.sise.postulape_backend.perfil.application.mapper;

import org.springframework.stereotype.Component;
import com.sise.postulape_backend.perfil.application.dto.response.ListarPerfilResponseDto;
import com.sise.postulape_backend.perfil.domain.entities.Perfil;
import com.sise.postulape_backend.common.application.IEntityDtoMapper;

@Component
public class ListarPerfilMapper implements IEntityDtoMapper<Perfil, Object, ListarPerfilResponseDto> {

    @Override
    public Perfil requestToEntity(Object requestDto) {
        throw new UnsupportedOperationException("Método no soportado para listar perfiles");
    }

    @Override
    public ListarPerfilResponseDto entityToResponse(Perfil entity) {
        ListarPerfilResponseDto dto = new ListarPerfilResponseDto();
        dto.setIdPerfil(entity.getIdPerfil());
        dto.setNombre(entity.getNombre());
        dto.setIdEliminado(entity.getIdEliminado());
        dto.setFechaCreacion(entity.getFechaCreacion());
        return dto;
    }
}