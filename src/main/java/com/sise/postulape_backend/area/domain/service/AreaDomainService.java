package com.sise.postulape_backend.area.domain.service;
import com.sise.postulape_backend.area.domain.entities.Area;
import com.sise.postulape_backend.area.domain.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AreaDomainService {

    @Autowired
    private AreaRepository areaRepository;

    public Area insertarArea(Area area) {
        return areaRepository.save(area);
    }

    public List<Area> listarAreas(String nombre) {
    List<Area> areas = areaRepository.findAll();
    return areas.stream()
            .filter(area -> "0".equals(area.getIdEliminado())) 
            .collect(Collectors.toList());
}

    public Area obtenerAreaPorId(Integer id) {
        return areaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Área no encontrada con id: " + id));
    }

    public Area actualizarArea(Area area) {
        return areaRepository.save(area);
    }

    public void eliminarArea(Integer id) {
        Area area = obtenerAreaPorId(id);
        area.setIdEliminado("1");
        actualizarArea(area);
    }
}