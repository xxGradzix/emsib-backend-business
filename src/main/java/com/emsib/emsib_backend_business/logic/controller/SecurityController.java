package com.emsib.emsib_backend_business.logic.controller;

import com.emsib.emsib_backend_business.mocksecurity.MockAuthResponse;
import com.emsib.emsib_backend_business.mocksecurity.MockCredentials;
import com.emsib.emsib_backend_business.mocksecurity.MockSecurityController;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/security")
public class SecurityController {
    private MockSecurityController m;

    @PostMapping("/login")
    public ResponseEntity<MockAuthResponse> login(@RequestBody MockCredentials MockCredentials) {
        return m.login(MockCredentials);
    }

    @PostMapping("/register")
    public ResponseEntity<MockAuthResponse> register(@RequestBody MockCredentials MockCredentials) {
        return m.register(MockCredentials);
    }
}
