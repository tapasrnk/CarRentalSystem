package com.dbmsProject.carRentalSystem.service;

import com.dbmsProject.carRentalSystem.model.*;
import com.dbmsProject.carRentalSystem.storage.dao.*;
import com.dbmsProject.carRentalSystem.storage.daoservice.*;
import com.dbmsProject.carRentalSystem.utill.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserServices {
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


    @Autowired
    private Hash hash;
    public void addUser(ModelUser userModel) {
        User1 user1 = new User1();
        user1.setEmail(userModel.getEmail());
        user1.setName(userModel.getName());
        user1.setRole("user");
        user1.setPhone(userModel.getPhone());
        user1.setPassword(hash.hashMD5(userModel.getPassword()));
        user1Repository.save(user1);
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

    public ModelRental bookCar(Book book) {
        String pwd = book.getPassword();
        pwd = hash.hashMD5(pwd);
        Optional<User1> user = Optional.ofNullable(user1Repository.findBypasswordEquals(pwd));
//        System.out.println(pwd);
//        System.out.println(user);
        if (user.isEmpty() || !(user.get().getName().equals(book.getUsername()))) {
            return null;
        }
        Optional<Car> c = carRepository.findById(book.getCarId());
//        System.out.println(c.get().getNumber_avilable());
//        System.out.println(c);
        if (c.isEmpty() || c.get().getNumber_avilable() <= 0) {
            return null;
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
        Rental rent = new Rental();
        rent.setCar_id(cr.getCar_id());
        rent.setRental_price(cr.getRental_price());
        Optional<Location> pckll = Optional.ofNullable(locationRepository.findBylocationNameEquals(book.getPickUpLocation()));
        Optional<Location> retll = Optional.ofNullable(locationRepository.findBylocationNameEquals(book.getReturnLocation()));
        rent.setPickup_location(pckll.get().getLocation_id());
        rent.setReturn_location(retll.get().getLocation_id());
        rent.setRental_end(book.getRentalStart());
        rent.setRental_start(book.getRentalEnd());
        rent.setRental_price(cr.getRental_price());
        rent.setRental_status("Pending");
        rentalRepository.save(rent);
        ModelRental modelRental = new ModelRental();
        List<Rental> rlist = new ArrayList<>();
        Integer id = 0;
        rlist = rentalRepository.findAll();
        for (Rental r : rlist) {
            if (id.intValue() < r.getRental_id().intValue()) {
                id = r.getRental_id().intValue();
            }
        }
        Optional<Rental> rnt = rentalRepository.findById(id);
        modelRental.setStatus(rnt.get().getRental_status());
        modelRental.setRentalId(rnt.get().getRental_id());
        RentalHistory rentalHistory = new RentalHistory();
        rentalHistory.setUser_id(user.get().getUser_id());
        rentalHistory.setRental_id(rnt.get().getRental_id());
        rentalHistoryRepository.save(rentalHistory);
        Payment payment = new Payment();
        payment.setPayment_amount(book.getAmount());
        payment.setPayment_method("UPI");
        payment.setRentalId(rnt.get().getRental_id());
        payment.setPayment_status("Pending");
        paymentRepository.save(payment);
        return modelRental;
    }

    public ModelRental checkStatus(ModelRental modelRental) {
        ModelRental modelRental1 = new ModelRental();
        Optional<Rental> rental = rentalRepository.findById(modelRental.getRentalId());
        modelRental1.setRentalId(rental.get().getRental_id());
        modelRental1.setStatus(rental.get().getRental_status());
        return modelRental1;
    }
}
