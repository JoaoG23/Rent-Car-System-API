package com.api.rentcar.services.interfaces;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.api.rentcar.models.LodgerModel;

public interface RentingContractInterface {

    public LodgerModel save(LodgerModel lodgerModel);
    public Page<LodgerModel> findAll(Pageable pageable);
    public Optional<LodgerModel> findById(Long id);
    public boolean existsByEmail(String email);
    public void delete(LodgerModel lodgerModel);
}
