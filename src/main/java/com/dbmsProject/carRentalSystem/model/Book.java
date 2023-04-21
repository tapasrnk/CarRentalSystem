package com.dbmsProject.carRentalSystem.model;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {
    private Integer carId;
    private String username;
    private String password;
    private String paymentId;
    private Integer amount;
    private String pickUpLocation;
    private String returnLocation;
    private String rentalStart;
    private String rentalEnd;
}
