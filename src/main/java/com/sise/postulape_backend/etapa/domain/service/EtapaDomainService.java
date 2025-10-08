package com.sise.postulape_backend.etapa.domain.service;

import com.sise.postulape_backend.etapa.domain.entities.Etapa;
import com.sise.postulape_backend.etapa.domain.repository.EtapaRepository;
import com.sise.postulape_backend.common.domain.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EtapaDomainService {

    @Autowired
    private EtapaRepository etapaRepository;

    // ➕ Insertar nueva etapa
    public Etapa insertarEtapa(Etapa etapa) {
        List<Etapa> etapasExistentes = etapaRepository.findAll().stream()
                .filter(e -> e.getNombre().equalsIgnoreCase(etapa.getNombre()) && "0".equals(e.getIdEliminado()))
                .collect(Collectors.toList());

        if (!etapasExistentes.isEmpty()) {
            throw new BusinessException("Ya existe una etapa activa con el nombre: " + etapa.getNombre());
        }

        return etapaRepository.save(etapa);
    }

    // 📋 Listar etapas activas
    public List<Etapa> listarEtapas() {
        return etapaRepository.findAll().stream()
                .filter(e -> "0".equals(e.getIdEliminado()))
                .sorted((e1, e2) -> e1.getIdEtapa().compareTo(e2.getIdEtapa()))
                .collect(Collectors.toList());
    }

    // 🔍 Buscar por ID
    public Etapa obtenerEtapaPorId(Integer id) {
        return etapaRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Etapa no encontrada con id: " + id));
    }

    // ✏️ Actualizar
    public Etapa actualizarEtapa(Etapa etapa) {
        return etapaRepository.save(etapa);
    }

    // 🗑️ Eliminar lógico
    public void eliminarEtapa(Integer id) {
        Etapa etapa = obtenerEtapaPorId(id);

        if ("1".equals(etapa.getIdEliminado())) {
            throw new BusinessException("La etapa ya fue eliminada anteriormente");
        }

        etapa.setIdEliminado("1");
        actualizarEtapa(etapa);
    }
}
