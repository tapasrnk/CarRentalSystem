package com.dbmsProject.carRentalSystem.model;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserReport {
    private Integer userId;
    private String username;
    private String emailId;
    private String phone;
}
