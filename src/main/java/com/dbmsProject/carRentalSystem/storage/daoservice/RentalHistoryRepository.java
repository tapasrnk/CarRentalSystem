package com.dbmsProject.carRentalSystem.storage.daoservice;

import com.dbmsProject.carRentalSystem.storage.dao.Car;
import com.dbmsProject.carRentalSystem.storage.dao.RentalHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalHistoryRepository extends JpaRepository<RentalHistory, Integer>{

}
