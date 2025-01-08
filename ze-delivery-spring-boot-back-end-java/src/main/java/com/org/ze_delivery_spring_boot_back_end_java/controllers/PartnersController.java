package com.org.ze_delivery_spring_boot_back_end_java.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.ze_delivery_spring_boot_back_end_java.models.dtos.PartnerRequest;
import com.org.ze_delivery_spring_boot_back_end_java.models.dtos.PartnerResponse;

@RestController
@RequestMapping(value = "/api/partners")
public class PartnersController {

	
	@PostMapping
	public ResponseEntity<PartnerResponse> createPartner(PartnerRequest request) {
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}
	
	public ResponseEntity<PartnerResponse> loadPartnerById() {
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	public ResponseEntity<PartnerResponse> searchPartnerById() {
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
}