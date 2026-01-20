package com.emsib.emsib_backend_business.relational_database;

import jakarta.persistence.*;

@Entity
@Table(name = "property_device")
@IdClass(PropertyDeviceEntId.class)
public class PropertyDeviceEnt {

    @Id
    @Column(name = "property_id", nullable = false)
    public Integer propertyId;

    @Id
    @Column(name = "device_id", nullable = false)
    public Integer deviceId;

    //fks
    @ManyToOne
    @JoinColumn(name = "property_id", insertable = false, updatable = false)
    public PropertyEnt property;

    @ManyToOne
    @JoinColumn(name = "device_id", insertable = false, updatable = false)
    public DeviceEnt device;

    @Override
    public String toString() {
        return "PropertyDeviceEnt{" +
                "propertyId=" + propertyId +
                ", deviceId=" + deviceId +
                '}';
    }
}
