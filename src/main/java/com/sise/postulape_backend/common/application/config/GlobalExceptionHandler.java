package com.sise.postulape_backend.common.application.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sise.postulape_backend.common.application.dto.response.BaseResponseDto;
import com.sise.postulape_backend.common.domain.exception.BusinessException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponseDto> handleValidationException(MethodArgumentNotValidException ex) {
        
        List<String> errors = ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .collect(Collectors.groupingBy(error -> error.getField(),
                     Collectors.mapping(error -> error.getDefaultMessage(), Collectors.toList())))
            .values()
            .stream()
            .map(list -> list.get(0)) 
            .collect(Collectors.toList());

        return ResponseEntity.badRequest().body(
            BaseResponseDto.error("Error de validación", errors)
        );
    }

        @ExceptionHandler(BusinessException.class)
    public ResponseEntity<BaseResponseDto> handleBusinessException(BusinessException ex) {
        return ResponseEntity.badRequest().body(
            BaseResponseDto.error(ex.getMessage(), null)
        );
    }
}
