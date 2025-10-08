package com.sise.postulape_backend.usuario.application.dto.response;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class InsertarUsuarioResponseDto {
    private Integer idUsuario;
    private String usuario;
    private String clave;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombre;
    private Integer idPerfil;
    private String idEliminado;
    private Timestamp fechaCreacion;
}
