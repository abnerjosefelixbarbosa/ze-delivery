package com.org.ze_delivery_spring_boot_back_end_java.models.dtos.requests;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartnerRequest {
	@NotEmpty(message = "nome comercial não deve ser vázio")
	@NotNull(message = "nome comercial não deve ser nulo")
	private String tradingName;
	@NotEmpty(message = "nome do proprietário não deve ser vázio")
	@NotNull(message = "nome do proprietário não deve ser nulo")
	private String ownerName;
	@NotEmpty(message = "document não deve ser vázio")
	@NotNull(message = "document não deve ser nulo")
	//@CNPJ(message = "cnpj não deve ser invalido")
	@Length(min = 17, message = "document deve ser de tamanho minimo 17")
	private String document;
	
	@NotNull(message = "coverage area não deve ser nulo")
	private CoverageAreaRequest coverageArea;
	
	@NotNull(message = "address não deve ser nulo")
	private AddressRequest address;
	
	
	
}
