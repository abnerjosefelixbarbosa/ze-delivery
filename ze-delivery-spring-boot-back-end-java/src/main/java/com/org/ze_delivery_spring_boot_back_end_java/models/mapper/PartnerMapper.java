package com.org.ze_delivery_spring_boot_back_end_java.models.mapper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

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
		List<List<List<Long>>> getCoverageArea = request.getCoverageArea().getCoordinates();
		String resultGetCoverageArea = getCoverageArea.stream().map(String::valueOf).collect(Collectors.joining(","));
		
		List<Long> getAddress = request.getAddress().getCoordinates();
		String resultGetAddress = getAddress.stream().map(String::valueOf).collect(Collectors.joining(","));
		
		CoverageArea coverageArea = new CoverageArea(request.getCoverageArea().getType(), resultGetCoverageArea);
		Address address = new Address(request.getAddress().getAddressType(), resultGetAddress);
		
		return new Partner(UlidCreator.getUlid().toString(), request.getTradingName(), request.getOwnerName(), request.getDocument(), coverageArea, address);
	}
	
	public PartnerResponse toPartnerResponse(Partner partner) {
		try {
			List<List<List<Long>>> getCoverageArea = objectMapper.readValue(partner.getCoverageArea().getCoordinates(), );
			
			//String resultGetAddress = partner.getAddress().getCoordinates();
			//List<Long> getAddress = Arrays.stream(resultGetAddress.split(",")).map(Long::valueOf).collect(Collectors.toList());
			
			CoverageAreaResponse coverageAreaResponse = new CoverageAreaResponse(partner.getCoverageArea().getType(), null);
			AddressResponse addressResponse = new AddressResponse(partner.getAddress().getType(), null);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return new PartnerResponse(partner.getId(), partner.getTradingName(), partner.getOwnerName(), partner.getDocument(), coverageAreaResponse, addressResponse);
	}
}