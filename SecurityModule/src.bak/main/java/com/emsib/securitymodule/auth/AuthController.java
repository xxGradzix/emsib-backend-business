package com.emsib.securitymodule.auth;

import com.emsib.securitymodule.auth.dto.AuthResponse;
import com.emsib.securitymodule.auth.dto.LoginRequest;
import com.emsib.securitymodule.auth.dto.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping(\"/api/auth\")
public class AuthController {

    private final AuthenticationService authService;

    public AuthController(AuthenticationService authService) {
        this.authService = authService;
    }

    @PostMapping(\"/register\")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest req) {
        AuthResponse response = authService.register(req);
        return ResponseEntity.ok(response);
    }

    @PostMapping(\"/login\")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest req) {
        AuthResponse response = authService.authenticate(req);
        return ResponseEntity.ok(response);
    }
}
