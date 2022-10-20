package com.api.rentcar.services.interfaces;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.api.rentcar.models.CarModel;

public interface CarInterface {
    public abstract CarModel save(CarModel carModel);
    public abstract Page<CarModel> findAll(Pageable pageable);
    public abstract Optional<CarModel> findById(Long id);
    public abstract boolean existsByLicensePlate(String licensePlate);
}
