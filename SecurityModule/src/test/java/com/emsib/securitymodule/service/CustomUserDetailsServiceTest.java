package com.emsib.securitymodule.service;

import com.emsib.securitymodule.user.Role;
import com.emsib.securitymodule.user.User;
import com.emsib.securitymodule.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomUserDetailsServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private CustomUserDetailsService userDetailsService;

    @Test
    void loadUserByUsername_returnsUserDetails_whenUserExists() {
        User user = new User();
        user.setUsername("charlie");
        user.setPassword("pw");

        user.setRoles(Set.of(Role.ROLE_USER));

        when(userRepository.findByUsername("charlie")).thenReturn(Optional.of(user));

        UserDetails ud = userDetailsService.loadUserByUsername("charlie");

        assertNotNull(ud);
        assertEquals("charlie", ud.getUsername());
        assertEquals("pw", ud.getPassword());
    }

    @Test
    void loadUserByUsername_throws_whenMissing() {
        when(userRepository.findByUsername("missing")).thenReturn(Optional.empty());
        assertThrows(UsernameNotFoundException.class,
                () -> userDetailsService.loadUserByUsername("missing"));
    }
}
