package com.SolaceAtelier.inventory_system.services;

import com.SolaceAtelier.inventory_system.models.Role;
import com.SolaceAtelier.inventory_system.models.User;
import com.SolaceAtelier.inventory_system.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createUser(String username, String password, Role role) {
        User user = new User(username, passwordEncoder.encode(password), role);
        userRepository.save(user);
    }

    public boolean usernameExists(String username) {
        return userRepository.existsByUsername(username);
    }

    public void registerCustomer(String username, String password) {
        createUser(username, password, Role.CUSTOMER);
    }
}