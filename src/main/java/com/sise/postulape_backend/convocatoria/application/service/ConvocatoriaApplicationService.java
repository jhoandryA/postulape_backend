package com.sise.postulape_backend.convocatoria.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.postulape_backend.convocatoria.application.dto.request.InsertarConvocatoriaRequestDto;
import com.sise.postulape_backend.convocatoria.application.dto.response.InsertarConvocatoriaResponseDto;
import com.sise.postulape_backend.convocatoria.application.dto.response.ListarConvocatoriaResponseDto;
import com.sise.postulape_backend.convocatoria.application.dto.request.ActualizarConvocatoriaRequestDto;
import com.sise.postulape_backend.convocatoria.application.dto.response.ActualizarConvocatoriaResponseDto;
import com.sise.postulape_backend.convocatoria.application.dto.response.EliminarConvocatoriaResponseDto;
import com.sise.postulape_backend.convocatoria.application.mapper.InsertarConvocatoriaMapper;
import com.sise.postulape_backend.convocatoria.application.mapper.ListarConvocatoriaMapper;
import com.sise.postulape_backend.convocatoria.application.mapper.ActualizarConvocatoriaMapper;
import com.sise.postulape_backend.convocatoria.application.mapper.EliminarConvocatoriaMapper;
import com.sise.postulape_backend.convocatoria.domain.entities.Convocatoria;
import com.sise.postulape_backend.convocatoria.domain.service.ConvocatoriaDomainService;

import java.util.List;
import java.util.stream.Collectors;



@Service
public class ConvocatoriaApplicationService {
    @Autowired
    private ConvocatoriaDomainService convocatoriaDomainService;

    @Autowired
    private InsertarConvocatoriaMapper insertarConvocatoriaMapper;

    @Autowired
    private ListarConvocatoriaMapper listarConvocatoriaMapper;

    @Autowired
    private ActualizarConvocatoriaMapper actualizarConvocatoriaMapper;

    @Autowired
    private EliminarConvocatoriaMapper eliminarConvocatoriaMapper;

    public InsertarConvocatoriaResponseDto insertarConvocatoria(InsertarConvocatoriaRequestDto requestDto) {
        Convocatoria convocatoria = convocatoriaDomainService.insertarConvocatoria(insertarConvocatoriaMapper.requestToEntity(requestDto));
        System.out.println("convocatoria_appservice::" + convocatoria.toString());
        return insertarConvocatoriaMapper.entityToResponse(convocatoria);
    }

    public List<ListarConvocatoriaResponseDto> listarConvocatorias() {
        List<Convocatoria> convocatorias = convocatoriaDomainService.listarConvocatorias();
        return convocatorias.stream()
                .map(listarConvocatoriaMapper::entityToResponse)
                .collect(Collectors.toList());
    }

    public ActualizarConvocatoriaResponseDto actualizarConvocatoria(Integer id, ActualizarConvocatoriaRequestDto requestDto) {
        Convocatoria convocatoriaExistente = convocatoriaDomainService.obtenerConvocatoriaPorId(id);
        actualizarConvocatoriaMapper.updateEntityFromRequest(requestDto, convocatoriaExistente);
        Convocatoria convocatoriaActualizado = convocatoriaDomainService.actualizarConvocatoria(convocatoriaExistente);
        return actualizarConvocatoriaMapper.entityToResponse(convocatoriaActualizado);
    }

    public EliminarConvocatoriaResponseDto eliminarConvocatoria(Integer id) {
        Convocatoria convocatoria = convocatoriaDomainService.obtenerConvocatoriaPorId(id);
        convocatoria.setIdEliminado("1");
        convocatoriaDomainService.eliminarConvocatoria(id);
        Convocatoria convocatoriaActualizada = convocatoriaDomainService.obtenerConvocatoriaPorId(id);
        return eliminarConvocatoriaMapper.entityToResponse(convocatoriaActualizada);
    }
}
