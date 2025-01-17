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
			
			CoverageArea coverageArea = new CoverageArea();
			coverageArea.setType(request.getCoverageArea().getType());
			coverageArea.setCoordinate(objectCoverageAreaCoordinates);
			
			Address address = new Address();
			address.setType(request.getAddress().getType());
			address.setCoordinate(objectAddressCoordinates);
			
			Partner partner = new Partner();
			partner.setAddress(address);
			partner.setCoverageArea(coverageArea);
			partner.setDocument(request.getDocument());
			partner.setId(UlidCreator.getUlid().toString());
			partner.setOwnerName(request.getOwnerName());
			partner.setTradingName(request.getTradingName());
			
			return partner;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public PartnerResponse toPartnerResponse(Partner partner) {
		try {
			String objectCoverageAreaCoordinates = partner.getCoverageArea().getCoordinate();
			List<List<List<List<BigDecimal>>>> coverageAreaCoordinate = objectMapper.readValue(objectCoverageAreaCoordinates, new TypeReference<List<List<List<List<BigDecimal>>>>>() {});

			String objectAddressCoordinates = partner.getAddress().getCoordinate();
			List<BigDecimal> addressCoordinate = objectMapper.readValue(objectAddressCoordinates, new TypeReference<List<BigDecimal>>() {});
			
			CoverageAreaResponse coverageAreaResponse = new CoverageAreaResponse();
			coverageAreaResponse.setType(partner.getCoverageArea().getType());
			coverageAreaResponse.setCoordinates(coverageAreaCoordinate);
			
			AddressResponse addressResponse = new AddressResponse();
			addressResponse.setType(partner.getAddress().getType());
			addressResponse.setCoordinates(addressCoordinate);
			
			PartnerResponse partnerResponse = new PartnerResponse();
			partnerResponse.setId(partner.getId());
			partnerResponse.setAddress(addressResponse);
			partnerResponse.setCoverageArea(coverageAreaResponse);
			partnerResponse.setDocument(partner.getDocument());
			partnerResponse.setOwnerName(partner.getOwnerName());
			partnerResponse.setTradingName(partner.getTradingName());
			
			return partnerResponse;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}