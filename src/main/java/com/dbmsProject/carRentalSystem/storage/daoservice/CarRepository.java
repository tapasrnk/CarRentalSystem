package com.dbmsProject.carRentalSystem.storage.daoservice;

import com.dbmsProject.carRentalSystem.storage.dao.Car;
import com.dbmsProject.carRentalSystem.storage.dao.User1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer>{

}
