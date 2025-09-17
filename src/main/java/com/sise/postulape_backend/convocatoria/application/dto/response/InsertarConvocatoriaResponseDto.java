package com.sise.postulape_backend.convocatoria.application.dto.response;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class InsertarConvocatoriaResponseDto {
    private Integer idConvocatoria;
    private String titulo;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Integer idArea;
    private String idEliminado;
    private LocalDateTime fechaCreacion;
}