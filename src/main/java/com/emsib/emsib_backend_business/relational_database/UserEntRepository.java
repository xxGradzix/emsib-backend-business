package com.emsib.emsib_backend_business.relational_database;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserEntRepository extends JpaRepository<UserEnt, Integer> {
    Optional<UserEnt> findByName(String name);
    Optional<UserEnt> findByEmail(String email);
    boolean existsByName(String name);
    boolean existsByEmail(String email);
}
