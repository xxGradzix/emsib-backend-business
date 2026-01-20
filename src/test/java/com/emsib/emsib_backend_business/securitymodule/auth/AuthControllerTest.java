package com.emsib.emsib_backend_business.securitymodule.auth;

import com.emsib.emsib_backend_business.security.securitymodule.auth.AuthController;
import com.emsib.emsib_backend_business.security.securitymodule.auth.AuthenticationService;
import com.emsib.emsib_backend_business.security.securitymodule.auth.dto.AuthResponse;
import com.emsib.emsib_backend_business.security.securitymodule.auth.dto.LoginRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class AuthControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AuthenticationService authService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        AuthController controller = new AuthController(authService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void login_returns200_and_tokenJson() throws Exception {

        LoginRequest req = new LoginRequest();
        req.setUsername("alice");
        req.setPassword("secret6");

        AuthResponse resp = new AuthResponse("jwt-123");
        when(authService.authenticate(any())).thenReturn(resp);

        mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").value("jwt-123"));

        verify(authService).authenticate(any());
    }
}
