package com.emsib.emsib_backend_business.relational_database;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UbRoleEntRepository extends JpaRepository<UbRoleEnt, Integer> {
    Optional<UbRoleEnt> findByName(String name);
}
