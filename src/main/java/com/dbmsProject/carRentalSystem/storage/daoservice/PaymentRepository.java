package com.dbmsProject.carRentalSystem.storage.daoservice;

import com.dbmsProject.carRentalSystem.storage.dao.Car;
import com.dbmsProject.carRentalSystem.storage.dao.Location;
import com.dbmsProject.carRentalSystem.storage.dao.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{
    Payment findByrentalIdEquals(Integer name);
}
