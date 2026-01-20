package com.emsib.emsib_backend_business.relational_database;

import jakarta.persistence.*;

@Entity
@Table(name = "user_building")
@IdClass(UserBuildingEntId.class)
public class UserBuildingEnt {

    @Id
    @Column(name = "user_id", nullable = false)
    public Integer userId;

    @Id
    @Column(name = "building_id", nullable = false)
    public Integer buildingId;

    @Column(name = "ub_role_id", nullable = false)
    public Integer ubRoleId;

    //fks
    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    public UserEnt user;

    @ManyToOne
    @JoinColumn(name = "building_id", insertable = false, updatable = false)
    public BuildingEnt building;

    @ManyToOne
    @JoinColumn(name = "ub_role_id", insertable = false, updatable = false)
    public UbRoleEnt role;

    @Override
    public String toString() {
        return "UserBuildingEnt{" +
                "userId=" + userId +
                ", buildingId=" + buildingId +
                ", ubRoleId=" + ubRoleId +
                '}';
    }
}
