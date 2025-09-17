package com.sise.postulape_backend.convocatoria.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sise.postulape_backend.convocatoria.domain.entities.Convocatoria;

@Repository
public interface ConvocatoriaRepository extends JpaRepository<Convocatoria, Integer> {
}