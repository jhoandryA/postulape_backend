package com.sise.postulape_backend.perfil.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sise.postulape_backend.perfil.domain.entities.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Integer> {
    boolean existsByNombre(String nombre);
    List<Perfil> findByIdEliminado(String idEliminado);
}