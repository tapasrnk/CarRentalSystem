package com.dbmsProject.carRentalSystem.model;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ModelCar {
    private Integer carId;
    private String car_url;
    private String make;
    private String model;
    private String year;
    private ModelLocation location;
    private Integer rentalPrice;
    private Integer number_avilable;
}
