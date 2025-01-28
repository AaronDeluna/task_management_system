package org.javaacademy.task_management_system.controller;

import org.javaacademy.task_management_system.dto.ErrorResponseDto;
import org.javaacademy.task_management_system.exception.LoginFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
            DuplicateKeyException.class,
    })
    public ResponseEntity<ErrorResponseDto> handleAuthException(RuntimeException e) {
        return buildResponse(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler({
            LoginFailedException.class,
    })
    public ResponseEntity<ErrorResponseDto> handleLoginException(RuntimeException e) {
        return buildResponse(HttpStatus.UNAUTHORIZED, e.getMessage());
    }

    private ResponseEntity<ErrorResponseDto> buildResponse(HttpStatus status, String message) {
        return ResponseEntity
                .status(status)
                .body(ErrorResponseDto.builder()
                        .code(status.value())
                        .status(status.name())
                        .message(message)
                        .build());
    }
}
