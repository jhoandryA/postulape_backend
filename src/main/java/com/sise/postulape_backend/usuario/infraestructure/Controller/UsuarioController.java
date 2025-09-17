package com.sise.postulape_backend.usuario.infraestructure.Controller;

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
public class UsuarioController {

    @Autowired
    private UsuarioApplicationService usuarioApplicationService;

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

    @GetMapping("")
    public ResponseEntity<List<ListarUsuarioResponseDto>> listarUsuarios() {
        try {
            List<ListarUsuarioResponseDto> usuarios = usuarioApplicationService.listarUsuarios();
            return ResponseEntity.ok(usuarios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

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
