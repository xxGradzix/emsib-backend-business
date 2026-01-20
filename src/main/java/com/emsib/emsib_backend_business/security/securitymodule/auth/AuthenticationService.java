package com.emsib.emsib_backend_business.security.securitymodule.auth;

import com.emsib.emsib_backend_business.security.securitymodule.auth.dto.AuthResponse;
import com.emsib.emsib_backend_business.security.securitymodule.auth.dto.LoginRequest;
import com.emsib.emsib_backend_business.security.securitymodule.auth.dto.RegisterRequest;

public interface AuthenticationService {
    AuthResponse register(RegisterRequest request);
    AuthResponse authenticate(LoginRequest request);
}
