package com.sise.postulape_backend.area.application.dto.response;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ActualizarAreaResponseDto {
    private Integer idArea;
    private String nombre;
    private String descripcion;
    private String idEliminado;
    private LocalDateTime fechaCreacion;
}