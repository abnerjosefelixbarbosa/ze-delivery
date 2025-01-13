package com.org.ze_delivery_spring_boot_back_end_java.models.dtos.requests;

import java.math.BigDecimal;
import java.util.List;

import com.org.ze_delivery_spring_boot_back_end_java.models.enums.CoverageAreaType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoverageAreaRequest {
	@Enumerated(EnumType.STRING)
	CoverageAreaType type;
	List<List<List<List<BigDecimal>>>> coordinates;
}