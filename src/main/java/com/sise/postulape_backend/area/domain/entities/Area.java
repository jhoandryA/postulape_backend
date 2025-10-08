package com.sise.postulape_backend.area.domain.entities;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "areas")
public class Area {
    @Id
    @Column(name = "id_area")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idArea;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "id_eliminado", insertable = false, updatable = true)
    private String idEliminado;

    @Column(name = "fecha_creacion", insertable = false, updatable = false)
    private LocalDateTime fechaCreacion;
}