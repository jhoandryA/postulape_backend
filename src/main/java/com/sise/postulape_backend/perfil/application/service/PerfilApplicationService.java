package com.sise.postulape_backend.perfil.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sise.postulape_backend.perfil.application.dto.request.*;
import com.sise.postulape_backend.perfil.application.dto.response.*;
import com.sise.postulape_backend.perfil.application.mapper.*;
import com.sise.postulape_backend.perfil.domain.entities.Perfil;
import com.sise.postulape_backend.perfil.domain.service.PerfilDomainService;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PerfilApplicationService {

    @Autowired
    private PerfilDomainService perfilDomainService;

    @Autowired
    private InsertarPerfilMapper insertarPerfilMapper;

    @Autowired
    private ListarPerfilMapper listarPerfilMapper;

    @Autowired
    private ActualizarPerfilMapper actualizarPerfilMapper;

    @Autowired
    private EliminarPerfilMapper eliminarPerfilMapper;

    // INSERTAR
    public InsertarPerfilResponseDto insertarPerfil(InsertarPerfilRequestDto requestDto) {
        Perfil perfil = perfilDomainService.insertarPerfil(insertarPerfilMapper.requestToEntity(requestDto));
        return insertarPerfilMapper.entityToResponse(perfil);
    }

    // LISTAR
    public List<ListarPerfilResponseDto> listarPerfiles() {
        List<Perfil> perfiles = perfilDomainService.listarPerfiles();
        return perfiles.stream()
                .map(listarPerfilMapper::entityToResponse)
                .collect(Collectors.toList());
    }

    // ACTUALIZAR
    public ActualizarPerfilResponseDto actualizarPerfil(Integer id, ActualizarPerfilRequestDto requestDto) {
        Perfil perfilExistente = perfilDomainService.obtenerPerfilPorId(id);
        actualizarPerfilMapper.updateEntityFromRequest(requestDto, perfilExistente);
        Perfil perfilActualizado = perfilDomainService.actualizarPerfil(perfilExistente);
        return actualizarPerfilMapper.entityToResponse(perfilActualizado);
    }

    // ELIMINAR
    public EliminarPerfilResponseDto eliminarPerfil(Integer id) {
        Perfil perfil = perfilDomainService.obtenerPerfilPorId(id);
        perfil.setIdEliminado("1");
        perfilDomainService.actualizarPerfil(perfil);
        return eliminarPerfilMapper.entityToResponse(perfil);
    }
}
