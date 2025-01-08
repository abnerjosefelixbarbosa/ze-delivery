package com.org.ze_delivery_spring_boot_back_end_java.models.dtos;

import java.util.List;

import org.hibernate.validator.constraints.br.CNPJ;
import org.locationtech.jts.geom.MultiPolygon;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartnerRequest {
	@NotEmpty(message = "nome comercial vázio")
	@NotNull(message = "nome comercial nulo")
	private String tradingName;
	@NotEmpty(message = "nome do proprietário vázio")
	@NotNull(message = "nome do proprietário nulo")
	private String ownerName;
	@NotEmpty(message = "documento vázio")
	@NotNull(message = "documento nulo")
	@CNPJ(message = "documento invalido")
	private String document;
	
	@NotEmpty(message = "tipo da area de cobertura vázio")
	@NotNull(message = "tipo da area de cobertura nulo")
	private String coverageAreaType; 
	@NotNull(message = "coordenadas da area de cobertura nulo")
	private MultiPolygon coverageAreaCoordinates;
	
	@NotEmpty(message = "tipo do endereço vázio")
	@NotNull(message = "tipo do endereço nulo")
	private String addressType;
	@NotNull(message = "coordenadas do endereço nulo")
	private List<AddressCoordinateRequest> addressCoordinateRequests;
}
