package com.dbmsProject.carRentalSystem.storage.dao;

import lombok.*;
import javax.persistence.*;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RentalHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rental_history_id;
    private Integer user_id;
    private Integer rental_id;
}
