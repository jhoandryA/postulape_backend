package com.sise.postulape_backend.postulante.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.postulape_backend.postulante.application.dto.request.InsertarPostulanteRequestDto;
import com.sise.postulape_backend.postulante.application.dto.response.InsertarPostulanteResponseDto;
import com.sise.postulape_backend.postulante.domain.entities.Postulante;
import com.sise.postulape_backend.common.application.IEntityDtoMapper;

@Component
public class InsertarPostulanteMapper implements IEntityDtoMapper<Postulante, InsertarPostulanteRequestDto, InsertarPostulanteResponseDto> {

    @Override
    public Postulante requestToEntity(InsertarPostulanteRequestDto requestDto) {
        Postulante postulante = new Postulante();
        postulante.setIdUsuario(requestDto.getIdUsuario());
        postulante.setIdTipoDocumento(requestDto.getIdTipoDocumento());
        postulante.setNumeroDocumento(requestDto.getNumeroDocumento());
        postulante.setIdGenero(requestDto.getIdGenero());
        postulante.setIdEstadoCivil(requestDto.getIdEstadoCivil());
        postulante.setDireccion(requestDto.getDireccion());
        postulante.setIdDepartamento(requestDto.getIdDepartamento());
        postulante.setIdProvincia(requestDto.getIdProvincia());
        postulante.setIdDistrito(requestDto.getIdDistrito());
        postulante.setTelefono(requestDto.getTelefono());
        postulante.setCelular(requestDto.getCelular());
        return postulante;
    }

    @Override
    public InsertarPostulanteResponseDto entityToResponse(Postulante entity) {
        InsertarPostulanteResponseDto responseDto = new InsertarPostulanteResponseDto();
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
