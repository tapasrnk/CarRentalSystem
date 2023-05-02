package com.dbmsProject.carRentalSystem.storage.dao;

import lombok.*;
import javax.persistence.*;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer car_id;
    private String car_url;
    private String make;
    private String model;
    private String manufacture_year;
    private Integer location_id;
    private Integer rental_price;
    private Integer number_avilable;
}
