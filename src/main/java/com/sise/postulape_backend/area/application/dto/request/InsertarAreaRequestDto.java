package com.sise.postulape_backend.area.application.dto.request;



import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class InsertarAreaRequestDto {

    @NotEmpty(message = "El nombre no puede estar vacío")
    @Size(min=1 ,max = 100, message = "El nombre debe tener como minimo 1 y máximo 100 caracteres")
    private String nombre;

    @NotEmpty(message = "La descripción no puede estar vacía")
    @Size(min=5 ,max = 300, message = "La descripción debe tener como minimo 5 y máximo 300 caracteres")
    private String descripcion;
}