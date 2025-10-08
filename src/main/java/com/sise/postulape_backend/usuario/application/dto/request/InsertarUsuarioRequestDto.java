package com.sise.postulape_backend.usuario.application.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class InsertarUsuarioRequestDto {
    @NotEmpty(message = "El usuario no puede estar vacío")
    @Size(min = 4, max = 50, message = "El usuario debe tener entre 4 y 50 caracteres")
    private String usuario;

    @NotEmpty(message = "La clave no puede estar vacía")
    @Size(min = 6, max = 100, message = "La clave debe tener entre 6 y 100 caracteres")
    private String clave;

    @NotEmpty(message = "El apellido paterno no puede estar vacío")
    @Size(min = 2, max = 50, message = "El apellido paterno debe tener entre 2 y 50 caracteres")
    private String apellidoPaterno;

    @NotEmpty(message = "El apellido materno no puede estar vacío")
    @Size(min = 2, max = 50, message  = "El apellido materno debe tener entre 2 y 50 caracteres")
    private String apellidoMaterno;

    @NotEmpty(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String nombre;

    private Integer idPerfil;
}
