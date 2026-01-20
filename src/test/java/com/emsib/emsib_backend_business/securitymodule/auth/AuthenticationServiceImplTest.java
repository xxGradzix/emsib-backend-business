package com.emsib.emsib_backend_business.securitymodule.auth;

import com.emsib.emsib_backend_business.security.securitymodule.auth.AuthenticationServiceImpl;
import com.emsib.emsib_backend_business.security.securitymodule.auth.dto.AuthResponse;
import com.emsib.emsib_backend_business.security.securitymodule.auth.dto.LoginRequest;
import com.emsib.emsib_backend_business.security.securitymodule.auth.dto.RegisterRequest;
import com.emsib.emsib_backend_business.security.securitymodule.user.User;
import com.emsib.emsib_backend_business.security.securitymodule.user.UserRepository;
import com.emsib.emsib_backend_business.security.securitymodule.jwt.JwtProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthenticationServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtProvider jwtProvider;

    @InjectMocks
    private AuthenticationServiceImpl authService;

    @Test
    void authenticate_returnsToken_whenCredentialsValid() {
        LoginRequest req = new LoginRequest();
        req.setUsername("alice");
        req.setPassword("plainPass");

        User user = new User();
        user.setUsername("alice");
        user.setPassword("encodedPass");

        when(userRepository.findByUsername("alice")).thenReturn(Optional.of(user));
        when(passwordEncoder.matches("plainPass", "encodedPass")).thenReturn(true);
        when(jwtProvider.generateToken(ArgumentMatchers.any())).thenReturn("token-xyz");

        AuthResponse resp = authService.authenticate(req);

        assertNotNull(resp);
        assertEquals("token-xyz", resp.getToken());

        verify(userRepository).findByUsername("alice");
        verify(jwtProvider).generateToken(ArgumentMatchers.any());
    }

    @Test
    void register_createsUser_and_returnsToken() {
        RegisterRequest rr = new RegisterRequest();
        rr.setUsername("bob");
        rr.setEmail("bob@example.com");
        rr.setPassword("secret123");

        when(userRepository.existsByUsername("bob")).thenReturn(false);
        when(passwordEncoder.encode("secret123")).thenReturn("encodedSecret");
        when(jwtProvider.generateToken(ArgumentMatchers.any())).thenReturn("reg-token");


        when(userRepository.save(ArgumentMatchers.any(User.class)))
                .thenAnswer(inv -> {
                    User u = inv.getArgument(0, User.class);
                    u.setId(123L);
                    return u;
                });

        AuthResponse resp = authService.register(rr);

        assertNotNull(resp);
        assertEquals("reg-token", resp.getToken());

        verify(userRepository).save(ArgumentMatchers.any(User.class));
    }
}
