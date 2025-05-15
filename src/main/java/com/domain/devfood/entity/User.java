package com.domain.devfood.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import jakarta.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "TB_USER")
public class User extends EntityBase {
    private String name;
    private String email;
    private String password;
}
