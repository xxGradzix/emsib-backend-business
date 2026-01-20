package com.emsib.emsib_backend_business;

import com.emsib.emsib_backend_business.security.securitymodule.auth.AuthenticationService;
import com.emsib.emsib_backend_business.security.securitymodule.auth.dto.AuthResponse;
import com.emsib.emsib_backend_business.security.securitymodule.auth.dto.LoginRequest;
import com.emsib.emsib_backend_business.security.securitymodule.auth.dto.RegisterRequest;
import com.emsib.emsib_backend_business.relational_database.UserEntRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthenticationServiceIntegrationTest {

    @Autowired
    private AuthenticationService authService;

    @Autowired
    private UserEntRepository userEntRepository;

    @AfterEach
    void cleanup() {
        userEntRepository.deleteAll(); // clean test DB
    }

    @Test
    void testRegisterAndAuthenticate() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("testuser");
        registerRequest.setEmail("testuser@example.com");
        registerRequest.setPassword("password123");

        AuthResponse registerResponse = authService.register(registerRequest);

        assertNotNull(registerResponse);
        assertNotNull(registerResponse.getToken());
        assertTrue(userEntRepository.existsByEmail("testuser@example.com"));

        // Authenticate
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("testuser");
        loginRequest.setPassword("password123");

        AuthResponse authResponse = authService.authenticate(loginRequest);
        assertNotNull(authResponse);
        assertNotNull(authResponse.getToken());
    }
}
