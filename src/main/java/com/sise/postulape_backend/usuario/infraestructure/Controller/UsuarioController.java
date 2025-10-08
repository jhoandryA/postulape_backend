package com.sise.postulape_backend.usuario.infraestructure.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sise.postulape_backend.usuario.application.dto.request.InsertarUsuarioRequestDto;
import com.sise.postulape_backend.usuario.application.dto.request.ActualizarUsuarioRequestDto;
import com.sise.postulape_backend.usuario.application.dto.response.InsertarUsuarioResponseDto;
import com.sise.postulape_backend.usuario.application.dto.response.ListarUsuarioResponseDto;
import com.sise.postulape_backend.usuario.application.dto.response.ActualizarUsuarioResponseDto;
import com.sise.postulape_backend.usuario.application.dto.response.EliminarUsuarioResponseDto;
import com.sise.postulape_backend.usuario.application.service.UsuarioApplicationService;
import com.sise.postulape_backend.common.application.dto.response.BaseResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Usuarios", description = "Operaciones CRUD para gestionar usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioApplicationService usuarioApplicationService;

    @PostMapping("")
    @Operation(summary = "Insertar nuevo usuario", description = "Crea un nuevo usuario en el sistema")
    public ResponseEntity<BaseResponseDto> insertarUsuario(@Valid @RequestBody InsertarUsuarioRequestDto requestDto) {
        InsertarUsuarioResponseDto responseDto = usuarioApplicationService.insertarUsuario(requestDto);
        return ResponseEntity.ok(BaseResponseDto.success(responseDto, "Usuario registrado correctamente"));
    }

    @GetMapping("")
    @Operation(summary = "Listar usuarios", description = "Obtiene todos los usuarios registrados")
    public ResponseEntity<BaseResponseDto> listarUsuarios() {
        List<ListarUsuarioResponseDto> usuarios = usuarioApplicationService.listarUsuarios();
        return ResponseEntity.ok(BaseResponseDto.success(usuarios, "Listado de usuarios obtenido correctamente"));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar usuario", description = "Actualiza los datos de un usuario existente")
    public ResponseEntity<BaseResponseDto> actualizarUsuario(
            @PathVariable Integer id,
            @Valid @RequestBody ActualizarUsuarioRequestDto requestDto) {
        ActualizarUsuarioResponseDto responseDto = usuarioApplicationService.actualizarUsuario(id, requestDto);
        return ResponseEntity.ok(BaseResponseDto.success(responseDto, "Usuario actualizado correctamente"));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar usuario", description = "Elimina un usuario del sistema por su ID (lógicamente)")
    public ResponseEntity<BaseResponseDto> eliminarUsuario(@PathVariable Integer id) {
        EliminarUsuarioResponseDto responseDto = usuarioApplicationService.eliminarUsuario(id);
        return ResponseEntity.ok(BaseResponseDto.success(responseDto, "Usuario eliminado correctamente"));
    }
}