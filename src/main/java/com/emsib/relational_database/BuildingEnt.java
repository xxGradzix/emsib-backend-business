package com.emsib.relational_database;

import jakarta.persistence.*;

@Entity
@Table(name = "building")
public class BuildingEnt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "building_id")
    public Integer buildingId;

    @Column(name = "name_", length = 40, nullable = false)
    public String name;

    @Column(name = "street", length = 30, nullable = false)
    public String street;

    @Column(name = "street_num", length = 6, nullable = false)
    public String streetNum;

    @Column(name = "postal_code", length = 6, nullable = false)
    public String postalCode;

    @Column(name = "city", length = 25, nullable = false)
    public String city;

    @Column(name = "num_of_floors")
    public Short numOfFloors;

    @Column(name = "description_", length = 200)
    public String description;

    @Override
    public String toString() {
        return "Building{" +
                "buildingId=" + buildingId +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", streetNum='" + streetNum + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", numOfFloors=" + numOfFloors +
                ", description='" + description + '\'' +
                '}';
    }
}
