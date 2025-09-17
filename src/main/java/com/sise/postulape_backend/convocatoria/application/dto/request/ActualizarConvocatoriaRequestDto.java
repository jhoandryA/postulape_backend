package com.sise.postulape_backend.convocatoria.application.dto.request;
import lombok.Data;
import java.time.LocalDate;

@Data
public class ActualizarConvocatoriaRequestDto {
    private String titulo;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Integer idArea;
}