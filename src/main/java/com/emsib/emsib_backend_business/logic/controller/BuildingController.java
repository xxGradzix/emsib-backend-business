package com.emsib.emsib_backend_business.logic.controller;


import com.emsib.emsib_backend_business.logic.dto.BuildingDto;
import com.emsib.relational_database.BuildingEnt;
import com.emsib.emsib_backend_business.logic.mapper.BuildingMapper;
import com.emsib.emsib_backend_business.logic.service.BuildingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/buildings")
public class BuildingController {
    private final BuildingService buildingService;
    
    @PostMapping("/add")
    public ResponseEntity<BuildingDto> createBuilding(@RequestBody BuildingDto BuildingDto){
        BuildingDto savedBuilding =  buildingService.createBuilding(BuildingDto);
        return ResponseEntity.ok(savedBuilding);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<BuildingDto> getBuildingById(@PathVariable Long id) {
        BuildingEnt building = buildingService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(BuildingMapper.mapToBuildingDto(building));
    }

    @GetMapping("/get/all")
    public List<BuildingDto> getUserAll() {
        List<BuildingEnt> buildings = buildingService.findAll();
        List<BuildingDto> buildingsDto = new ArrayList<>();
        for (BuildingEnt b : buildings) {
            buildingsDto.add(BuildingMapper.mapToBuildingDto(b));
        }
        return buildingsDto;
    }
}
