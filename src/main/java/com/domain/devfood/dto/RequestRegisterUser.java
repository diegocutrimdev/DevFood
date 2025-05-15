package com.domain.devfood.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestRegisterUser {
    private String name;
    private String email;
    private String password;
}
