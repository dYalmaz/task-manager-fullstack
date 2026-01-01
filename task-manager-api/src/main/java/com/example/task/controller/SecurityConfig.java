package com.example.task.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for the API
                .cors(Customizer.withDefaults()) // Enable CORS using my @CrossOrigin settings
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // Allow everyone to access my API for now
                );

        return http.build();
    }
}