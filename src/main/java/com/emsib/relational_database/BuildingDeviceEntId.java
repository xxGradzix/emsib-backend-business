package com.emsib.relational_database;

import java.io.Serializable;
import java.util.Objects;

public class BuildingDeviceEntId implements Serializable {

    public Integer buildingId;
    public Integer deviceId;

    public BuildingDeviceEntId() {
    }

    public BuildingDeviceEntId(Integer buildingId, Integer deviceId) {
        this.buildingId = buildingId;
        this.deviceId = deviceId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BuildingDeviceEntId that = (BuildingDeviceEntId) o;
        return Objects.equals(buildingId, that.buildingId) && Objects.equals(deviceId, that.deviceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buildingId, deviceId);
    }
}
