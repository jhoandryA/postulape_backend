package com.sise.postulape_backend.postulante.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.postulape_backend.postulante.application.dto.request.InsertarPostulanteRequestDto;
import com.sise.postulape_backend.postulante.application.dto.response.InsertarPostulanteResponseDto;
import com.sise.postulape_backend.postulante.application.dto.response.ListarPostulanteResponseDto;
import com.sise.postulape_backend.postulante.application.dto.request.ActualizarPostulanteRequestDto;
import com.sise.postulape_backend.postulante.application.dto.response.ActualizarPostulanteResponseDto;
import com.sise.postulape_backend.postulante.application.dto.response.EliminarPostulanteResponseDto;
import com.sise.postulape_backend.postulante.application.mapper.InsertarPostulanteMapper;
import com.sise.postulape_backend.postulante.application.mapper.ListarPostulanteMapper;
import com.sise.postulape_backend.postulante.application.mapper.ActualizarPostulanteMapper;
import com.sise.postulape_backend.postulante.application.mapper.EliminarPostulanteMapper;
import com.sise.postulape_backend.postulante.domain.entities.Postulante;
import com.sise.postulape_backend.postulante.domain.service.PostulanteDomainService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostulanteApplicationService {

    @Autowired
    private PostulanteDomainService postulanteDomainService;

    @Autowired
    private InsertarPostulanteMapper insertarPostulanteMapper;

    @Autowired
    private ListarPostulanteMapper listarPostulanteMapper;

    @Autowired
    private ActualizarPostulanteMapper actualizarPostulanteMapper;

    @Autowired
    private EliminarPostulanteMapper eliminarPostulanteMapper;

    public InsertarPostulanteResponseDto insertarPostulante(InsertarPostulanteRequestDto requestDto) {
        Postulante postulante = postulanteDomainService.insertarPostulante(insertarPostulanteMapper.requestToEntity(requestDto));
        return insertarPostulanteMapper.entityToResponse(postulante);
    }

    public List<ListarPostulanteResponseDto> listarPostulantes() {
        List<Postulante> postulantes = postulanteDomainService.listarPostulantes();
        return postulantes.stream()
                .map(listarPostulanteMapper::entityToResponse)
                .collect(Collectors.toList());
    }

    public ActualizarPostulanteResponseDto actualizarPostulante(Integer id, ActualizarPostulanteRequestDto requestDto) {
        Postulante postulanteExistente = postulanteDomainService.obtenerPostulantePorId(id);
        actualizarPostulanteMapper.updateEntityFromRequest(requestDto, postulanteExistente);
        Postulante postulanteActualizado = postulanteDomainService.actualizarPostulante(postulanteExistente);
        return actualizarPostulanteMapper.entityToResponse(postulanteActualizado);
    }

    public EliminarPostulanteResponseDto eliminarPostulante(Integer id) {
        Postulante postulante = postulanteDomainService.obtenerPostulantePorId(id);
        postulante.setIdEliminado("1");
        postulanteDomainService.eliminarPostulante(id);
        Postulante postulanteActualizado = postulanteDomainService.obtenerPostulantePorId(id);
        return eliminarPostulanteMapper.entityToResponse(postulanteActualizado);
    }
}
