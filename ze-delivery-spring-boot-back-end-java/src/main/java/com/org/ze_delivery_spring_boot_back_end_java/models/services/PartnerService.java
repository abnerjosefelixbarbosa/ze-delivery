package com.org.ze_delivery_spring_boot_back_end_java.models.services;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.ze_delivery_spring_boot_back_end_java.models.dtos.requests.PartnerRequest;
import com.org.ze_delivery_spring_boot_back_end_java.models.dtos.responses.PartnerResponse;
import com.org.ze_delivery_spring_boot_back_end_java.models.entities.Partner;
import com.org.ze_delivery_spring_boot_back_end_java.models.mapper.PartnerMapper;
import com.org.ze_delivery_spring_boot_back_end_java.models.repositories.interfaces.IPartnerRepository;
import com.org.ze_delivery_spring_boot_back_end_java.models.services.interfaces.IPartnersService;

@Service
public class PartnerService implements IPartnersService {
	@Autowired
	private IPartnerRepository partnerRepository;
	@Autowired
	private PartnerMapper partnerMapper;
	private ObjectMapper objectMapper = new ObjectMapper();

	public PartnerResponse createPartner(PartnerRequest request) {
        validateCoverageAreaCoordinates(request);
		
		validateCoverageAreaType(request);
		
		validateAddressType(request);
		
		validateAddressCoordinates(request);
		
		Partner partner = partnerMapper.toPartner(request);
		
		validateDocument(partner);
		
		return partnerMapper.toPartnerResponse(partnerRepository.save(partner));
	}

	public PartnerResponse loadPartnerById(String id) {
		return partnerMapper.toPartnerResponse(partnerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("parceiro não encontrado")));
	}

	public PartnerResponse searchPartnerByLongAndLat(BigDecimal longitude, BigDecimal latitude) {
		List<Partner> partners = partnerRepository.findAll();
			
		return partnerMapper.toPartnerResponse(
				partners.stream().filter((partner) -> {
					try {
						List<BigDecimal> addressCoordinates = objectMapper.readValue(partner.getAddress().getCoordinates(), new TypeReference<List<BigDecimal>>() {});
							
						if (addressCoordinates.get(0) == longitude && addressCoordinates.get(1) == latitude)
							return true;
							
						return false;
					} catch (Exception e) {
						throw new RuntimeException(e.getMessage());
					}
				}).findFirst().get()
		);
	}
	
	private void validateDocument(Partner partner) {
		if (partnerRepository.existsByDocument(partner.getDocument()))
			throw new RuntimeException("documento já existe");
	}
	
	private void validateCoverageAreaType(PartnerRequest request) {
		if (request.getCoverageArea().getType() == null)
			throw new RuntimeException("tipo da area de cobertura não deve ser nulo");
	}
	
	private void validateCoverageAreaCoordinates(PartnerRequest request) {
		if (request.getCoverageArea().getCoordinates() == null)
			throw new RuntimeException("coordenadas da area de coorbertura não deve ser nulo");
		
		if (request.getCoverageArea().getCoordinates().isEmpty())
			throw new RuntimeException("coordenadas da area de coorbertura não deve ser vázia");
	}
	
	private void validateAddressType(PartnerRequest request) {
		if (request.getAddress().getType() == null)
			throw new RuntimeException("tipo do endereço não deve ser nulo");
	}
	
	private void validateAddressCoordinates(PartnerRequest request) {
		if (request.getAddress().getCoordinates() == null)
			throw new RuntimeException("coordenadas do endereço não deve ser nulo");
		
		if (request.getAddress().getCoordinates().isEmpty())
			throw new RuntimeException("coordenadas do endereço não deve ser vázio");
	}
}