package com.emsib.emsib_backend_business.security.securitymodule.service;

import com.emsib.emsib_backend_business.relational_database.UserEnt;
import com.emsib.emsib_backend_business.relational_database.UserEntRepository;
import com.emsib.emsib_backend_business.relational_database.UserBuildingEntRepository;
import com.emsib.emsib_backend_business.relational_database.UserBuildingEnt;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserEntRepository userRepo;
    private final UserBuildingEntRepository userBuildingRepo;

    public CustomUserDetailsService(UserEntRepository userRepo,
                                    UserBuildingEntRepository userBuildingRepo) {
        this.userRepo = userRepo;
        this.userBuildingRepo = userBuildingRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        UserEnt u = userRepo.findByEmail(usernameOrEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + usernameOrEmail));


        List<UserBuildingEnt> ubRows = userBuildingRepo.findByUserId(u.userId);
        Set<SimpleGrantedAuthority> authorities = ubRows.stream()
                .map(ub -> {
                    if (ub.role != null && ub.role.name != null && !ub.role.name.isBlank()) {
                        String roleName = ub.role.name.trim();
                        // ensure it is a ROLE_ prefixed authority: if DB stores like "ADMIN", convert->"ROLE_ADMIN"
                        if (!roleName.startsWith("ROLE_")) {
                            roleName = "ROLE_" + roleName;
                        }
                        return new SimpleGrantedAuthority(roleName);
                    } else {
                        return new SimpleGrantedAuthority("ROLE_USER");
                    }
                })
                .collect(Collectors.toSet());

        if (authorities.isEmpty()) {
            authorities = Set.of(new SimpleGrantedAuthority("ROLE_USER"));
        }


        return org.springframework.security.core.userdetails.User.builder()
                .username(u.email)
                .password("{noop}")
                .authorities(authorities)
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
