package com.api.rentcar.services.interfaces;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.api.rentcar.models.RentingContractModel;


public interface RentingContractInterface {

    public boolean existsByCodeLodgerId(Long codeLodgerId);
    public boolean existsByCodeCarId(Long codeCarId);
    public RentingContractModel save(RentingContractModel rentingContractModel);
    public Page<RentingContractModel> findAll(Pageable pageable);
    public Optional<RentingContractModel> findById(Long id);
    public boolean existsByEmail(String email);
    public void delete(RentingContractModel rentingContractModel);
}
