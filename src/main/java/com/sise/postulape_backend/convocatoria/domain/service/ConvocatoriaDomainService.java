package com.sise.postulape_backend.convocatoria.domain.service;

import com.sise.postulape_backend.convocatoria.domain.entities.Convocatoria;
import com.sise.postulape_backend.convocatoria.domain.repository.ConvocatoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ConvocatoriaDomainService {
    @Autowired
    private ConvocatoriaRepository convocatoriaRepository;

    public Convocatoria insertarConvocatoria(Convocatoria convocatoria) {
        return convocatoriaRepository.save(convocatoria);
    }

    public List<Convocatoria> listarConvocatorias() {
        return convocatoriaRepository.findAll().stream()
                .filter(convocatoria -> !"1".equals(convocatoria.getIdEliminado()))
                .collect(Collectors.toList());
    }

    public Convocatoria obtenerConvocatoriaPorId(Integer id) {
        return convocatoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Convocatoria no encontrada con id: " + id));
    }

    public Convocatoria actualizarConvocatoria(Convocatoria convocatoria) {
        return convocatoriaRepository.save(convocatoria);
    }

    public void eliminarConvocatoria(Integer id) {
        Convocatoria convocatoria = obtenerConvocatoriaPorId(id);
        convocatoria.setIdEliminado("1");
        actualizarConvocatoria(convocatoria);
    }
}