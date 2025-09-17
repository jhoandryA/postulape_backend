package com.sise.postulape_backend.convocatoria.domain.entities;

import java.time.LocalDate;
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
@Table(name = "convocatorias")
public class Convocatoria {
    @Id
    @Column(name = "id_convocatoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idConvocatoria;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "id_area")
    private Integer idArea;

    @Column(name = "id_eliminado", insertable = false, updatable = true)
    private String idEliminado;

    @Column(name = "fecha_creacion", insertable = false, updatable = false)
    private LocalDateTime fechaCreacion;
}