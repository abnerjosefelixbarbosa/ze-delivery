package com.org.ze_delivery_spring_boot_back_end_java.models.mapper;

import org.springframework.stereotype.Component;

import com.github.f4b6a3.ulid.UlidCreator;
import com.org.ze_delivery_spring_boot_back_end_java.models.dtos.requests.PartnerRequest;
import com.org.ze_delivery_spring_boot_back_end_java.models.entities.Address;
import com.org.ze_delivery_spring_boot_back_end_java.models.entities.CoverageArea;
import com.org.ze_delivery_spring_boot_back_end_java.models.entities.Partner;

@Component
public class PartnerMapper {
	
	public Partner toPartner(PartnerRequest request) {
		CoverageArea coverageArea = new CoverageArea(request.getCoverageArea().getType(), request.getCoverageArea().getCoordinates());
		Address address = new Address(request.getAddress().getAddressType(), request.getAddress().getCoordinates());
		
		return new Partner(UlidCreator.getUlid().toString(), request.getTradingName(), request.getOwnerName(), request.getDocument(), coverageArea, address);
	}
	
}