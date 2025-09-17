package com.sise.postulape_backend.postulante.application.response;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class InsertarPostulanteResponseDto {
    private Integer idPostulante;
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
    private String idEliminado;
    private Timestamp fechaCreacion;
}