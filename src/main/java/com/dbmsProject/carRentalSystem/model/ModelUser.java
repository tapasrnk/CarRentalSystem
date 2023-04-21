package com.dbmsProject.carRentalSystem.model;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ModelUser {
    private String name;
    private String email;
    private Integer phone;
    private String password;
}
