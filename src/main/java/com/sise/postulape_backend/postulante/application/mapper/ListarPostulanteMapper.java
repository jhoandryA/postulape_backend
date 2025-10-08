package com.sise.postulape_backend.postulante.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.postulape_backend.postulante.application.dto.response.ListarPostulanteResponseDto;
import com.sise.postulape_backend.postulante.domain.entities.Postulante;
import com.sise.postulape_backend.common.application.IEntityDtoMapper;

@Component
public class ListarPostulanteMapper implements IEntityDtoMapper<Postulante, Void, ListarPostulanteResponseDto> {

    @Override
    public Postulante requestToEntity(Void requestDto) {
        throw new UnsupportedOperationException("Método no soportado para listar postulantes");
    }

    @Override
    public ListarPostulanteResponseDto entityToResponse(Postulante entity) {
        ListarPostulanteResponseDto responseDto = new ListarPostulanteResponseDto();
        responseDto.setIdPostulante(entity.getIdPostulante());
        responseDto.setIdUsuario(entity.getIdUsuario());
        responseDto.setIdTipoDocumento(entity.getIdTipoDocumento());
        responseDto.setNumeroDocumento(entity.getNumeroDocumento());
        responseDto.setIdGenero(entity.getIdGenero());
        responseDto.setIdEstadoCivil(entity.getIdEstadoCivil());
        responseDto.setDireccion(entity.getDireccion());
        responseDto.setIdDepartamento(entity.getIdDepartamento());
        responseDto.setIdProvincia(entity.getIdProvincia());
        responseDto.setIdDistrito(entity.getIdDistrito());
        responseDto.setTelefono(entity.getTelefono());
        responseDto.setCelular(entity.getCelular());
        responseDto.setIdEliminado(entity.getIdEliminado());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
