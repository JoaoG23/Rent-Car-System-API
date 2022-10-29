package com.api.rentcar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.rentcar.models.RentingContractModel;

@Repository
public interface RentingContractRepository extends JpaRepository<RentingContractModel, Long> {
    public boolean existsByCodeLodgerId(Long codeLodgerId);
    public boolean existsByCodeCarId(Long codeCarId);

}
