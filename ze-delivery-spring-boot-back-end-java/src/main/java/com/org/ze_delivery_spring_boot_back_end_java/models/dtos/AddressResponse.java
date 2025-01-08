package com.org.ze_delivery_spring_boot_back_end_java.models.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponse {
	 private String type;
	 private List<AddressCoordinateResponse> coordinates;
}
