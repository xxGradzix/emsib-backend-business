package com.emsib.securitymodule.auth;

import com.emsib.securitymodule.auth.dto.AuthResponse;
import com.emsib.securitymodule.auth.dto.LoginRequest;
import com.emsib.securitymodule.auth.dto.RegisterRequest;

public interface AuthenticationService {
    AuthResponse register(RegisterRequest request);
    AuthResponse authenticate(LoginRequest request);
}
