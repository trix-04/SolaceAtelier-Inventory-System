package com.SolaceAtelier.inventory_system.config;

import com.SolaceAtelier.inventory_system.models.Role;
import com.SolaceAtelier.inventory_system.repositories.UserRepository;
import com.SolaceAtelier.inventory_system.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initUsers(UserRepository userRepo, UserService userService) {
        return args -> {
            if (!userRepo.existsByUsername("admin")) {
                userService.createUser("admin", "admin123", Role.ADMIN);
            }

            if (!userRepo.existsByUsername("staff")) {
                userService.createUser("staff", "staff123", Role.STAFF);
            }

            if (!userRepo.existsByUsername("customer")) {
                userService.createUser("customer", "customer123", Role.CUSTOMER);
            }
        };
    }
}