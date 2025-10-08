package com.sise.postulape_backend.area.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.postulape_backend.area.application.dto.request.InsertarAreaRequestDto;
import com.sise.postulape_backend.area.application.dto.response.InsertarAreaResponseDto;
import com.sise.postulape_backend.area.application.dto.response.ListarAreaResponseDto;
import com.sise.postulape_backend.area.application.dto.request.ActualizarAreaRequestDto;
import com.sise.postulape_backend.area.application.dto.response.ActualizarAreaResponseDto;
import com.sise.postulape_backend.area.application.dto.response.EliminarAreaResponseDto;
import com.sise.postulape_backend.area.application.mapper.InsertarAreaMapper;
import com.sise.postulape_backend.area.application.mapper.ListarAreaMapper;
import com.sise.postulape_backend.area.application.mapper.ActualizarAreaMapper;
import com.sise.postulape_backend.area.application.mapper.EliminarAreaMapper;
import com.sise.postulape_backend.area.domain.entities.Area;
import com.sise.postulape_backend.area.domain.service.AreaDomainService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AreaApplicationService {

    @Autowired
    private AreaDomainService areaDomainService;

    @Autowired
    private InsertarAreaMapper insertarAreaMapper;

    @Autowired
    private ListarAreaMapper listarAreaMapper;

    @Autowired
    private ActualizarAreaMapper actualizarAreaMapper;

    @Autowired
    private EliminarAreaMapper eliminarAreaMapper;

    public InsertarAreaResponseDto insertarArea(InsertarAreaRequestDto requestDto) {
        Area area = areaDomainService.insertarArea(insertarAreaMapper.requestToEntity(requestDto));
        System.out.println("area_appservice::" + area.toString());
        return insertarAreaMapper.entityToResponse(area);
    }

    public List<ListarAreaResponseDto> listarAreas() {
        List<Area> areas = areaDomainService.listarAreas(null); 
        return areas.stream()
                .map(listarAreaMapper::entityToResponse)
                .collect(Collectors.toList());
    }

    public ActualizarAreaResponseDto actualizarArea(Integer id, ActualizarAreaRequestDto requestDto) {
        Area areaExistente = areaDomainService.obtenerAreaPorId(id);
        actualizarAreaMapper.updateEntityFromRequest(requestDto, areaExistente);
        Area areaActualizada = areaDomainService.actualizarArea(areaExistente);
        return actualizarAreaMapper.entityToResponse(areaActualizada);
    }

    public EliminarAreaResponseDto eliminarArea(Integer id) {
        Area area = areaDomainService.obtenerAreaPorId(id);
        area.setIdEliminado("1"); 
        areaDomainService.actualizarArea(area);
        return eliminarAreaMapper.entityToResponse(area); 
    }
}