package com.org.ze_delivery_spring_boot_back_end_java.models.dtos;

import org.locationtech.jts.geom.MultiPolygon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoverageAreaResponse {
	private String type; 
	private MultiPolygon coordinates;
}
