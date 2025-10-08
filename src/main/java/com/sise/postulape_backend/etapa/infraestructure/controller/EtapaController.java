package com.sise.postulape_backend.etapa.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sise.postulape_backend.etapa.application.dto.request.InsertarEtapaRequestDto;
import com.sise.postulape_backend.etapa.application.dto.request.ActualizarEtapaRequestDto;
import com.sise.postulape_backend.etapa.application.dto.response.InsertarEtapaResponseDto;
import com.sise.postulape_backend.etapa.application.dto.response.ActualizarEtapaResponseDto;
import com.sise.postulape_backend.etapa.application.dto.response.EliminarEtapaResponseDto;
import com.sise.postulape_backend.etapa.application.dto.response.ListarEtapaResponseDto;
import com.sise.postulape_backend.etapa.application.service.EtapaApplicationService;
import com.sise.postulape_backend.common.application.dto.response.BaseResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/etapas")
@Tag(name = "Etapa", description = "Operaciones CRUD para gestionar las etapas")
public class EtapaController {

    @Autowired
    private EtapaApplicationService etapaApplicationService;

    // ➕ INSERTAR
    @PostMapping("")
    @Operation(summary = "Insertar nueva etapa", description = "Crea una nueva etapa en el sistema")
    public ResponseEntity<BaseResponseDto> insertarEtapa(
            @Valid @RequestBody InsertarEtapaRequestDto requestDto) {
        try {
            InsertarEtapaResponseDto responseDto = etapaApplicationService.insertarEtapa(requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto, "Etapa registrada correctamente"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    // 📋 LISTAR
    @GetMapping("")
    @Operation(summary = "Listar etapas", description = "Obtiene todas las etapas registradas")
    public ResponseEntity<BaseResponseDto> listarEtapas() {
        try {
            List<ListarEtapaResponseDto> etapas = etapaApplicationService.listarEtapas();
            return ResponseEntity.ok(BaseResponseDto.success(etapas, "Listado de etapas obtenido correctamente"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    // ✏️ ACTUALIZAR
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar etapa", description = "Actualiza los datos de una etapa existente")
    public ResponseEntity<BaseResponseDto> actualizarEtapa(
            @PathVariable Integer id,
            @Valid @RequestBody ActualizarEtapaRequestDto requestDto) {
        try {
            ActualizarEtapaResponseDto responseDto = etapaApplicationService.actualizarEtapa(id, requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto, "Etapa actualizada correctamente"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    // 🗑️ ELIMINAR (lógico)
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar etapa", description = "Elimina una etapa del sistema por su ID (eliminación lógica)")
    public ResponseEntity<BaseResponseDto> eliminarEtapa(@PathVariable Integer id) {
        try {
            EliminarEtapaResponseDto responseDto = etapaApplicationService.eliminarEtapa(id);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto, "Etapa eliminada correctamente"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }
}
