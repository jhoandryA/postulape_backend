package com.sise.postulape_backend.etapa.application.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ActualizarEtapaRequestDto {

    @NotEmpty(message = "El nombre no puede estar vacío")
    @Size(max = 100, message = "El nombre debe tener como máximo 100 caracteres")
    private String nombre;
}