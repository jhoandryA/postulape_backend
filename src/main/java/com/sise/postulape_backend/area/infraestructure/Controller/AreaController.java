package com.sise.postulape_backend.area.infraestructure.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sise.postulape_backend.area.application.dto.request.ActualizarAreaRequestDto;
import com.sise.postulape_backend.area.application.dto.request.InsertarAreaRequestDto;
import com.sise.postulape_backend.area.application.dto.response.ActualizarAreaResponseDto;
import com.sise.postulape_backend.area.application.dto.response.EliminarAreaResponseDto;
import com.sise.postulape_backend.area.application.dto.response.InsertarAreaResponseDto;
import com.sise.postulape_backend.area.application.dto.response.ListarAreaResponseDto;
import com.sise.postulape_backend.area.application.service.AreaApplicationService;

import java.util.List;

@RestController
@RequestMapping("/areas")
public class AreaController {

    
    @Autowired
    private AreaApplicationService areaApplicationService;

    @PostMapping("")
    public ResponseEntity<InsertarAreaResponseDto> insertarArea(
            @RequestBody InsertarAreaRequestDto requestDto) {
        try {
            InsertarAreaResponseDto responseDto = areaApplicationService.insertarArea(requestDto);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<ListarAreaResponseDto>> listarAreas() {
        try {
            List<ListarAreaResponseDto> areas = areaApplicationService.listarAreas();
            return ResponseEntity.ok(areas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActualizarAreaResponseDto> actualizarArea(
            @PathVariable Integer id,
            @RequestBody ActualizarAreaRequestDto requestDto) {
        try {
            ActualizarAreaResponseDto responseDto = areaApplicationService.actualizarArea(id, requestDto);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EliminarAreaResponseDto> eliminarArea(
            @PathVariable Integer id) {
        try {
            EliminarAreaResponseDto responseDto = areaApplicationService.eliminarArea(id);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}