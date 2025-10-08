package com.sise.postulape_backend.perfil.application.dto.response;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class InsertarPerfilResponseDto {
    private Integer idPerfil;
    private String nombre;
    private String idEliminado;
    private LocalDateTime fechaCreacion;
}