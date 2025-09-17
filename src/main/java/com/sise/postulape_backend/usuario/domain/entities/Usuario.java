package com.sise.postulape_backend.usuario.domain.entities;

import java.sql.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column(name = "usuario", nullable = false, unique = true)
    private String usuario;

    @Column(name = "clave")
    private String clave;

    @Column(name = "apellido_paterno")
    private String apellidoPaterno;

    @Column(name = "apellido_materno")
    private String apellidoMaterno;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "id_perfil", nullable = false)
    private Integer idPerfil;

    @Column(name = "id_eliminado", insertable = false, updatable = true)
    private String idEliminado;

    @Column(name = "fecha_creacion", insertable = false, updatable = false)
    private Timestamp fechaCreacion;
}
