package com.sise.postulape_backend.postulante.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sise.postulape_backend.postulante.application.dto.request.InsertarPostulanteRequestDto;
import com.sise.postulape_backend.postulante.application.dto.request.ActualizarPostulanteRequestDto;
import com.sise.postulape_backend.postulante.application.dto.response.InsertarPostulanteResponseDto;
import com.sise.postulape_backend.postulante.application.dto.response.ListarPostulanteResponseDto;
import com.sise.postulape_backend.postulante.application.dto.response.ActualizarPostulanteResponseDto;
import com.sise.postulape_backend.postulante.application.dto.response.EliminarPostulanteResponseDto;
import com.sise.postulape_backend.postulante.application.service.PostulanteApplicationService;
import com.sise.postulape_backend.common.application.dto.response.BaseResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/postulantes")
@Tag(name = "Postulantes", description = "Operaciones CRUD para gestionar postulantes")
public class PostulanteController {

    @Autowired
    private PostulanteApplicationService postulanteApplicationService;

    // ➕ INSERTAR
    @PostMapping("")
    @Operation(summary = "Insertar nuevo postulante", description = "Crea un nuevo postulante en el sistema")
    public ResponseEntity<BaseResponseDto> insertarPostulante(
            @Valid @RequestBody InsertarPostulanteRequestDto requestDto) {
        InsertarPostulanteResponseDto responseDto = postulanteApplicationService.insertarPostulante(requestDto);
        return ResponseEntity.ok(BaseResponseDto.success(responseDto, "Postulante registrado correctamente"));
    }

    // 📄 LISTAR
    @GetMapping("")
    @Operation(summary = "Listar postulantes", description = "Obtiene todos los postulantes registrados")
    public ResponseEntity<BaseResponseDto> listarPostulantes() {
        List<ListarPostulanteResponseDto> postulantes = postulanteApplicationService.listarPostulantes();
        return ResponseEntity.ok(BaseResponseDto.success(postulantes, "Listado de postulantes obtenido correctamente"));
    }

    // ✏️ ACTUALIZAR
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar postulante", description = "Actualiza los datos de un postulante existente")
    public ResponseEntity<BaseResponseDto> actualizarPostulante(
            @PathVariable Integer id,
            @Valid @RequestBody ActualizarPostulanteRequestDto requestDto) {
        ActualizarPostulanteResponseDto responseDto = postulanteApplicationService.actualizarPostulante(id, requestDto);
        return ResponseEntity.ok(BaseResponseDto.success(responseDto, "Postulante actualizado correctamente"));
    }

    // 🗑 ELIMINAR
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar postulante", description = "Elimina un postulante del sistema por su ID (lógicamente)")
    public ResponseEntity<BaseResponseDto> eliminarPostulante(@PathVariable Integer id) {
        EliminarPostulanteResponseDto responseDto = postulanteApplicationService.eliminarPostulante(id);
        return ResponseEntity.ok(BaseResponseDto.success(responseDto, "Postulante eliminado correctamente"));
    }
}
