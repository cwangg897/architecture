package com.example.hexa.common.controller;

import com.example.hexa.common.controller.response.ApiResponse;
import com.example.hexa.common.domain.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleResourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request){
        log.info("Http Method : {},  URI : {}, msg : {}", request.getMethod(), request.getRequestURI(),
            ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.of(HttpStatus.NOT_FOUND, ex.getMessage()));
    }
}
