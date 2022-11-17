package com.api.rentcar.models;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "TB_RESTING_CONTRACTS")
public class RentingContractModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCodeContract;

    @Column(nullable = false)
    private LocalDateTime initialDateRent;
    
    
    @Column(nullable = false)
    private LocalDateTime finalDateRent;
    
    
    @Column(nullable = false)
    private LocalDateTime dateHappend;

    // Joins
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "codeLodgerId", nullable = false)
    private LodgerModel lodger;
    
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "codeCarId", nullable = false)
    private CarModel car;


    @Column(nullable = true)
    private String observations;



    // GET e SET
    public Long getIdCodeContract() {
        return idCodeContract;
    }


    public void setIdCodeContract(Long idCodeContract) {
        this.idCodeContract = idCodeContract;
    }


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
