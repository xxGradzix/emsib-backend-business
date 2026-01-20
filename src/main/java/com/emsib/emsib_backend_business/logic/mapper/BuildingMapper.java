package com.emsib.emsib_backend_business.logic.mapper;

import com.emsib.emsib_backend_business.logic.dto.BuildingDto;
import com.emsib.emsib_backend_business.logic.entity.BuildingEnt;

public class BuildingMapper {

    public static BuildingDto mapToBuildingDto(BuildingEnt building) {
        return new BuildingDto(
                building.getBuildingId(),
                building.getName(),
                building.getStreet(),
                building.getStreetNum(),
                building.getPostalCode(),
                building.getCity(),
                building.getNumOfFloors(),
                building.getDescription()
        );
    }

    public static BuildingEnt mapToBuilding(BuildingDto buildingDto) {
        return new BuildingEnt(
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
