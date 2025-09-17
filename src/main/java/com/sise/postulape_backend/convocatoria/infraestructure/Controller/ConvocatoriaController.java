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



@RestController
@RequestMapping("/convocatorias")
public class ConvocatoriaController {

    @Autowired
    private ConvocatoriaApplicationService convocatoriaApplicationService;

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

    @GetMapping("")
    public ResponseEntity<List<ListarConvocatoriaResponseDto>> listarConvocatorias() {
        try {
            List<ListarConvocatoriaResponseDto> convocatorias = convocatoriaApplicationService.listarConvocatorias();
            return ResponseEntity.ok(convocatorias);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

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