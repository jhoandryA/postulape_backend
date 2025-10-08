package com.sise.postulape_backend.perfil.domain.service;

import com.sise.postulape_backend.perfil.domain.entities.Perfil;
import com.sise.postulape_backend.common.domain.exception.BusinessException;
import com.sise.postulape_backend.perfil.domain.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PerfilDomainService {

    @Autowired
    private PerfilRepository perfilRepository;

    public Perfil insertarPerfil(Perfil perfil) {
        if (perfilRepository.existsByNombre(perfil.getNombre())) {
            throw new BusinessException("El perfil ya existe con ese nombre");
        }
        return perfilRepository.save(perfil);
    }

    public List<Perfil> listarPerfiles() {
        return perfilRepository.findByIdEliminado("0");
    }

    public Perfil obtenerPerfilPorId(Integer id) {
        return perfilRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Perfil no encontrado"));
    }

    public Perfil actualizarPerfil(Perfil perfilActualizado) {
        Perfil perfil = perfilRepository.findById(perfilActualizado.getIdPerfil())
                .orElseThrow(() -> new BusinessException("Perfil no encontrado"));
        perfil.setNombre(perfilActualizado.getNombre());
        return perfilRepository.save(perfil);
    }

    public Perfil eliminarPerfil(Integer id) {
        Perfil perfil = perfilRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Perfil no encontrado"));
        perfil.setIdEliminado("1");
        return perfilRepository.save(perfil);
    }
}