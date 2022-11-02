package com.api.rentcar.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.rentcar.models.RentingContractModel;
import com.api.rentcar.repositories.RentingContractRepository;
import com.api.rentcar.services.interfaces.RentingContractInterface;

@Service
public class RentingContractServices implements RentingContractInterface  {

    final RentingContractRepository rentingContractRepository;

    public RentingContractServices(RentingContractRepository rentingContractRepository) {
        this.rentingContractRepository = rentingContractRepository;
    }

    @Override
    public void delete(RentingContractModel rentingContractModel) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean existsByEmail(String email) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Page<RentingContractModel> findAll(Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<RentingContractModel> findById(Long id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public RentingContractModel save(RentingContractModel rentingContractModel) {
        return rentingContractRepository.save(rentingContractModel);
    }

    @Override
    public boolean existsByCodeLodgerId(Long codeLodgerId) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean existsByCodeCarId(Long codeCarId) {
        // TODO Auto-generated method stub
        return false;
    }
}
