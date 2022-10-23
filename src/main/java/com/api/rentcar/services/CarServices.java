package com.api.rentcar.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.rentcar.models.CarModel;
import com.api.rentcar.repositories.CarRepository;
import com.api.rentcar.services.interfaces.CarInterface;

@Service
public class CarServices implements CarInterface {

    final CarRepository carRepository;

    public CarServices(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Transactional
    public CarModel save(CarModel carModel) {
        return carRepository.save(carModel);
    }

    @Override
    public Page<CarModel> findAll(Pageable pageable) {
        return carRepository.findAll(pageable);
    }

    @Override
    public Optional<CarModel> findById(Long id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }
    
    public boolean existsByLicensePlate(String licensePlate) {
        return carRepository.existsByLicensePlate(licensePlate);
    }

    @Override
    public void delete(CarModel carModel) {
        carRepository.delete(carModel);
    }

}
