package com.dbmsProject.carRentalSystem.model;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RentalReport {
    private Integer carId;
    private String pickUpLocation;
    private String returnLocation;
    private Integer rentalPrice;
    private String status;
    private String user;
    private Integer payment_amount;
    private String payment_method;
    private String payment_status;
}
