package com.emsib.emsib_backend_business.relational_database;

import java.io.Serializable;
import java.util.Objects;

public class UserBuildingEntId implements Serializable {

    public Integer userId;
    public Integer buildingId;

    public UserBuildingEntId() {}

    public UserBuildingEntId(Integer userId, Integer buildingId) {
        this.userId = userId;
        this.buildingId = buildingId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserBuildingEntId that = (UserBuildingEntId) o;
        return Objects.equals(userId, that.userId) && Objects.equals(buildingId, that.buildingId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, buildingId);
    }
}
