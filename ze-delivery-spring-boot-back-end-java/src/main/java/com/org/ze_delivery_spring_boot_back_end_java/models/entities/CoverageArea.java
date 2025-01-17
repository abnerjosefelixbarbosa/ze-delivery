package com.org.ze_delivery_spring_boot_back_end_java.models.entities;

import com.org.ze_delivery_spring_boot_back_end_java.models.enums.CoverageAreaType;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CoverageArea {
	@Column(name = "coverage_area_type", nullable = true)
	private CoverageAreaType type; 
	@Column(name = "coverage_area_coordinate", nullable = true, length = 1000)
	private String coordinate;
}