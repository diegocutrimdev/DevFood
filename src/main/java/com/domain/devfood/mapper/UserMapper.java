package com.domain.devfood.mapper;

import com.domain.devfood.entity.User;
import com.domain.devfood.dto.RequestRegisterUser;
import com.domain.devfood.dto.ResponseRegisteredUser;

public class UserMapper {

    public static User toUser(RequestRegisterUser request) {
        return User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }

    public static ResponseRegisteredUser toResponseRegisteredUser(User user) {
        return ResponseRegisteredUser.builder()
                .name(user.getName())
                .build();
    }
}
