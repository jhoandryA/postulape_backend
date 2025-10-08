package com.sise.postulape_backend.area.domain.service;

import com.sise.postulape_backend.area.domain.entities.Area;
import com.sise.postulape_backend.area.domain.repository.AreaRepository;
import com.sise.postulape_backend.common.domain.exception.BusinessException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AreaDomainService {

    @Autowired
    private AreaRepository areaRepository;

    public Area insertarArea(Area area) {
    List<Area> areasExistentes = areaRepository.findAll().stream()
            .filter(a -> a.getNombre().equalsIgnoreCase(area.getNombre()) && "0".equals(a.getIdEliminado()))
            .collect(Collectors.toList());

    if (!areasExistentes.isEmpty()) {
        throw new BusinessException("Ya existe un área activa con el nombre: " + area.getNombre());
    }

    return areaRepository.save(area);
}

    public List<Area> listarAreas(String nombre) {
    List<Area> areas = areaRepository.findAll();
    return areas.stream()
            .filter(area -> "0".equals(area.getIdEliminado()))
            .sorted((a1, a2) -> a1.getIdArea().compareTo(a2.getIdArea())) 
            .collect(Collectors.toList());
}

    public Area obtenerAreaPorId(Integer id) {
    return areaRepository.findById(id)
            .orElseThrow(() -> new BusinessException("Área no encontrada con id: " + id));
}

    public Area actualizarArea(Area area) {
        return areaRepository.save(area);
    }

    public void eliminarArea(Integer id) {
    Area area = obtenerAreaPorId(id);

    if ("1".equals(area.getIdEliminado())) {
        throw new BusinessException("El área ya fue eliminada anteriormente");
    }

    area.setIdEliminado("1");
    actualizarArea(area);
}
}