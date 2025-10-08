package com.sise.postulape_backend.postulante.infraestructure.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sise.postulape_backend.postulante.application.dto.request.InsertarPostulanteRequestDto;
import com.sise.postulape_backend.postulante.application.dto.response.InsertarPostulanteResponseDto;
import com.sise.postulape_backend.postulante.application.dto.response.ListarPostulanteResponseDto;
import com.sise.postulape_backend.postulante.application.dto.request.ActualizarPostulanteRequestDto;
import com.sise.postulape_backend.postulante.application.dto.response.ActualizarPostulanteResponseDto;
import com.sise.postulape_backend.postulante.application.dto.response.EliminarPostulanteResponseDto;
import com.sise.postulape_backend.postulante.application.service.PostulanteApplicationService;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/postulantes")
@Tag(name = "Postulantes", description = "Operaciones CRUD para gestionar Postulantes")
public class PostulanteController {

    @Autowired
    private PostulanteApplicationService postulanteApplicationService;

    @Operation(summary = "Insertar un nuevo postulante", description = "Crea un nuevo postulante en el sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Postulante insertado exitosamente"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PostMapping("")
    public ResponseEntity<InsertarPostulanteResponseDto> insertarPostulante(
            @RequestBody InsertarPostulanteRequestDto requestDto) {
        try {
            InsertarPostulanteResponseDto responseDto = postulanteApplicationService.insertarPostulante(requestDto);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Operation(summary = "Listar postulantes", description = "Obtiene la lista de todos los postulantes registrados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de postulantes obtenida exitosamente"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("")
    public ResponseEntity<List<ListarPostulanteResponseDto>> listarPostulantes() {
        try {
            List<ListarPostulanteResponseDto> postulantes = postulanteApplicationService.listarPostulantes();
            return ResponseEntity.ok(postulantes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Operation(summary = "Actualizar postulante", description = "Actualiza un postulante existente por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Postulante actualizado exitosamente"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ActualizarPostulanteResponseDto> actualizarPostulante(
            @PathVariable Integer id,
            @RequestBody ActualizarPostulanteRequestDto requestDto) {
        try {
            ActualizarPostulanteResponseDto responseDto = postulanteApplicationService.actualizarPostulante(id, requestDto);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Operation(summary = "Eliminar postulante", description = "Elimina un postulante existente por su ID (logicamente)")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Postulante eliminado exitosamente"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<EliminarPostulanteResponseDto> eliminarPostulante(@PathVariable Integer id) {
        try {
            EliminarPostulanteResponseDto responseDto = postulanteApplicationService.eliminarPostulante(id);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
