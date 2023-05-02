package com.dbmsProject.carRentalSystem.service;

import com.dbmsProject.carRentalSystem.model.ModelCar;
import com.dbmsProject.carRentalSystem.model.ModelLocation;
import com.dbmsProject.carRentalSystem.model.RentalReport;
import com.dbmsProject.carRentalSystem.model.UserReport;
import com.dbmsProject.carRentalSystem.storage.dao.*;
import com.dbmsProject.carRentalSystem.storage.daoservice.*;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class AdminServices {
    @Autowired
    private User1Repository user1Repository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private RentalHistoryRepository rentalHistoryRepository;
    @Autowired
    private RentalRepository rentalRepository;
    @Autowired
    private RentalStatusRepository rentalStatusRepository;
    public List<RentalReport> getRentalReport() {
        List<RentalReport> rentalReports = new ArrayList<>();
        List<RentalHistory> rentalHistories = rentalHistoryRepository.findAll();
        for (RentalHistory rh : rentalHistories) {
            RentalReport rentalReport = new RentalReport();
            Optional<Rental> rental = rentalRepository.findById(rh.getRental_id());
            Optional<User1> user1 = user1Repository.findById(rh.getUser_id());
            Optional<Payment> payment = Optional.ofNullable(paymentRepository.findByrentalIdEquals(rh.getRental_id()));
            Optional<Location> pickuploc = locationRepository.findById(rental.get().getPickup_location());
            Optional<Location> returnloc = locationRepository.findById(rental.get().getReturn_location());
            rentalReport.setRentalPrice(rental.get().getRental_price());
            rentalReport.setStatus(rental.get().getRental_status());
            rentalReport.setPayment_status(payment.get().getPayment_status());
            rentalReport.setCarId(rental.get().getCar_id());
            rentalReport.setUser(user1.get().getName());
            rentalReport.setPayment_amount(payment.get().getPayment_amount());
            rentalReport.setRentalPrice(rental.get().getRental_price());
            rentalReport.setStatus(rental.get().getRental_status());
            rentalReport.setPayment_method(payment.get().getPayment_method());
            rentalReport.setPickUpLocation(pickuploc.get().getLocationName());
            rentalReport.setReturnLocation(returnloc.get().getLocationName());
            rentalReports.add(rentalReport);
        }
        return rentalReports;
    }

    public List<UserReport> getUserReport() {
        List<UserReport> userReports = new ArrayList<>();
        List<User1> users = new ArrayList<>();
        users = user1Repository.findAll();
        for (User1 user : users) {
            UserReport userReport = new UserReport();
            userReport.setUserId(user.getUser_id());
            userReport.setPhone(user.getPhone());
            userReport.setUsername(user.getName());
            userReport.setEmailId(user.getEmail());
            userReports.add(userReport);
        }
        return userReports;
    }

    public void addCar(ModelCar car) {
        Optional<Location> loc = Optional.ofNullable(locationRepository.findBylocationNameEquals(car.getLocation().getLocationName()));
        if (loc.isEmpty()) {
            Location loc1 = new Location();
            loc1.setLocationName(car.getLocation().getLocationName());
            loc1.setLocation_address(car.getLocation().getLocationAddress());
            loc = Optional.of(locationRepository.save(loc1));
        }
        Car car1 = new Car();
        car1.setMake(car.getMake());
        car1.setModel(car.getModel());
        car1.setCar_url(car.getCar_url());
        car1.setRental_price(car.getRentalPrice());
        car1.setLocation_id(loc.get().getLocation_id());
        car1.setManufacture_year(car.getYear());
        car1.setNumber_avilable(car.getNumber_avilable());
        carRepository.save(car1);
    }

    public void removeCar(ModelCar car) {
        Optional<Car> c = carRepository.findById(car.getCarId());
        System.out.println(c.get().getNumber_avilable());
        System.out.println(c);
        if (c.isEmpty() || c.get().getNumber_avilable() <= 0) {
            return ;
        }
        Car cr = new Car();
        cr.setManufacture_year(c.get().getManufacture_year());
        cr.setMake(c.get().getMake());
        cr.setCar_id(c.get().getCar_id());
        cr.setModel(c.get().getModel());
        cr.setRental_price(c.get().getRental_price());
        cr.setNumber_avilable(c.get().getNumber_avilable() - 1);
        cr.setLocation_id(c.get().getLocation_id());
        carRepository.save(cr);
    }

    public List<ModelCar> avilableCars() {
        List<Car> carlist = new ArrayList<>();
        carlist = carRepository.findAll();
        List<ModelCar> cars = new ArrayList<>();

        for (Car c : carlist) {
            if (c.getNumber_avilable() <= 0) continue;
            ModelCar car = new ModelCar();
            ModelLocation ml = new ModelLocation();
            Optional<Location> l = locationRepository.findById(c.getLocation_id());
            ml.setLocationName(l.get().getLocationName());
            ml.setLocationAddress(l.get().getLocation_address());
            car.setCarId(c.getCar_id());
            car.setCar_url(c.getCar_url());
            car.setMake(c.getMake());
            car.setYear(c.getManufacture_year());
            car.setModel(c.getModel());
            car.setRentalPrice(c.getRental_price());
            car.setLocation(ml);
            car.setNumber_avilable(c.getNumber_avilable());
            cars.add(car);
        }
        return cars;
    }
}
