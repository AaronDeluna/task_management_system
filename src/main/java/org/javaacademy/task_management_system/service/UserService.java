package org.javaacademy.task_management_system.service;

import lombok.RequiredArgsConstructor;
import org.javaacademy.task_management_system.dto.CreateUserDto;
import org.javaacademy.task_management_system.dto.LoginUserDto;
import org.javaacademy.task_management_system.dto.UserDto;
import org.javaacademy.task_management_system.exception.NotFoundException;
import org.javaacademy.task_management_system.mapper.UserMapper;
import org.javaacademy.task_management_system.repository.UserRepository;
import org.javaacademy.task_management_system.validation.UserAuthValidationUtil;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private static final String EMAIL_NOT_FOUND_MESSAGE = "email: %s не найден";
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public void register(CreateUserDto createUserDto) {
        userRepository.save(userMapper.toEntity(createUserDto));
    }

    public void login(LoginUserDto loginUserDto) {
        UserDto userDto = userMapper.toDto(userRepository.findByEmail(loginUserDto.getEmail())
                .orElseThrow(() -> new NotFoundException(EMAIL_NOT_FOUND_MESSAGE))
        );
        UserAuthValidationUtil.logoutValidation(loginUserDto, userDto);
    }
}
