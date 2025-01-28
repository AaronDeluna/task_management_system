package org.javaacademy.task_management_system.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginUserDto {
    private String email;
    private String password;
}
