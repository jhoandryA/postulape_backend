package com.sise.postulape_backend.convocatoria.infraestructure.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sise.postulape_backend.convocatoria.application.dto.request.InsertarConvocatoriaRequestDto;
import com.sise.postulape_backend.convocatoria.application.dto.response.InsertarConvocatoriaResponseDto;
import com.sise.postulape_backend.convocatoria.application.dto.response.ListarConvocatoriaResponseDto;
import com.sise.postulape_backend.convocatoria.application.dto.request.ActualizarConvocatoriaRequestDto;
import com.sise.postulape_backend.convocatoria.application.dto.response.ActualizarConvocatoriaResponseDto;
import com.sise.postulape_backend.convocatoria.application.dto.response.EliminarConvocatoriaResponseDto;
import com.sise.postulape_backend.convocatoria.application.service.ConvocatoriaApplicationService;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/convocatorias")
@Tag(name = "Convocatorias", description = "Operaciones CRUD para gestionar Convocatorias")
public class ConvocatoriaController {

    @Autowired
    private ConvocatoriaApplicationService convocatoriaApplicationService;

    @Operation(summary = "Insertar nueva convocatoria", description = "Crea una nueva convocatoria en el sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Convocatoria insertada exitosamente"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PostMapping("")
    public ResponseEntity<InsertarConvocatoriaResponseDto> insertarConvocatoria(
            @RequestBody InsertarConvocatoriaRequestDto requestDto) {
        try {
            InsertarConvocatoriaResponseDto responseDto = convocatoriaApplicationService.insertarConvocatoria(requestDto);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Operation(summary = "Listar convocatorias", description = "Obtiene todas las convocatorias registradas")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de convocatorias obtenida exitosamente"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("")
    public ResponseEntity<List<ListarConvocatoriaResponseDto>> listarConvocatorias() {
        try {
            List<ListarConvocatoriaResponseDto> convocatorias = convocatoriaApplicationService.listarConvocatorias();
            return ResponseEntity.ok(convocatorias);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Operation(summary = "Actualizar convocatoria", description = "Actualiza una convocatoria existente por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Convocatoria actualizada exitosamente"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ActualizarConvocatoriaResponseDto> actualizarConvocatoria(
            @PathVariable Integer id,
            @RequestBody ActualizarConvocatoriaRequestDto requestDto) {
        try {
            ActualizarConvocatoriaResponseDto responseDto = convocatoriaApplicationService.actualizarConvocatoria(id, requestDto);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Operation(summary = "Eliminar convocatoria", description = "Elimina una convocatoria existente por su ID (logicamente)")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Convocatoria eliminada exitosamente"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<EliminarConvocatoriaResponseDto> eliminarConvocatoria(@PathVariable Integer id) {
        try {
            EliminarConvocatoriaResponseDto responseDto = convocatoriaApplicationService.eliminarConvocatoria(id);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}