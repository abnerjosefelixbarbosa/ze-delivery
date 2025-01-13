package com.org.ze_delivery_spring_boot_back_end_java.controllers;

import java.math.BigDecimal;

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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/partners")
public class PartnersController {
	@Autowired
	private IPartnersService partnersService;
	
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "cria um parceiro"),
			@ApiResponse(responseCode = "400", description = "retorna um erro de requesição")
	})
	@Operation(summary = "criar parceiro", description = "cria um parceiro")
	@PostMapping(value = "/create-partner")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<PartnerResponse> createPartner(@RequestBody @Valid PartnerRequest request) {
		return ResponseEntity.status(HttpStatus.CREATED).body(partnersService.createPartner(request));
	}
	
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "retorna um parceiro"),
			@ApiResponse(responseCode = "400", description = "retorna um erro de requesição"),
			@ApiResponse(responseCode = "404", description = "retorna um erro de não encontrado"),
	})
	@Operation(summary = "carregar parceiro pelo id", description = "carrega um parceiro pelo id")
	@GetMapping(value = "/load-partner-by-id")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<PartnerResponse> loadPartnerById(@RequestParam String id) {
		return ResponseEntity.status(HttpStatus.OK).body(partnersService.loadPartnerById(id));
	}
	
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "retorna um parceiro"),
			@ApiResponse(responseCode = "400", description = "retorna um erro de requesição"),
			@ApiResponse(responseCode = "404", description = "retorna um erro de não encontrado"),
	})
	@Operation(summary = "pesquisar parceiro pela longitude e latitude", description = "pesquisar um parceiro pela longitude e latitude")
	@GetMapping(value = "/search-partner-by-longitude-and-latitude")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<PartnerResponse> searchPartnerByLongitudeAndLatitude(@RequestParam BigDecimal longitude, @RequestParam BigDecimal latitude) {
		return ResponseEntity.status(HttpStatus.OK).body(partnersService.searchPartnerByLongitudeAndLatitude(longitude, latitude));
	}
}