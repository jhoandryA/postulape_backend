package com.sise.postulape_backend.etapa.application.dto.response;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ListarEtapaResponseDto {
    private Integer idEtapa;
    private String nombre;
    private String idEliminado;
    private LocalDateTime fechaCreacion;
}