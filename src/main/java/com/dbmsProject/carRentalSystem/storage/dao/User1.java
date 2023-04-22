package com.dbmsProject.carRentalSystem.storage.dao;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Integer user_id;
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="phone")
    private String phone;
    @Column(name="password")
    private String password;
    @Column(name="role")
    private String role;
}
