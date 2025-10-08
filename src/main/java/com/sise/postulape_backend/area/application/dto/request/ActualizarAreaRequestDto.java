package com.sise.postulape_backend.area.application.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ActualizarAreaRequestDto {

    @NotEmpty(message = "El nombre no puede estar vacío")
    @Size(max = 100, message = "El nombre debe tener como máximo 100 caracteres")
    private String nombre;

    @NotEmpty(message = "La descripción no puede estar vacía")
    @Size(max = 300, message = "La descripción debe tener como máximo 300 caracteres")
    private String descripcion;
}
