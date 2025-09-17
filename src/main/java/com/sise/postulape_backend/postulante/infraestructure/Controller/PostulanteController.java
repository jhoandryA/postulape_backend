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

@RestController
@RequestMapping("/postulantes")
public class PostulanteController {

    @Autowired
    private PostulanteApplicationService postulanteApplicationService;

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

    @GetMapping("")
    public ResponseEntity<List<ListarPostulanteResponseDto>> listarPostulantes() {
        try {
            List<ListarPostulanteResponseDto> postulantes = postulanteApplicationService.listarPostulantes();
            return ResponseEntity.ok(postulantes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

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
