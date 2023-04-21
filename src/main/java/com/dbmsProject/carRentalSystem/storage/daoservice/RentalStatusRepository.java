package com.dbmsProject.carRentalSystem.storage.daoservice;

import com.dbmsProject.carRentalSystem.storage.dao.Car;
import com.dbmsProject.carRentalSystem.storage.dao.RentalStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RentalStatusRepository extends JpaRepository<RentalStatus, Integer>{


}
