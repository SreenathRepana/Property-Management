package com.mycompany.propertymanagement.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="PROPERTY")
@Getter
@Setter
@NoArgsConstructor
@Data

public class PropertyEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="Property_title")
    private String title;

    private String description;

    private String adress;

    private Double price;
}
