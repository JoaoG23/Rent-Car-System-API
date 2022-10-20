package com.api.rentcar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.rentcar.models.LodgerModel;


@Repository
public interface LodgerRepository extends JpaRepository<LodgerModel, Long>{

}
