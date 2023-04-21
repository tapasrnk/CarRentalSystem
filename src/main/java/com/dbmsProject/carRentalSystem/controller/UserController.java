package com.dbmsProject.carRentalSystem.controller;

import com.dbmsProject.carRentalSystem.model.Book;
import com.dbmsProject.carRentalSystem.model.ModelCar;
import com.dbmsProject.carRentalSystem.model.ModelRental;
import com.dbmsProject.carRentalSystem.model.ModelUser;
import com.dbmsProject.carRentalSystem.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServices userService;

    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@RequestBody ModelUser modelUser) {
        userService.addUser(modelUser);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/cars")
    public ResponseEntity<List<ModelCar>> avilableCars() {
        return ResponseEntity.ok(userService.avilableCars());
    }

    @PostMapping("/book")
    public ResponseEntity<ModelRental> bookCar(@RequestBody Book book) {
        return ResponseEntity.ok(userService.bookCar(book));
    }

    @GetMapping("/check")
    public ResponseEntity<ModelRental> checkBookingStatus(@RequestBody ModelRental rental) {
        return ResponseEntity.ok(userService.checkStatus(rental));
    }
}
