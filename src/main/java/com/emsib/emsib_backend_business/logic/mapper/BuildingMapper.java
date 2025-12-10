package com.emsib.emsib_backend_business.logic.mapper;

import com.emsib.emsib_backend_business.logic.dto.BuildingDto;
import com.emsib.emsib_backend_business.logic.entity.Building;

public class BuildingMapper {

    public static BuildingDto mapToBuildingDto(Building building) {
        return new BuildingDto(
                building.getId(),
                building.getName(),
                building.getStreet(),
                building.getNumber(),
                building.getCode(),
                building.getCity(),
                building.getFloors(),
                building.getDescription()
        );
    }

    public static Building mapToBuilding(BuildingDto buildingDto) {
        return new Building(
                buildingDto.getId(),
                buildingDto.getName(),
                buildingDto.getStreet(),
                buildingDto.getNumber(),
                buildingDto.getCode(),
                buildingDto.getCity(),
                buildingDto.getFloors(),
                buildingDto.getDescription()
        );
    }
}
