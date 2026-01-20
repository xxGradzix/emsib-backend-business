package com.emsib.relational_database;

import jakarta.persistence.*;

@Entity
@Table(name = "property_type")
public class PropertyTypeEnt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "property_type_id")
    public Integer propertyTypeId;

    @Column(name = "name_", length = 40, nullable = false)
    public String name;

    @Override
    public String toString() {
        return "PropertyTypeEnt{" +
                "propertyTypeId=" + propertyTypeId +
                ", name='" + name + '\'' +
                '}';
    }
}
