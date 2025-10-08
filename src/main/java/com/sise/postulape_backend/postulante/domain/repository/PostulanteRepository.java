package com.sise.postulape_backend.postulante.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sise.postulape_backend.postulante.domain.entities.Postulante;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostulanteRepository extends JpaRepository<Postulante, Integer> {
    Optional<Postulante> findByNumeroDocumento(String numeroDocumento);
    List<Postulante> findByIdTipoDocumento(Integer idTipoDocumento);
    List<Postulante> findByIdEstadoCivil(Integer idEstadoCivil);
    List<Postulante> findByIdDepartamento(String idDepartamento);
    List<Postulante> findByIdProvincia(String idProvincia);
    List<Postulante> findByIdDistrito(String idDistrito);
    Optional<Postulante> findByTelefono(String telefono);
    Optional<Postulante> findByCelular(String celular);
    Optional<Postulante> findByIdUsuario(Integer idUsuario);
    List<Postulante> findByIdEliminado(String idEliminado);
}
