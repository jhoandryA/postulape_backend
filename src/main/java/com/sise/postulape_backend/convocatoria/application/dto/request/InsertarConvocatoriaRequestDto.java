package com.sise.postulape_backend.convocatoria.application.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class InsertarConvocatoriaRequestDto {
    @NotEmpty(message = "El título no puede estar vacío")
    @Size(min=5 ,max = 100, message = "El título debe tener como minimo 5 y máximo 100 caracteres")
    private String titulo;

    @NotEmpty(message = "La descripción no puede estar vacía")
    @Size(min=5 ,max = 300, message = "La descripción debe tener como minimo 5 y máximo 300 caracteres")
    private String descripcion;

    @NotNull(message = "La fecha de inicio no puede ser nula")
    private LocalDate fechaInicio;

    @NotNull(message = "La fecha de fin no puede ser nula")
    private LocalDate fechaFin;

    @NotNull(message = "El ID del área no puede ser nulo")
    private Integer idArea;
}