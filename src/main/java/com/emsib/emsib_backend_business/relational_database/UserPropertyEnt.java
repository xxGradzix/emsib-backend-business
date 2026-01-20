package com.emsib.emsib_backend_business.relational_database;

import jakarta.persistence.*;

@Entity
@Table(name = "user_property")
@IdClass(UserPropertyEntId.class)
public class UserPropertyEnt {

    @Id
    @Column(name = "user_id", nullable = false)
    public Integer userId;

    @Id
    @Column(name = "property_id", nullable = false)
    public Integer propertyId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    public UserEnt user;

    @ManyToOne
    @JoinColumn(name = "property_id", insertable = false, updatable = false)
    public PropertyEnt property;

    @Override
    public String toString() {
        return "UserPropertyEnt{" +
                "userId=" + userId +
                ", propertyId=" + propertyId +
                '}';
    }
}
