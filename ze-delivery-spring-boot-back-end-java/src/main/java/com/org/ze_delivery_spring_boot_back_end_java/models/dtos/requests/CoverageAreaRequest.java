package com.org.ze_delivery_spring_boot_back_end_java.models.dtos.requests;

import java.util.List;

import com.org.ze_delivery_spring_boot_back_end_java.models.enums.CoverageAreaType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoverageAreaRequest {
	CoverageAreaType type;
	List<List<List<Long>>> coordinates;
}