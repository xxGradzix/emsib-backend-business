package com.emsib.emsib_backend_business.logic.repository;

import com.emsib.emsib_backend_business.relational_database.BuildingEnt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BuildingRepository extends JpaRepository<BuildingEnt, Long> {
    Optional<BuildingEnt> findById(Long id);
    List<BuildingEnt> findAll();
}
