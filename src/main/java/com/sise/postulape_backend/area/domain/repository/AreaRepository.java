package com.sise.postulape_backend.area.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sise.postulape_backend.area.domain.entities.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area,Integer> {
    
}