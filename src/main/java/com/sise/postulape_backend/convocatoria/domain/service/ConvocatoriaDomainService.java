package com.sise.postulape_backend.convocatoria.domain.service;

import com.sise.postulape_backend.convocatoria.domain.entities.Convocatoria;
import com.sise.postulape_backend.convocatoria.domain.repository.ConvocatoriaRepository;
import com.sise.postulape_backend.common.domain.exception.BusinessException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConvocatoriaDomainService {

    @Autowired
    private ConvocatoriaRepository convocatoriaRepository;

    public Convocatoria insertarConvocatoria(Convocatoria convocatoria) {
        List<Convocatoria> convocatoriasExistentes = convocatoriaRepository.findAll().stream()
            .filter(c -> c.getTitulo().equalsIgnoreCase(convocatoria.getTitulo()) 
            && "0".equals(c.getIdEliminado()))
            .collect(Collectors.toList());

        if (!convocatoriasExistentes.isEmpty()) {
            throw new BusinessException("Ya existe una convocatoria activa con el título: " + convocatoria.getTitulo());
        }

        return convocatoriaRepository.save(convocatoria);
    }

    public List<Convocatoria> listarConvocatorias() {
        List<Convocatoria> convocatorias = convocatoriaRepository.findAll();
        return convocatorias.stream()
                .filter(c -> "0".equals(c.getIdEliminado()))
                .sorted((c1, c2) -> c1.getIdConvocatoria().compareTo(c2.getIdConvocatoria()))
                .collect(Collectors.toList());
    }

    public Convocatoria obtenerConvocatoriaPorId(Integer id) {
        return convocatoriaRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Convocatoria no encontrada con id: " + id));
    }

    public Convocatoria actualizarConvocatoria(Convocatoria convocatoria) {
        return convocatoriaRepository.save(convocatoria);
    }

    public void eliminarConvocatoria(Integer id) { 
        Convocatoria convocatoria = obtenerConvocatoriaPorId(id); 
        convocatoria.setIdEliminado("1"); 
        actualizarConvocatoria(convocatoria); }
}
