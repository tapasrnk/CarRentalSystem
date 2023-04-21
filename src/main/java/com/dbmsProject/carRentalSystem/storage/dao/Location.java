package com.dbmsProject.carRentalSystem.storage.dao;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer location_id;
    @Column(name="locationName")
    private String locationName;
    private String location_address;
}
