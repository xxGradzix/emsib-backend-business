package com.emsib.emsib_backend_business.security.securitymodule.service;

import com.emsib.emsib_backend_business.relational_database.UserEnt;
import com.emsib.emsib_backend_business.relational_database.UserEntRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserEntRepository userEntRepository;

    public CustomUserDetailsService(UserEntRepository userEntRepository) {
        this.userEntRepository = userEntRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEnt u = userEntRepository.findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return User.builder()
                .username(u.name)
                .password("") // blank since we handle hash+salt manually
                .authorities(new String[0])
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
