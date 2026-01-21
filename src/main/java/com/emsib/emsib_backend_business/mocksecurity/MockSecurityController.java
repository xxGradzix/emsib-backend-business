package com.emsib.emsib_backend_business.mocksecurity;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/mock/security")
public class MockSecurityController {
    @GetMapping("/login")
    public ResponseEntity<MockAuthResponse> login(@RequestBody MockCredentials MockCredentials) {
        MockAuthResponse m = new MockAuthResponse();
        return ResponseEntity.ok(m);
    }

    @GetMapping("/register")
    public ResponseEntity<MockAuthResponse> register(@RequestBody MockCredentials MockCredentials) {
        MockAuthResponse m = new MockAuthResponse();
        return ResponseEntity.ok(m);
    }
}
