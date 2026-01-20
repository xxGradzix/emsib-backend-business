package com.emsib.emsib_backend_business.relational_database;

import jakarta.persistence.*;

@Entity
@Table(name = "ub_role")
public class UbRoleEnt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ub_role_id")
    public Integer ubRoleId;

    @Column(name = "name_", length = 20, nullable = false)
    public String name;

    @Override
    public String toString() {
        return "UbRole{" +
                "ubRoleId=" + ubRoleId +
                ", name='" + name + '\'' +
                '}';
    }
}
