package com.org.ze_delivery_spring_boot_back_end_java.models.services.interfaces;

import java.math.BigDecimal;

import com.org.ze_delivery_spring_boot_back_end_java.models.dtos.requests.PartnerRequest;
import com.org.ze_delivery_spring_boot_back_end_java.models.dtos.responses.PartnerResponse;

public interface IPartnersService {
	PartnerResponse createPartner(PartnerRequest request);
	
	PartnerResponse loadPartnerById(String id);
	
	PartnerResponse searchPartnerByLongitudeAndLatitude(BigDecimal longitude, BigDecimal latitude);
}