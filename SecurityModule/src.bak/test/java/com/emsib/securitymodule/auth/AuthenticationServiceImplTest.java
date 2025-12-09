package com.emsib.securitymodule.auth;

import com.emsib.securitymodule.user.User;
import com.emsib.securitymodule.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthenticationServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private com.emsib.securitymodule.jwt.JwtProvider jwtProvider;

    @InjectMocks
    private AuthenticationServiceImpl authService;

    @BeforeEach
    void setup() {
        // MockitoAnnotations.openMocks(this); // not necessary with @ExtendWith
    }

    @Test
    void register_success_returnsToken() {
        // arrange
        String username = "bob";
        String email = "bob@example.com";
        String rawPwd = "secret";
        String encoded = "encoded-secret";
        String expectedToken = "jwt-token";

        when(userRepository.existsByUsername(username)).thenReturn(false);
        when(userRepository.existsByEmail(email)).thenReturn(false);
        when(passwordEncoder.encode(rawPwd)).thenReturn(encoded);
        // simulate save: return the user back with an id
        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
        when(userRepository.save(captor.capture())).thenAnswer(invocation -> {
            User u = invocation.getArgument(0);
            u.setId(1L);
            return u;
        });
        when(jwtProvider.generateToken(username)).thenReturn(expectedToken);

        var req = new RegisterRequest();
        req.setUsername(username);
        req.setEmail(email);
        req.setPassword(rawPwd);

        // act
        var resp = authService.register(req);

        // assert
        assertNotNull(resp);
        assertEquals(expectedToken, resp.getToken());

        User saved = captor.getValue();
        assertEquals(username, saved.getUsername());
        assertEquals(email, saved.getEmail());
        assertEquals(encoded, saved.getPassword());
        assertNotNull(saved.getRoles());
        verify(userRepository).save(any(User.class));
    }

    @Test
    void register_duplicateUsername_throws() {
        when(userRepository.existsByUsername("joe")).thenReturn(true);

        var req = new RegisterRequest();
        req.setUsername("joe");
        req.setEmail("j@e.com");
        req.setPassword("pwd");

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> authService.register(req));
        assertTrue(ex.getMessage().toLowerCase().contains("username"));
    }

    @Test
    void authenticate_success_returnsToken() {
        String username = "alice";
        String rawPwd = "topsecret";
        String hashed = "hashed-pwd";
        String expectedToken = "jwt-123";

        User user = new User();
        user.setId(1L);
        user.setUsername(username);
        user.setPassword(hashed);
        user.setRoles(Set.of(com.emsib.securitymodule.user.Role.ROLE_USER));

        when(userRepository.findByUsername(username)).thenReturn(Optional.of(user));
        when(passwordEncoder.matches(rawPwd, hashed)).thenReturn(true);
        when(jwtProvider.generateToken(username)).thenReturn(expectedToken);

        var req = new LoginRequest();
        req.setUsername(username);
        req.setPassword(rawPwd);

        var resp = authService.authenticate(req);

        assertNotNull(resp);
        assertEquals(expectedToken, resp.getToken());
    }

    @Test
    void authenticate_invalidUser_throws() {
        when(userRepository.findByUsername("nope")).thenReturn(Optional.empty());

        var req = new LoginRequest();
        req.setUsername("nope");
        req.setPassword("x");

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> authService.authenticate(req));
        assertTrue(ex.getMessage().toLowerCase().contains("invalid"));
    }
}
