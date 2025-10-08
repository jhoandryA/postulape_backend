package com.sise.postulape_backend.postulante.application.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class InsertarPostulanteRequestDto {

    @NotNull(message = "El ID de usuario no puede ser nulo")
    private Integer idUsuario;

    @NotNull(message = "El ID del tipo de documento no puede ser nulo")
    private Integer idTipoDocumento;

    @NotEmpty(message = "El número de documento no puede estar vacío")
    @Size(min = 5, max = 20, message = "El número de documento debe tener entre 5 y 20 caracteres")
    private String numeroDocumento;

    @NotNull(message = "El ID de género no puede ser nulo")
    private Integer idGenero;

    @NotNull(message = "El ID de estado civil no puede ser nulo")
    private Integer idEstadoCivil;

    @NotEmpty(message = "La dirección no puede estar vacía")
    @Size(min = 5, max = 200, message = "La dirección debe tener entre 5 y 200 caracteres")
    private String direccion;

    @NotEmpty(message = "El ID de departamento no puede estar vacío")
    @Size(min = 1, max = 5, message = "El ID de departamento debe tener entre 1 y 5 caracteres")
    private String idDepartamento;

    @NotEmpty(message = "El ID de provincia no puede estar vacío")
    @Size(min = 1, max = 5, message = "El ID de provincia debe tener entre 1 y 5 caracteres")
    private String idProvincia;

    @NotEmpty(message = "El ID de distrito no puede estar vacío")
    @Size(min = 1, max = 10, message = "El ID de distrito debe tener entre 1 y 5 caracteres")
    private String idDistrito;

    @NotEmpty(message = "El teléfono no puede estar vacío")
    @Size(min = 7, max = 8, message = "El teléfono debe tener entre 7 y 15 caracteres")
    private String telefono;

    @NotEmpty(message = "El celular no puede estar vacío")
    @Size(min = 9, max = 15, message = "El celular debe tener entre 9 y 15 caracteres")
    private String celular;
}