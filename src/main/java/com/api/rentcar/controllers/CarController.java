package com.api.rentcar.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rentcar.dtos.CarDto;
import com.api.rentcar.models.CarModel;
import com.api.rentcar.services.CarServices;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cars")
public class CarController {

    final CarServices carServices;

    public CarController(CarServices carServices) {
        this.carServices = carServices;
    }

    @PostMapping
    public ResponseEntity<Object> createCar(@RequestBody @Valid CarDto carDto) {

        if (carServices.existsByLicensePlate(carDto.getLicensePlate())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Already a Car with license Plate!");
        }

        var carModel = new CarModel();

        BeanUtils.copyProperties(carDto, carModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(carServices.save(carModel));
    }

    @GetMapping
    public ResponseEntity<Page<CarModel>> getAllCar(
            @PageableDefault(page = 0, size = 10, sort = "idCodeCar", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(carServices.findAll(pageable));
    }

    @GetMapping("/{idCodeCar}")
    public ResponseEntity<Object> getOneCar(@PathVariable(value = "idCodeCar") Long id) {

        Optional<CarModel> carModelOptional = carServices.findById(id);

        if (!carModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The Car not exists for found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(carModelOptional.get());
        
    }

    @PutMapping("/{idCodeCar}")
    public ResponseEntity<Object> updateCar(@PathVariable(value = "idCodeCar") Long id, @RequestBody @Valid CarDto carDto) {
        
        Optional<CarModel> carModelOptional = carServices.findById(id);

        if (!carModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The Car not exist for to be updated");
        }

        CarModel carModel = new CarModel();
        

        BeanUtils.copyProperties(carDto, carModel);

        carModel.setIdCodeCar(carModelOptional.get().getIdCodeCar());

        return ResponseEntity.status(HttpStatus.OK).body(carServices.save(carModel));
        

    }

    @DeleteMapping("/{idCodeCar}")
    public ResponseEntity<Object> deleteCar(@PathVariable(value = "idCodeCar") Long id) {

        Optional<CarModel> carModelOptional = carServices.findById(id);

        if (!carModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The Car not exists");
        }

        carServices.delete(carModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Car removed with success");
        
    }
}
