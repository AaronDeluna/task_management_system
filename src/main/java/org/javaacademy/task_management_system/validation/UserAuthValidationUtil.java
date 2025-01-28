package org.javaacademy.task_management_system.validation;

import lombok.experimental.UtilityClass;
import org.javaacademy.task_management_system.dto.LoginUserDto;
import org.javaacademy.task_management_system.dto.UserDto;
import org.javaacademy.task_management_system.exception.LoginFailedException;

@UtilityClass
public class UserAuthValidationUtil {
    private static final String EMAIL_NOT_CORRECT_MESSAGE = "Не верный email: %s";
    private static final String PASSWORD_NOT_CORRECT_MESSAGE = "Не верный email: %s";

    public void logoutValidation(LoginUserDto loginUserDto, UserDto userDto) {
        if (!userDto.getEmail().equals(loginUserDto.getEmail())) {
            throw new LoginFailedException(EMAIL_NOT_CORRECT_MESSAGE.formatted(loginUserDto.getEmail()));
        }

        if (!userDto.getPassword().equals(loginUserDto.getPassword())) {
            throw new LoginFailedException(PASSWORD_NOT_CORRECT_MESSAGE.formatted(loginUserDto.getPassword()));
        }
    }
}
