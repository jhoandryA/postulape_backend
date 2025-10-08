package com.sise.postulape_backend.perfil.domain.entities;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "perfiles")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfil")
    private Integer idPerfil;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "id_eliminado", insertable = false, updatable = true)
    private String idEliminado;

    @Column(name = "fecha_creacion", insertable = false, updatable = false)
    private LocalDateTime fechaCreacion;
}
