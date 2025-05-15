package com.domain.devfood.Service.impl;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import com.domain.devfood.entity.User;
import org.springframework.stereotype.Service;
import com.domain.devfood.Service.UserService;
import com.domain.devfood.repository.UserRepository;
import com.domain.devfood.exception.InvalidUserDataException;
import com.domain.devfood.exception.EmailAlreadyExistsException;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public User registerUser(User user) {

        validateUser(user);

        if (userRepository.existsByEmail(user.getEmail())) {
            log.warn("Email já cadastrado: {}", user.getEmail());
            throw new EmailAlreadyExistsException("Email already exists");
        }
        log.info("Registrando novo usuário: {}", user.getEmail());
        return userRepository.save(user);
    }


    private void validateUser(User user) {

        if (user.getName() == null || user.getName().isBlank())
            throw new InvalidUserDataException("Nome is required.");

        if (user.getEmail() == null || user.getEmail().isBlank())
            throw new InvalidUserDataException("Email is required.");

        if (!user.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))
            throw new InvalidUserDataException("Invalid email format.");

        if (user.getPassword() == null || user.getPassword().length() < 6)
            throw new InvalidUserDataException("Password must have at least 6 characters.");
    }
}
