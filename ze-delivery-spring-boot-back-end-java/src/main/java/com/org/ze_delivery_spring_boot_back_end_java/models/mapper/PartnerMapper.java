package com.org.ze_delivery_spring_boot_back_end_java.models.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.f4b6a3.ulid.UlidCreator;
import com.org.ze_delivery_spring_boot_back_end_java.models.dtos.requests.PartnerRequest;
import com.org.ze_delivery_spring_boot_back_end_java.models.dtos.responses.AddressResponse;
import com.org.ze_delivery_spring_boot_back_end_java.models.dtos.responses.CoverageAreaResponse;
import com.org.ze_delivery_spring_boot_back_end_java.models.dtos.responses.PartnerResponse;
import com.org.ze_delivery_spring_boot_back_end_java.models.entities.Address;
import com.org.ze_delivery_spring_boot_back_end_java.models.entities.CoverageArea;
import com.org.ze_delivery_spring_boot_back_end_java.models.entities.Partner;

@Component
public class PartnerMapper {
	private ObjectMapper objectMapper = new ObjectMapper();
	
	public Partner toPartner(PartnerRequest request) {
		try {
			String objectCoverageAreaCoordinates = objectMapper.writeValueAsString(request.getCoverageArea().getCoordinates());
			String objectAddressCoordinates = objectMapper.writeValueAsString(request.getAddress().getCoordinates());
			
			CoverageArea coverageArea = new CoverageArea(request.getCoverageArea().getType(), objectCoverageAreaCoordinates);
			Address address = new Address(request.getAddress().getType(), objectAddressCoordinates);
			
			return new Partner(UlidCreator.getUlid().toString(), request.getTradingName(), request.getOwnerName(), request.getDocument(), coverageArea, address);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public PartnerResponse toPartnerResponse(Partner partner) {
		try {
			String objectCoverageAreaCoordinates = partner.getCoverageArea().getCoordinates();
			List<List<List<List<BigDecimal>>>> coverageAreaCoordinates = objectMapper.readValue(objectCoverageAreaCoordinates, new TypeReference<List<List<List<List<BigDecimal>>>>>() {});

			String objectAddressCoordinates = partner.getAddress().getCoordinates();
			List<BigDecimal> addressCoordinates = objectMapper.readValue(objectAddressCoordinates, new TypeReference<List<BigDecimal>>() {});
			
			CoverageAreaResponse coverageAreaResponse = new CoverageAreaResponse(partner.getCoverageArea().getType(), coverageAreaCoordinates);
			AddressResponse addressResponse = new AddressResponse(partner.getAddress().getType(), addressCoordinates);
			
			return new PartnerResponse(partner.getId(), partner.getTradingName(), partner.getOwnerName(), partner.getDocument(), coverageAreaResponse, addressResponse);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}