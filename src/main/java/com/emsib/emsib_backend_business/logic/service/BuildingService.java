package com.emsib.emsib_backend_business.logic.service;

import com.emsib.emsib_backend_business.logic.dto.BuildingDto;
import com.emsib.emsib_backend_business.logic.entity.Building;

import java.util.List;
import java.util.Optional;

public interface BuildingService {
    BuildingDto createBuilding(BuildingDto buildingDto);
    Optional<Building> findById(Long id);
    List<Building> findAll();
}
