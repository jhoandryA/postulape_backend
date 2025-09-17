package com.sise.postulape_backend.postulante.domain.service;

import com.sise.postulape_backend.postulante.domain.entities.Postulante;
import com.sise.postulape_backend.postulante.domain.repository.PostulanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostulanteDomainService {

    @Autowired
    private PostulanteRepository postulanteRepository;

    public Postulante insertarPostulante(Postulante postulante) {
        return postulanteRepository.save(postulante);
    }

    public List<Postulante> listarPostulantes() {
        return postulanteRepository.findAll().stream()
                .filter(postulante -> !"1".equals(postulante.getIdEliminado()))
                .collect(Collectors.toList());
    }

    public Postulante obtenerPostulantePorId(Integer id) {
        return postulanteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Postulante no encontrado con id: " + id));
    }

    public Postulante actualizarPostulante(Postulante postulante) {
        return postulanteRepository.save(postulante);
    }

    public void eliminarPostulante(Integer id) {
        Postulante postulante = obtenerPostulantePorId(id);
        postulante.setIdEliminado("1");
        actualizarPostulante(postulante);
    }
}

