package com.emsib.relational_database;

import jakarta.persistence.*;

@Entity
@Table(name = "device_status")
public class DeviceStatusEnt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "device_status_id")
    public Integer deviceStatusId;

    @Column(name = "name_", length = 20, nullable = false)
    public String name;

    @Override
    public String toString() {
        return "DeviceStatusEnt{" +
                "deviceStatusId=" + deviceStatusId +
                ", name='" + name + '\'' +
                '}';
    }
}
