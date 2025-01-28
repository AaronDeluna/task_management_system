package org.javaacademy.task_management_system.mapper;

import org.javaacademy.task_management_system.dto.CreateUserDto;
import org.javaacademy.task_management_system.dto.UserDto;
import org.javaacademy.task_management_system.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(CreateUserDto dto) {
        return new User(
                dto.getUsername(),
                dto.getEmail(),
                dto.getPassword()
        );
    }

    public UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
