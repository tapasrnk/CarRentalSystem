package com.dbmsProject.carRentalSystem.storage.dao;

import lombok.*;
import javax.persistence.*;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rental_id;
    private Integer car_id;
    private Integer pickup_location;
    private Integer return_location;
    private String rental_start;
    private String rental_end;
    private Integer rental_price;
    private String rental_status;
}
