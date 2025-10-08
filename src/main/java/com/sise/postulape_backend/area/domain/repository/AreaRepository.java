package com.sise.postulape_backend.area.domain.repository;

import com.sise.postulape_backend.area.domain.entities.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {
    List<Area> findByIdEliminado(String idEliminado);
    List<Area> findByNombre(String nombre);
    List<Area> findByNombreAndDescripcion(String nombre, String descripcion);
}
