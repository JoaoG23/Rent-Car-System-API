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

import com.api.rentcar.dtos.LodgerDto;
import com.api.rentcar.models.LodgerModel;
import com.api.rentcar.services.LodgerServices;
import com.api.rentcar.utils.MessageReturns;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/logders")
public class LodgerController {
    final LodgerServices lodgerServices;

    public LodgerController(LodgerServices lodgerServices) {
        this.lodgerServices = lodgerServices;
    }

    @PostMapping
    public ResponseEntity<Object> createLodger(@RequestBody @Valid LodgerDto lodgerDto) {


        if(lodgerServices.existsByEmail(lodgerDto.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Already a lodger with email");
        }

        if(lodgerServices.existsByNumberDocument(lodgerDto.getNumberDocument())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Already a lodger with number document");
        }

        if (lodgerServices.existsByPhoneNumber(lodgerDto.getPhoneNumber())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Already a lodger with phone number");
        }

        var lodgerModel = new LodgerModel();

        BeanUtils.copyProperties(lodgerDto, lodgerModel);
        return ResponseEntity.status(HttpStatus.OK).body(lodgerServices.save(lodgerModel));
    }

    @GetMapping
    public ResponseEntity<Page<LodgerModel>> getAllLodger(@PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
            var listsLodger = lodgerServices.findAll(pageable);

        return ResponseEntity.status(HttpStatus.OK).body(listsLodger);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneLodger(@PathVariable(value = "id") Long id) {
        
        Optional<LodgerModel> lodgerModelOptional = lodgerServices.findById(id);
        if (!lodgerModelOptional.isPresent()) {
            
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The lodger not exists");
        }
        return ResponseEntity.status(HttpStatus.OK).body(lodgerModelOptional.get());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Object> updateLodger(@PathVariable(value = "id") Long id, @RequestBody @Valid LodgerDto lodgerDto) {
        
        Optional<LodgerModel> lodgerModelOptional = lodgerServices.findById(id);

        if (!lodgerModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lodger not exists for updated ");
        }

        LodgerModel lodgerModel = new LodgerModel();

        BeanUtils.copyProperties(lodgerDto, lodgerModel);

        lodgerModel.setId(lodgerModelOptional.get().getId());

        return ResponseEntity.status(HttpStatus.OK).body(lodgerServices.save(lodgerModel));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteLodger(@PathVariable(value = "id") Long id) {
        
        Optional<LodgerModel> lodgerModelOptional = lodgerServices.findById(id);

        MessageReturns errorConflict = new MessageReturns(false, "The lodger not exists");

        if (!lodgerModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorConflict);
        }
        lodgerServices.delete(lodgerModelOptional.get());

        return ResponseEntity.status(HttpStatus.OK).body(lodgerModelOptional);
    }

}
