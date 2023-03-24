package com.mycompany.propertymanagement.dto;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter



public class PropertyDTO {

    private int id;
    private String title;
    private String description;
    private String OwnerName;
    private String OwnerEmail;
    private String adress;
    private Double price;

}
