package com.org.ze_delivery_spring_boot_back_end_java.models.dtos.requests;

import java.math.BigDecimal;
import java.util.List;

import com.org.ze_delivery_spring_boot_back_end_java.models.enums.AddressType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {
	@Enumerated(EnumType.STRING)
	private AddressType type;
	private List<BigDecimal> coordinates;
}