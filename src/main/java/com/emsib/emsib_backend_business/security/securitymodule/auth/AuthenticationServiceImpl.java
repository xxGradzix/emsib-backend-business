package com.emsib.emsib_backend_business.security.securitymodule.auth;

import com.emsib.emsib_backend_business.relational_database.UserEnt;
import com.emsib.emsib_backend_business.relational_database.UserEntRepository;
import com.emsib.emsib_backend_business.security.securitymodule.auth.dto.AuthResponse;
import com.emsib.emsib_backend_business.security.securitymodule.auth.dto.LoginRequest;
import com.emsib.emsib_backend_business.security.securitymodule.auth.dto.RegisterRequest;
import com.emsib.emsib_backend_business.security.securitymodule.jwt.JwtProvider;
import com.emsib.emsib_backend_business.security.securitymodule.logging.SimpleAuthLogger;
import com.emsib.emsib_backend_business.security.securitymodule.util.PasswordHashUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserEntRepository userEntRepository;
    private final JwtProvider jwtProvider;
    private final SimpleAuthLogger authLogger;

    public AuthenticationServiceImpl(
            UserEntRepository userEntRepository,
            JwtProvider jwtProvider,
            SimpleAuthLogger authLogger
    ) {
        this.userEntRepository = userEntRepository;
        this.jwtProvider = jwtProvider;
        this.authLogger = authLogger;
    }

    @Override
    @Transactional
    public AuthResponse register(RegisterRequest request) {
        // Check unique username & email
        if (userEntRepository.existsByName(request.getUsername())) {
            throw new IllegalArgumentException("Username already in use");
        }
        if (userEntRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already in use");
        }

        // Create salt + hash
        byte[] salt = PasswordHashUtil.generateSalt(16);
        byte[] hash = PasswordHashUtil.hashPassword(
                request.getPassword().toCharArray(),
                salt
        );

        // Map DTO -> entity
        UserEnt user = new UserEnt();
        user.name = request.getUsername();
        user.surname = null;
        user.email = request.getEmail();
        user.phone = ""; // placeholder
        user.nip = null;
        user.passwordHash = hash;
        user.salt = salt;

        userEntRepository.save(user);

        String token = jwtProvider.generateToken(user.name); // unchanged behavior
        return new AuthResponse(token);
    }

    @Override
    public AuthResponse authenticate(LoginRequest request) {

        authLogger.loginAttempt(request.getUsername());

        UserEnt user = userEntRepository.findByName(request.getUsername())
                .orElseThrow(() -> {
                    authLogger.loginFailure(request.getUsername());
                    return new IllegalArgumentException("Invalid credentials");
                });

        boolean ok = PasswordHashUtil.verifyPassword(
                request.getPassword(),
                user.salt,
                user.passwordHash
        );

        if (!ok) {
            authLogger.loginFailure(request.getUsername());
            throw new IllegalArgumentException("Invalid credentials");
        }

        authLogger.loginSuccess(request.getUsername());

        String token = jwtProvider.generateToken(user.name); // unchanged behavior
        return new AuthResponse(token);
    }
}
