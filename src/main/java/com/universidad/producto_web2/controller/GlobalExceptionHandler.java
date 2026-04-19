package com.universidad.producto_web2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public
    ResponseEntity<Map<String,
            String>>
    handleRuntime(RuntimeException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", ex.getMessage()));
    }
}
// Ahora al llamar GET /api/productos/999 se recibe:
// 404 Not Found
// { "error": "Producto no encontrado: 999" }
