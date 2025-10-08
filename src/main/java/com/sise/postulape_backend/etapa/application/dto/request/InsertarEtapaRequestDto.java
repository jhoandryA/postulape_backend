package com.sise.postulape_backend.etapa.application.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class InsertarEtapaRequestDto {

    @NotEmpty(message = "El nombre no puede estar vacío")
    @Size(min = 5, max = 100, message = "El nombre debe tener entre 5 y 100 caracteres")
    private String nombre;
}