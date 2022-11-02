package com.api.rentcar.dtos;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import com.api.rentcar.models.CarModel;
import com.api.rentcar.models.LodgerModel;

public class RentingContractDto {
    
    @NotBlank
    private LocalDateTime initialDateRent;
    
    @NotBlank
    private LocalDateTime finalDateRent;
    
    @NotBlank
    private LocalDateTime dateHappend;

    @NotBlank
    private LodgerModel lodger;
    
    @NotBlank
    private CarModel car;

    private String observations;

    

    public LocalDateTime getInitialDateRent() {
        return initialDateRent;
    }

    public void setInitialDateRent(LocalDateTime initialDateRent) {
        this.initialDateRent = initialDateRent;
    }

    public LocalDateTime getFinalDateRent() {
        return finalDateRent;
    }

    public void setFinalDateRent(LocalDateTime finalDateRent) {
        this.finalDateRent = finalDateRent;
    }

    public LocalDateTime getDateHappend() {
        return dateHappend;
    }

    public void setDateHappend(LocalDateTime dateHappend) {
        this.dateHappend = dateHappend;
    }

    public LodgerModel getLodger() {
        return lodger;
    }

    public void setLodger(LodgerModel lodger) {
        this.lodger = lodger;
    }

    public CarModel getCar() {
        return car;
    }

    public void setCar(CarModel car) {
        this.car = car;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
}
