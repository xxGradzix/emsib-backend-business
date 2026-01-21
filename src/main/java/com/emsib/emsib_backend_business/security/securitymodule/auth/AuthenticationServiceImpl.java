package com.emsib.emsib_backend_business.security.securitymodule.auth;

import com.emsib.emsib_backend_business.security.securitymodule.auth.dto.AuthResponse;
import com.emsib.emsib_backend_business.security.securitymodule.auth.dto.LoginRequest;
import com.emsib.emsib_backend_business.security.securitymodule.auth.dto.RegisterRequest;
import com.emsib.emsib_backend_business.relational_database.UserEnt;
import com.emsib.emsib_backend_business.relational_database.UserEntRepository;
import com.emsib.emsib_backend_business.security.securitymodule.jwt.JwtProvider;
import com.emsib.emsib_backend_business.security.securitymodule.util.PasswordHashUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserEntRepository userEntRepository;
    private final JwtProvider jwtProvider;

    public AuthenticationServiceImpl(UserEntRepository userEntRepository,
                                     JwtProvider jwtProvider) {
        this.userEntRepository = userEntRepository;
        this.jwtProvider = jwtProvider;
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
        byte[] hash = PasswordHashUtil.hashPassword(request.getPassword().toCharArray(), salt);

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

        String token = jwtProvider.generateToken(user.name); // use name as token subject
        return new AuthResponse(token);
    }

    @Override
    public AuthResponse authenticate(LoginRequest request) {
        // Lookup user by name (username from DTO)
        UserEnt user = userEntRepository.findByName(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Invalid credentials"));

        boolean ok = PasswordHashUtil.verifyPassword(request.getPassword(), user.salt, user.passwordHash);
        if (!ok) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        String token = jwtProvider.generateToken(user.name); // consistent with register
        return new AuthResponse(token);
    }
}
