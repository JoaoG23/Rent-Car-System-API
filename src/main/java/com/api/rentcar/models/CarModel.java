package com.api.rentcar.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "TB_CARS")
public class CarModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCodeCar;


    @Column(nullable = false)
    private String brand;
    
    @Column(nullable = false)
    private String model;
    
    @Column(nullable = false)
    private String color;
    
    
    @Column(nullable = false, length = 14)
    private String licensePlate;



    // Get e Setter
    public Long getIdCodeCar() {
        return idCodeCar;
    }


    public void setIdCodeCar(Long idCodeCar) {
        this.idCodeCar = idCodeCar;
    }


    public String getBrand() {
        return brand;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }


    public String getModel() {
        return model;
    }


    public void setModel(String model) {
        this.model = model;
    }


    public String getColor() {
        return color;
    }


    public void setColor(String color) {
        this.color = color;
    }


    public String getLicensePlate() {
        return licensePlate;
    }


    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }


}
