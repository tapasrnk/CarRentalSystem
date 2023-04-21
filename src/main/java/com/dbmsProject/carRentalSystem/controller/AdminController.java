package com.dbmsProject.carRentalSystem.controller;

import com.dbmsProject.carRentalSystem.model.*;
import com.dbmsProject.carRentalSystem.service.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminServices adminService;

    @GetMapping("/rentalreport")
    public ResponseEntity<List<RentalReport>> rentalReport() {
        return ResponseEntity.ok(adminService.getRentalReport());
    }

    @GetMapping("/userreport")
    public ResponseEntity<List<UserReport>> userReport() {
        return ResponseEntity.ok(adminService.getUserReport());
    }

    @PostMapping("/addcar")
    public ResponseEntity<Void> addCar(@RequestBody ModelCar car) {
        adminService.addCar(car);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/removecar")
    public ResponseEntity<Void> removeCar(@RequestBody ModelCar modelCar) {
        adminService.removeCar(modelCar);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/cars")
    public ResponseEntity<List<ModelCar>> avilableCars() {
        return ResponseEntity.ok(adminService.avilableCars());
    }
}
