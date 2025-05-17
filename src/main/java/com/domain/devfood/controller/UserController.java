package com.domain.devfood.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import com.domain.devfood.mapper.UserMapper;
import com.domain.devfood.Service.UserService;
import org.springframework.http.ResponseEntity;
import com.domain.devfood.dto.RequestRegisterUser;
import com.domain.devfood.dto.ResponseRegisteredUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<ResponseRegisteredUser> register(@RequestBody RequestRegisterUser request) {
        var encryptedPassword = passwordEncoder.encode(request.getPassword());
        request.setPassword(encryptedPassword);

        var registeredUser = userService.registerUser(UserMapper.toUser(request));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(UserMapper.toResponseRegisteredUser(registeredUser));
    }
}
