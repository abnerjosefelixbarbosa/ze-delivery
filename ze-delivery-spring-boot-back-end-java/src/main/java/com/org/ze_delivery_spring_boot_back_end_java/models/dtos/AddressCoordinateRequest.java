package com.org.ze_delivery_spring_boot_back_end_java.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressCoordinateRequest {
	private Long longitude;
	private Long latitude;
}