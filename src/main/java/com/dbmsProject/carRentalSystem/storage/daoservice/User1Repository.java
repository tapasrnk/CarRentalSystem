package com.dbmsProject.carRentalSystem.storage.daoservice;

import com.dbmsProject.carRentalSystem.storage.dao.Location;
import com.dbmsProject.carRentalSystem.storage.dao.User1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface User1Repository extends JpaRepository<User1, Integer>{
    User1 findBypasswordEquals(String name);
}
