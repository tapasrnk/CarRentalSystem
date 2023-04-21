package com.dbmsProject.carRentalSystem.storage.dao;

import lombok.*;
import javax.persistence.*;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer payment_id;
    private Integer rentalId;
    private Integer payment_amount;
    private String payment_method;
    private String payment_status;
}
