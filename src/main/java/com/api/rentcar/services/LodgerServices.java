package com.api.rentcar.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.rentcar.models.LodgerModel;
import com.api.rentcar.repositories.LodgerRepository;
import com.api.rentcar.services.interfaces.LodgerInterface;

@Service
public class LodgerServices implements LodgerInterface {
 
    final LodgerRepository lodgerRepository;

    public LodgerServices(LodgerRepository lodgerRepository) {
        this.lodgerRepository = lodgerRepository;
    }

    @Transactional
    @Override
    public LodgerModel save(LodgerModel lodgerModel) {
        return lodgerRepository.save(lodgerModel);
    }

    @Override
    public Page<LodgerModel> findAll(Pageable pageable) {
        return lodgerRepository.findAll(pageable);
    }

    @Override
    public Optional<LodgerModel> findById(Long id) {
        return lodgerRepository.findById(id);
    }

    @Override
    public boolean existsByNumberDocument(String numberDocument) {
        return lodgerRepository.existsByNumberDocument(numberDocument);
    }

    @Override
    public boolean existsByPhoneNumber(String phoneNumber) {
        return lodgerRepository.existsByPhoneNumber(phoneNumber);
    }

    @Override
    public boolean existsByEmail(String email) {
        return lodgerRepository.existsByEmail(email);
    }

    @Override
    public void delete(LodgerModel lodgerModel) {
        lodgerRepository.delete(lodgerModel);
    }

}
