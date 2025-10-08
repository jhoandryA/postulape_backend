package com.sise.postulape_backend.etapa.domain.repository;

import com.sise.postulape_backend.etapa.domain.entities.Etapa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EtapaRepository extends JpaRepository<Etapa, Integer> {
    List<Etapa> findByIdEliminado(String idEliminado);
    List<Etapa> findByNombre(String nombre);
}
