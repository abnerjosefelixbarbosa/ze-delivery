package com.org.ze_delivery_spring_boot_back_end_java.models.entities;

import org.locationtech.jts.geom.MultiPolygon;

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
	private String coverageAreaType; 
	@Column(columnDefinition = "geometry(MultiPolygon, 4326)")
	private MultiPolygon coverageAreaCoordinates;
}