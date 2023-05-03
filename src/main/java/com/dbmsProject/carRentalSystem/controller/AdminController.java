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
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    AdminServices adminService;

    @CrossOrigin(origins = "*")
    @GetMapping("/v1/rentalreport")
    public ResponseEntity<List<RentalReport>> rentalReport() {
        return ResponseEntity.ok(adminService.getRentalReport());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/v1/userreport")
    public ResponseEntity<List<UserReport>> userReport() {
        return ResponseEntity.ok(adminService.getUserReport());
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/v1/addcar")
    public ResponseEntity<Void> addCar(@RequestBody ModelCar car) {
        adminService.addCar(car);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/v1/removecar")
    public ResponseEntity<Void> removeCar(@RequestBody ModelCar modelCar) {
        adminService.removeCar(modelCar);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/v1/cars")
    public ResponseEntity<List<ModelCar>> avilableCars() {
        return ResponseEntity.ok(adminService.avilableCars());
    }
}
