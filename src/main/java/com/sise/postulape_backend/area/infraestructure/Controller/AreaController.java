package com.sise.postulape_backend.area.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sise.postulape_backend.area.application.dto.request.ActualizarAreaRequestDto;
import com.sise.postulape_backend.area.application.dto.request.InsertarAreaRequestDto;
import com.sise.postulape_backend.area.application.dto.response.ActualizarAreaResponseDto;
import com.sise.postulape_backend.area.application.dto.response.EliminarAreaResponseDto;
import com.sise.postulape_backend.area.application.dto.response.InsertarAreaResponseDto;
import com.sise.postulape_backend.area.application.dto.response.ListarAreaResponseDto;
import com.sise.postulape_backend.area.application.service.AreaApplicationService;
import com.sise.postulape_backend.common.application.dto.response.BaseResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/areas")
@Tag(name = "Área", description = "Operaciones CRUD para gestionar áreas")
public class AreaController {
    
    @Autowired
    private AreaApplicationService areaApplicationService;


    @PostMapping("")
    @Operation(summary = "Insertar nueva área", description = "Crea una nueva área en el sistema")
    public ResponseEntity<BaseResponseDto> insertarArea(
            @Valid @RequestBody InsertarAreaRequestDto requestDto) {
        try {
            InsertarAreaResponseDto responseDto = areaApplicationService.insertarArea(requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto, "Área registrada correctamente"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }


    @GetMapping("")
    @Operation(summary = "Listar áreas", description = "Obtiene todas las áreas registradas")
    public ResponseEntity<BaseResponseDto> listarAreas() {
        try {
            List<ListarAreaResponseDto> areas = areaApplicationService.listarAreas();
            return ResponseEntity.ok(BaseResponseDto.success(areas, "Listado de áreas obtenido correctamente"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

 
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar área", description = "Actualiza los datos de un área existente")
    public ResponseEntity<BaseResponseDto> actualizarArea(
            @PathVariable Integer id,
            @Valid @RequestBody ActualizarAreaRequestDto requestDto) {
        try {
            ActualizarAreaResponseDto responseDto = areaApplicationService.actualizarArea(id, requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto, "Área actualizada correctamente"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar área", description = "Elimina un área del sistema por su ID (lógicamente)")
    public ResponseEntity<BaseResponseDto> eliminarArea(@PathVariable Integer id) {
        EliminarAreaResponseDto responseDto = areaApplicationService.eliminarArea(id);
        return ResponseEntity.ok(BaseResponseDto.success(responseDto, "Área eliminada correctamente"));
    }
}