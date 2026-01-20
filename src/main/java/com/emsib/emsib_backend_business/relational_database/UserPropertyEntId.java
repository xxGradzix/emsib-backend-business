package com.emsib.emsib_backend_business.relational_database;

import java.io.Serializable;
import java.util.Objects;

public class UserPropertyEntId implements Serializable {

    public Integer userId;
    public Integer propertyId;

    public UserPropertyEntId() {
    }

    public UserPropertyEntId(Integer userId, Integer propertyId) {
        this.userId = userId;
        this.propertyId = propertyId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserPropertyEntId that = (UserPropertyEntId) o;
        return Objects.equals(userId, that.userId) && Objects.equals(propertyId, that.propertyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, propertyId);
    }
}
