package com.sise.postulape_backend.postulante.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sise.postulape_backend.postulante.domain.entities.Postulante;

@Repository
public interface PostulanteRepository extends JpaRepository<Postulante, Integer> {
}
