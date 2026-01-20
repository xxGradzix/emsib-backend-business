package com.emsib.emsib_backend_business.relational_database;

import jakarta.persistence.*;

@Entity
@Table(name = "property")
public class PropertyEnt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "property_id")
    public Integer propertyId;

    @Column(name = "name_", length = 40, nullable = false)
    public String name;

    @Column(name = "floor")
    public Short floor;

    @Column(name = "number", length = 6)
    public String number;

    @Column(name = "property_type_id", nullable = false)
    public Integer propertyTypeId;

    @Column(name = "building_id", nullable = false)
    public Integer buildingId;

    //fks
    @ManyToOne
    @JoinColumn(name = "property_type_id", insertable = false, updatable = false)
    public PropertyTypeEnt propertyType;

    @ManyToOne
    @JoinColumn(name = "building_id", insertable = false, updatable = false)
    public BuildingEnt building;

    @Override
    public String toString() {
        return "PropertyEnt{" +
                "propertyId=" + propertyId +
                ", name='" + name + '\'' +
                ", floor=" + floor +
                ", number='" + number + '\'' +
                ", propertyTypeId=" + propertyTypeId +
                ", buildingId=" + buildingId +
                '}';
    }
}
