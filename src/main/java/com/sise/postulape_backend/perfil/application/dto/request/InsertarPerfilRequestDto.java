package com.sise.postulape_backend.perfil.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class InsertarPerfilRequestDto {
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 50, message = "El nombre debe tener como máximo 50 caracteres")
    private String nombre;
}