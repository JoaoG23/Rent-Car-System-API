package com.api.rentcar.services.interfaces;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.api.rentcar.models.LodgerModel;

public interface LodgerInterface {

    public LodgerModel save(LodgerModel lodgerModel);
    public Page<LodgerModel> findAll(Pageable pageable);
    public Optional<LodgerModel> findById(Long id);
    public boolean existsByNumberDocument(String numberDocument);
    public boolean existsByPhoneNumber(String phoneNumber);
    public boolean existsByEmail(String email);
    public void delete(LodgerModel lodgerModel);
}
