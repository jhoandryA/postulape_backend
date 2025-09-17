package com.sise.postulape_backend.usuario.application.dto.request;

import lombok.Data;

@Data
public class InsertarUsuarioRequestDto {
    private String usuario;
    private String clave;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombre;
    private Integer idPerfil;
}
