package com.sise.postulape_backend.perfil.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sise.postulape_backend.perfil.application.dto.request.InsertarPerfilRequestDto;
import com.sise.postulape_backend.perfil.application.dto.request.ActualizarPerfilRequestDto;
import com.sise.postulape_backend.perfil.application.dto.response.InsertarPerfilResponseDto;
import com.sise.postulape_backend.perfil.application.dto.response.ActualizarPerfilResponseDto;
import com.sise.postulape_backend.perfil.application.dto.response.EliminarPerfilResponseDto;
import com.sise.postulape_backend.perfil.application.dto.response.ListarPerfilResponseDto;
import com.sise.postulape_backend.perfil.application.service.PerfilApplicationService;
import com.sise.postulape_backend.common.application.dto.response.BaseResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/perfiles")
@Tag(name = "Perfil", description = "Operaciones CRUD para gestionar los perfiles")
public class PerfilController {

    @Autowired
    private PerfilApplicationService perfilApplicationService;

    // ➕ INSERTAR
    @PostMapping("")
    @Operation(summary = "Insertar nuevo perfil", description = "Crea un nuevo perfil en el sistema")
    public ResponseEntity<BaseResponseDto> insertarPerfil(
            @Valid @RequestBody InsertarPerfilRequestDto requestDto) {
        try {
            InsertarPerfilResponseDto responseDto = perfilApplicationService.insertarPerfil(requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto, "Perfil registrado correctamente"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    // 📋 LISTAR
    @GetMapping("")
    @Operation(summary = "Listar perfiles", description = "Obtiene todos los perfiles registrados")
    public ResponseEntity<BaseResponseDto> listarPerfiles() {
        try {
            List<ListarPerfilResponseDto> perfiles = perfilApplicationService.listarPerfiles();
            return ResponseEntity.ok(BaseResponseDto.success(perfiles, "Listado de perfiles obtenido correctamente"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    // ✏️ ACTUALIZAR
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar perfil", description = "Actualiza los datos de un perfil existente")
    public ResponseEntity<BaseResponseDto> actualizarPerfil(
            @PathVariable Integer id,
            @Valid @RequestBody ActualizarPerfilRequestDto requestDto) {
        try {
            ActualizarPerfilResponseDto responseDto = perfilApplicationService.actualizarPerfil(id, requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto, "Perfil actualizado correctamente"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    // 🗑️ ELIMINAR (lógico)
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar perfil", description = "Elimina un perfil del sistema por su ID (eliminación lógica)")
    public ResponseEntity<BaseResponseDto> eliminarPerfil(@PathVariable Integer id) {
        try {
            EliminarPerfilResponseDto responseDto = perfilApplicationService.eliminarPerfil(id);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto, "Perfil eliminado correctamente"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }
}