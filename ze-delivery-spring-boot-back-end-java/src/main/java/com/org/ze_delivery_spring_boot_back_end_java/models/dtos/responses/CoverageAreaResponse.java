package com.org.ze_delivery_spring_boot_back_end_java.models.dtos.responses;

import java.math.BigDecimal;
import java.util.List;

import com.org.ze_delivery_spring_boot_back_end_java.models.enums.CoverageAreaType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoverageAreaResponse {
	private CoverageAreaType type; 
	private List<List<List<List<BigDecimal>>>> coordinates;;
}
