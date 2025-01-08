package com.org.ze_delivery_spring_boot_back_end_java.models.entities;

import org.locationtech.jts.geom.MultiPolygon;

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
	@Column(name = "coverage_area_type")
	private CoverageAreaType type; 
	@Column(columnDefinition = "geometry(MultiPolygon, 4326)", name = "coverage_area_coordinates")
	private MultiPolygon coordinates;
}