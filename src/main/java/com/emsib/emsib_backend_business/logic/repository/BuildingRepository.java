package com.emsib.emsib_backend_business.logic.repository;

import com.emsib.emsib_backend_business.logic.entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BuildingRepository extends JpaRepository<Building, Long> {
    Optional<Building> findById(Long id);
    List<Building> findAll();
}
