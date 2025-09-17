package com.sise.postulape_backend.postulante.domain.entities;

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
@Table(name = "postulantes")
public class Postulante {
    @Id
    @Column(name = "id_postulante")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPostulante;

    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "id_tipo_documento")
    private Integer idTipoDocumento;

    @Column(name = "numero_documento")
    private String numeroDocumento;

    @Column(name = "id_genero")
    private Integer idGenero;

    @Column(name = "id_estado_civil")
    private Integer idEstadoCivil;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "id_departamento")
    private String idDepartamento;

    @Column(name = "id_provincia")
    private String idProvincia;

    @Column(name = "id_distrito")
    private String idDistrito;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "celular")
    private String celular;

    @Column(name = "id_eliminado", insertable = false, updatable = true)
    private String idEliminado;

    @Column(name = "fecha_creacion", insertable = false, updatable = false)
    private Timestamp fechaCreacion;
}
