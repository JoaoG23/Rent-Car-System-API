package com.api.rentcar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class RentCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentCarApplication.class, args);
	}

	@GetMapping("/")
	public String index() {
		
		return "Welcome Rent Car System";
	}
}
