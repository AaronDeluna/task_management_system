package org.javaacademy.task_management_system.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.javaacademy.task_management_system.dto.CreateUserDto;
import org.javaacademy.task_management_system.dto.LoginUserDto;
import org.javaacademy.task_management_system.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<HttpStatus> login(@RequestBody LoginUserDto loginUserDto) {
        userService.login(loginUserDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity<HttpStatus> register(@RequestBody CreateUserDto createUserDto) {
        userService.register(createUserDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
