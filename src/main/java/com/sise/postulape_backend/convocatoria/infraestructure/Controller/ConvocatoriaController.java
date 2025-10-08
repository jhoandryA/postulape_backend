package com.sise.postulape_backend.convocatoria.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sise.postulape_backend.convocatoria.application.dto.request.InsertarConvocatoriaRequestDto;
import com.sise.postulape_backend.convocatoria.application.dto.request.ActualizarConvocatoriaRequestDto;
import com.sise.postulape_backend.convocatoria.application.dto.response.InsertarConvocatoriaResponseDto;
import com.sise.postulape_backend.convocatoria.application.dto.response.ListarConvocatoriaResponseDto;
import com.sise.postulape_backend.convocatoria.application.dto.response.ActualizarConvocatoriaResponseDto;
import com.sise.postulape_backend.convocatoria.application.dto.response.EliminarConvocatoriaResponseDto;
import com.sise.postulape_backend.convocatoria.application.service.ConvocatoriaApplicationService;
import com.sise.postulape_backend.common.application.dto.response.BaseResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/convocatorias")
@Tag(name = "Convocatorias", description = "Operaciones CRUD para gestionar convocatorias")
public class ConvocatoriaController {

    @Autowired
    private ConvocatoriaApplicationService convocatoriaApplicationService;

    
    @PostMapping("")
    @Operation(summary = "Insertar nueva convocatoria", description = "Crea una nueva convocatoria en el sistema")
    public ResponseEntity<BaseResponseDto> insertarConvocatoria(
            @Valid @RequestBody InsertarConvocatoriaRequestDto requestDto) {
        InsertarConvocatoriaResponseDto responseDto = convocatoriaApplicationService.insertarConvocatoria(requestDto);
        return ResponseEntity.ok(BaseResponseDto.success(responseDto, "Convocatoria registrada correctamente"));
    }

    
    @GetMapping("")
    @Operation(summary = "Listar convocatorias", description = "Obtiene todas las convocatorias registradas")
    public ResponseEntity<BaseResponseDto> listarConvocatorias() {
        List<ListarConvocatoriaResponseDto> convocatorias = convocatoriaApplicationService.listarConvocatorias();
        return ResponseEntity.ok(BaseResponseDto.success(convocatorias, "Listado de convocatorias obtenido correctamente"));
    }

    
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar convocatoria", description = "Actualiza los datos de una convocatoria existente")
    public ResponseEntity<BaseResponseDto> actualizarConvocatoria(
            @PathVariable Integer id,
            @Valid @RequestBody ActualizarConvocatoriaRequestDto requestDto) {
        ActualizarConvocatoriaResponseDto responseDto = convocatoriaApplicationService.actualizarConvocatoria(id, requestDto);
        return ResponseEntity.ok(BaseResponseDto.success(responseDto, "Convocatoria actualizada correctamente"));
    }

    
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar convocatoria", description = "Elimina una convocatoria del sistema por su ID (lógicamente)")
    public ResponseEntity<BaseResponseDto> eliminarConvocatoria(@PathVariable Integer id) {
        EliminarConvocatoriaResponseDto responseDto = convocatoriaApplicationService.eliminarConvocatoria(id);
        return ResponseEntity.ok(BaseResponseDto.success(responseDto, "Convocatoria eliminada correctamente"));
    }
}
