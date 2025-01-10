package com.org.ze_delivery_spring_boot_back_end_java.models.dtos.responses;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoverageAreaResponse {
	private String type; 
	private Collection<Collection<Collection<Long>>> coordinates;
}
