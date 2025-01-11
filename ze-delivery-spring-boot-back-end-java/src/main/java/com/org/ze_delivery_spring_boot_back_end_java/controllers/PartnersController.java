package com.org.ze_delivery_spring_boot_back_end_java.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.org.ze_delivery_spring_boot_back_end_java.models.dtos.requests.PartnerRequest;
import com.org.ze_delivery_spring_boot_back_end_java.models.dtos.responses.PartnerResponse;
import com.org.ze_delivery_spring_boot_back_end_java.models.services.interfaces.IPartnersService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/partners")
public class PartnersController {
	@Autowired
	private IPartnersService partnersService;
	
	@PostMapping(value = "/create-partner")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<PartnerResponse> createPartner(@RequestBody @Valid PartnerRequest request) {
		return ResponseEntity.status(HttpStatus.CREATED).body(partnersService.createPartner(request));
	}
	
	@GetMapping(value = "/load-partner-by-id")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<PartnerResponse> loadPartnerById(@RequestParam String id) {
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	@GetMapping(value = "/search-partner-by-longitude-and-latitude")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<PartnerResponse> searchPartnerByLongAndLat(@RequestParam Long longitude, @RequestParam Long latitude) {
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
}