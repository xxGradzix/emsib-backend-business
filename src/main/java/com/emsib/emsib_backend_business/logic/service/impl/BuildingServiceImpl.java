package com.emsib.emsib_backend_business.logic.service.impl;

import com.emsib.emsib_backend_business.logic.dto.BuildingDto;
import com.emsib.relational_database.BuildingEnt;
import com.emsib.emsib_backend_business.logic.mapper.BuildingMapper;
import com.emsib.emsib_backend_business.logic.repository.BuildingRepository;
import com.emsib.emsib_backend_business.logic.service.BuildingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BuildingServiceImpl implements BuildingService {
    private BuildingRepository buildingRepository;

    @Override
    public BuildingDto createBuilding(BuildingDto buildingDto) {
        BuildingEnt building = BuildingMapper.mapToBuilding(buildingDto);
        BuildingEnt savedBuilding = buildingRepository.save(building);
        return  BuildingMapper.mapToBuildingDto(savedBuilding);
    }

    @Override
    public Optional<BuildingEnt> findById(Long id) {
        return buildingRepository.findById(id);
    }

    @Override
    public List<BuildingEnt> findAll() {
        return buildingRepository.findAll();
    }
}
