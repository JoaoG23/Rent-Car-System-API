package com.api.rentcar.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * CarDto
 */
public class CarDto {

    @NotBlank
    private String brand;

    @NotBlank
    private String model;
    
    @NotBlank
    private String color;
    
    @NotBlank
    @Size(max = 14)
    private String licensePlate;


    // Get e Setts
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