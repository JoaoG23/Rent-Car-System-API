package com.api.rentcar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.rentcar.models.CarModel;


@Repository
public interface CarRepository extends JpaRepository<CarModel, Long> {

    boolean existsByLicensePlate(String licensePlate);
        
}
