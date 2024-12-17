package com.mycompany.propertymanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

@Getter
@Setter
public class UserDTO {
    private int id;
    private String ownerName;
    private String ownerEmail;
    private String phone;
    private String password;
}
