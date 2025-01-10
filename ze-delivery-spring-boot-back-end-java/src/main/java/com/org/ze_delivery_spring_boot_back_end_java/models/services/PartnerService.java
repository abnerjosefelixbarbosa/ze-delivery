package com.org.ze_delivery_spring_boot_back_end_java.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.ze_delivery_spring_boot_back_end_java.models.dtos.requests.PartnerRequest;
import com.org.ze_delivery_spring_boot_back_end_java.models.dtos.responses.PartnerResponse;
import com.org.ze_delivery_spring_boot_back_end_java.models.entities.Partner;
import com.org.ze_delivery_spring_boot_back_end_java.models.repositories.interfaces.IPartnerRepository;
import com.org.ze_delivery_spring_boot_back_end_java.models.services.interfaces.IPartnersService;

@Service
public class PartnerService implements IPartnersService {
	@Autowired
	private IPartnerRepository partnerRepository;

	public PartnerResponse createPartner(PartnerRequest request) {
		
		return null;
	}

	public PartnerResponse loadPartnerById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public PartnerResponse searchPartnerByLongAndLat(Long longitude, Long latitude) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void validatePartner(Partner partner) {
		
	}
}