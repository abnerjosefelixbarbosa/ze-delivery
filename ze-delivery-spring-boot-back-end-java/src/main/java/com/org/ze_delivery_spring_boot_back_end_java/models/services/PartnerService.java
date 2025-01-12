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
		
		return partnerMapper.toPartnerResponse(partners.stream()
				.filter((partner) -> fillterPartners(partner, longitude, latitude))
				.findFirst()
				.orElseThrow(() -> new EntityNotFoundException("parceiro não encontrado")));
	}
	
	private boolean fillterPartners(Partner partner, BigDecimal longitude, BigDecimal latitude) {
		
		try {
			List<BigDecimal> coordinates = objectMapper.readValue(partner.getAddress().getCoordinates(), new TypeReference<List<BigDecimal>>() {});
			Double shortestDistance = Double.MAX_VALUE;
			
			Double distance = calculateDistance(longitude, latitude, coordinates.get(0), coordinates.get(1));
			
			if (distance < shortestDistance) {
				return true;
            }
				
			return false;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	private Double calculateDistance(BigDecimal longitude1, BigDecimal latitude1, BigDecimal longitude2, BigDecimal latitude2) {
		final Double RAD = 6371.0; 
		
		Double latitude1Rad = Math.toRadians(latitude1.doubleValue());
		Double longitude1Rad = Math.toRadians(longitude1.doubleValue());
		Double latitude2Rad = Math.toRadians(latitude2.doubleValue());
		Double longitude2Rad = Math.toRadians(longitude2.doubleValue());
		
		Double deltaLatitude = latitude2Rad - latitude1Rad;
		Double deltaLongitude = longitude2Rad - longitude1Rad;
        
		Double formula = Math.sin(deltaLatitude / 2) * Math.sin(deltaLatitude / 2) +
                         Math.cos(latitude1Rad) * Math.cos(latitude2Rad) *
                         Math.sin(deltaLongitude / 2) * Math.sin(deltaLongitude / 2);

		Double result = 2 * Math.atan2(Math.sqrt(formula), Math.sqrt(1 - formula));
		
		return RAD * result;
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