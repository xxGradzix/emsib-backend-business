package com.emsib.relational_database;

import com.emsib.relational_database.DeviceStatusEnt;
import jakarta.persistence.*;

@Entity
@Table(name = "device")
public class DeviceEnt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "device_id")
    public Integer deviceId;

    @Column(name = "manufacturer", length = 40, nullable = false)
    public String manufacturer;

    @Column(name = "model", length = 40, nullable = false)
    public String model;

    @Column(name = "description_", length = 200)
    public String description;

    @Column(name = "is_private", nullable = false)
    public Boolean isPrivate;

    @Column(name = "device_status_id", nullable = false)
    public Integer deviceStatusId;

    @Column(name = "current_power_target", nullable = false)
    public Float currentPowerTarget;

    @Column(name = "max_power_consumption", nullable = false)
    public Float maxPowerConsumption;

    //fks
    @ManyToOne
    @JoinColumn(name = "device_status_id", insertable = false, updatable = false)
    public DeviceStatusEnt deviceStatus;

    @Override
    public String toString() {
        return "DeviceEnt{" +
                "deviceId=" + deviceId +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", description='" + description + '\'' +
                ", isPrivate=" + isPrivate +
                ", deviceStatusId=" + deviceStatusId +
                ", currentPowerTarget=" + currentPowerTarget +
                ", maxPowerConsumption=" + maxPowerConsumption +
                '}';
    }
}
