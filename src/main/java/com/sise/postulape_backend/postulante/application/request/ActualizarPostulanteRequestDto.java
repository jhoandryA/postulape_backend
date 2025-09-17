package com.sise.postulape_backend.postulante.application.request;

import lombok.Data;

@Data
public class ActualizarPostulanteRequestDto {
    private Integer idUsuario;
    private Integer idTipoDocumento;
    private String numeroDocumento;
    private Integer idGenero;
    private Integer idEstadoCivil;
    private String direccion;
    private String idDepartamento;
    private String idProvincia;
    private String idDistrito;
    private String telefono;
    private String celular;
}

