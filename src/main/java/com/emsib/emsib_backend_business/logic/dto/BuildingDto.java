package com.emsib.emsib_backend_business.logic.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BuildingDto {
    private Integer id;
    private String name;
    private String street;
    private String number;
    private String code;
    private String city;
    private Short floors;
    private String description;
}
