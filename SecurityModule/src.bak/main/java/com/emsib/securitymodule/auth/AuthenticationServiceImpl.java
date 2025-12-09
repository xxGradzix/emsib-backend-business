package com.emsib.securitymodule.auth;

import com.emsib.securitymodule.auth.dto.AuthResponse;
import com.emsib.securitymodule.auth.dto.LoginRequest;
import com.emsib.securitymodule.auth.dto.RegisterRequest;
import com.emsib.securitymodule.jwt.JwtProvider;
import com.emsib.securitymodule.user.Role;
import com.emsib.securitymodule.user.User;
import com.emsib.securitymodule.user.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public AuthenticationServiceImpl(UserRepository userRepository,
                                     PasswordEncoder passwordEncoder,
                                     JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new IllegalArgumentException(\"Username already in use\");
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException(\"Email already in use\");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRoles(Set.of(Role.ROLE_USER));
        userRepository.save(user);

        String token = jwtProvider.generateToken(user.getUsername());
        return new AuthResponse(token);
    }

    @Override
    public AuthResponse authenticate(LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException(\"Invalid credentials\"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException(\"Invalid credentials\");
        }

        String token = jwtProvider.generateToken(user.getUsername());
        return new AuthResponse(token);
    }
}
