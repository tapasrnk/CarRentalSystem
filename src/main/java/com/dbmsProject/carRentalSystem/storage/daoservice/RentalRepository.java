package com.dbmsProject.carRentalSystem.storage.daoservice;

import com.dbmsProject.carRentalSystem.storage.dao.Car;
import com.dbmsProject.carRentalSystem.storage.dao.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Integer>{

}
