package com.dbmsProject.carRentalSystem.storage.dao;


import lombok.*;
import javax.persistence.*;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RentalStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rental_status_id;
    private String rental_status_name;
}
