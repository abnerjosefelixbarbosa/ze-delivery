package com.org.ze_delivery_spring_boot_back_end_java.models.dtos.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartnerRequest {
	@NotEmpty(message = "Nome comercial não deve ser vázio")
	@NotNull(message = "Nome comercial não deve ser nulo")
	private String tradingName;
	@NotEmpty(message = "Nome do proprietário não deve ser vázio")
	@NotNull(message = "Nome do proprietário não deve ser nulo")
	private String ownerName;
	@NotEmpty(message = "Document não deve ser vázio")
	@NotNull(message = "Document não deve ser nulo")
	private String document;
	
	@NotNull(message = "Coverage area não deve ser nulo")
	private CoverageAreaRequest coverageArea;
	
	@NotNull(message = "Address não deve ser nulo")
	private AddressRequest address;
	
	
	
}
