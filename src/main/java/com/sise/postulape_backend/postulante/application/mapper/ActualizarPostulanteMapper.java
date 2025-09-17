package com.sise.postulape_backend.postulante.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.postulape_backend.postulante.application.dto.request.ActualizarPostulanteRequestDto;
import com.sise.postulape_backend.postulante.application.dto.response.ActualizarPostulanteResponseDto;
import com.sise.postulape_backend.postulante.domain.entities.Postulante;
import com.sise.postulape_backend.common.application.IEntityDtoMapper;

@Component
public class ActualizarPostulanteMapper implements IEntityDtoMapper<Postulante, ActualizarPostulanteRequestDto, ActualizarPostulanteResponseDto> {

    @Override
    public Postulante requestToEntity(ActualizarPostulanteRequestDto requestDto) {
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
    public ActualizarPostulanteResponseDto entityToResponse(Postulante entity) {
        ActualizarPostulanteResponseDto responseDto = new ActualizarPostulanteResponseDto();
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

    public void updateEntityFromRequest(ActualizarPostulanteRequestDto requestDto, Postulante entity) {
        if (requestDto.getIdUsuario() != null) {
            entity.setIdUsuario(requestDto.getIdUsuario());
        }
        if (requestDto.getIdTipoDocumento() != null) {
            entity.setIdTipoDocumento(requestDto.getIdTipoDocumento());
        }
        if (requestDto.getNumeroDocumento() != null) {
            entity.setNumeroDocumento(requestDto.getNumeroDocumento());
        }
        if (requestDto.getIdGenero() != null) {
            entity.setIdGenero(requestDto.getIdGenero());
        }
        if (requestDto.getIdEstadoCivil() != null) {
            entity.setIdEstadoCivil(requestDto.getIdEstadoCivil());
        }
        if (requestDto.getDireccion() != null) {
            entity.setDireccion(requestDto.getDireccion());
        }
        if (requestDto.getIdDepartamento() != null) {
            entity.setIdDepartamento(requestDto.getIdDepartamento());
        }
        if (requestDto.getIdProvincia() != null) {
            entity.setIdProvincia(requestDto.getIdProvincia());
        }
        if (requestDto.getIdDistrito() != null) {
            entity.setIdDistrito(requestDto.getIdDistrito());
        }
        if (requestDto.getTelefono() != null) {
            entity.setTelefono(requestDto.getTelefono());
        }
        if (requestDto.getCelular() != null) {
            entity.setCelular(requestDto.getCelular());
        }
    }
}
