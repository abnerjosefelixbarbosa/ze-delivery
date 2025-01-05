package com.org.ze_delivery_spring_boot_back_end_java.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CoverageArea {
	private String coverageAreatype; 
	private String coverageAreaCoordinates;
}