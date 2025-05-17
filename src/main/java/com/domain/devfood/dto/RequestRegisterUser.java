package com.domain.devfood.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestRegisterUser {
    private String name;
    private String email;
    private String password;
}
