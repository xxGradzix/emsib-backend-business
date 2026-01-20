package com.emsib.emsib_backend_business.relational_database;

import java.io.Serializable;
import java.util.Objects;

public class PropertyDeviceEntId implements Serializable {

    public Integer propertyId;
    public Integer deviceId;

    public PropertyDeviceEntId() {
    }

    public PropertyDeviceEntId(Integer propertyId, Integer deviceId) {
        this.propertyId = propertyId;
        this.deviceId = deviceId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PropertyDeviceEntId that = (PropertyDeviceEntId) o;
        return Objects.equals(propertyId, that.propertyId) && Objects.equals(deviceId, that.deviceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propertyId, deviceId);
    }
}
