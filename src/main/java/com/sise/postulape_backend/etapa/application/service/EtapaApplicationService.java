package com.sise.postulape_backend.etapa.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import com.sise.postulape_backend.etapa.domain.entities.Etapa;
import com.sise.postulape_backend.etapa.domain.service.EtapaDomainService;
import com.sise.postulape_backend.etapa.application.dto.request.InsertarEtapaRequestDto;
import com.sise.postulape_backend.etapa.application.dto.request.ActualizarEtapaRequestDto;
import com.sise.postulape_backend.etapa.application.dto.response.*;
import com.sise.postulape_backend.etapa.application.mapper.*;

@Service
public class EtapaApplicationService {

    @Autowired
    private EtapaDomainService etapaDomainService;

    @Autowired
    private InsertarEtapaMapper insertarEtapaMapper;

    @Autowired
    private ListarEtapaMapper listarEtapaMapper;

    @Autowired
    private ActualizarEtapaMapper actualizarEtapaMapper;

    @Autowired
    private EliminarEtapaMapper eliminarEtapaMapper;

    public InsertarEtapaResponseDto insertarEtapa(InsertarEtapaRequestDto requestDto) {
        Etapa etapa = etapaDomainService.insertarEtapa(insertarEtapaMapper.requestToEntity(requestDto));
        return insertarEtapaMapper.entityToResponse(etapa);
    }

    public List<ListarEtapaResponseDto> listarEtapas() {
        return etapaDomainService.listarEtapas().stream()
                .map(listarEtapaMapper::entityToResponse)
                .collect(Collectors.toList());
    }

    public ActualizarEtapaResponseDto actualizarEtapa(Integer id, ActualizarEtapaRequestDto requestDto) {
        Etapa etapaExistente = etapaDomainService.obtenerEtapaPorId(id);
        actualizarEtapaMapper.updateEntityFromRequest(requestDto, etapaExistente);
        Etapa etapaActualizada = etapaDomainService.actualizarEtapa(etapaExistente);
        return actualizarEtapaMapper.entityToResponse(etapaActualizada);
    }

    public EliminarEtapaResponseDto eliminarEtapa(Integer id) {
        Etapa etapa = etapaDomainService.obtenerEtapaPorId(id);
        etapa.setIdEliminado("1");
        etapaDomainService.actualizarEtapa(etapa);
        return eliminarEtapaMapper.entityToResponse(etapa);
    }
}