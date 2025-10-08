package com.sise.postulape_backend.usuario.infraestructure.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sise.postulape_backend.usuario.application.dto.request.InsertarUsuarioRequestDto;
import com.sise.postulape_backend.usuario.application.dto.response.InsertarUsuarioResponseDto;
import com.sise.postulape_backend.usuario.application.dto.response.ListarUsuarioResponseDto;
import com.sise.postulape_backend.usuario.application.dto.request.ActualizarUsuarioRequestDto;
import com.sise.postulape_backend.usuario.application.dto.response.ActualizarUsuarioResponseDto;
import com.sise.postulape_backend.usuario.application.dto.response.EliminarUsuarioResponseDto;
import com.sise.postulape_backend.usuario.application.service.UsuarioApplicationService;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Usuarios", description = "Operaciones CRUD para gestionar Usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioApplicationService usuarioApplicationService;

    @Operation(summary = "Inserta un nuevo usuario", description = "Crea un usuario en el sistema de reclutamiento")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Usuario registrado con éxito"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PostMapping("")
    public ResponseEntity<InsertarUsuarioResponseDto> insertarUsuario(
            @RequestBody InsertarUsuarioRequestDto requestDto) {
        try {
            InsertarUsuarioResponseDto responseDto = usuarioApplicationService.insertarUsuario(requestDto);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Operation(summary = "Listar usuarios", description = "Obtiene el listado completo de usuarios registrados")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Listado obtenido con éxito"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("")
    public ResponseEntity<List<ListarUsuarioResponseDto>> listarUsuarios() {
        try {
            List<ListarUsuarioResponseDto> usuarios = usuarioApplicationService.listarUsuarios();
            return ResponseEntity.ok(usuarios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Operation(summary = "Actualizar usuario", description = "Modifica la información de un usuario según su ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Usuario actualizado con éxito"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ActualizarUsuarioResponseDto> actualizarUsuario(
            @PathVariable Integer id,
            @RequestBody ActualizarUsuarioRequestDto requestDto) {
        try {
            ActualizarUsuarioResponseDto responseDto = usuarioApplicationService.actualizarUsuario(id, requestDto);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Operation(summary = "Eliminar usuario", description = "Elimina un usuario del sistema por su ID (logicamente)")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Usuario eliminado con éxito"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<EliminarUsuarioResponseDto> eliminarUsuario(@PathVariable Integer id) {
        try {
            EliminarUsuarioResponseDto responseDto = usuarioApplicationService.eliminarUsuario(id);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
