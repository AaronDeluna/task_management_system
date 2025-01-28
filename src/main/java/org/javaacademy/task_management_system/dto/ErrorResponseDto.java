package org.javaacademy.task_management_system.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorResponseDto {
    private int code;
    private String status;
    private String message;
    private LocalDateTime dateTime;
}
