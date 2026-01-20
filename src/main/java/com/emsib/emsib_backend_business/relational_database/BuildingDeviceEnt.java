package com.emsib.emsib_backend_business.relational_database;

import jakarta.persistence.*;

@Entity
@Table(name = "building_device")
@IdClass(BuildingDeviceEntId.class)
public class BuildingDeviceEnt {

    @Id
    @Column(name = "building_id", nullable = false)
    public Integer buildingId;

    @Id
    @Column(name = "device_id", nullable = false)
    public Integer deviceId;

    //fks
    @ManyToOne
    @JoinColumn(name = "building_id", insertable = false, updatable = false)
    public BuildingEnt building;

    @ManyToOne
    @JoinColumn(name = "device_id", insertable = false, updatable = false)
    public DeviceEnt device;

    @Override
    public String toString() {
        return "BuildingDeviceEnt{" +
                "buildingId=" + buildingId +
                ", deviceId=" + deviceId +
                '}';
    }
}
