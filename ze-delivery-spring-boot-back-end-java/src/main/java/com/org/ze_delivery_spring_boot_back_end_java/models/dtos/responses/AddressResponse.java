package com.org.ze_delivery_spring_boot_back_end_java.models.dtos.responses;

import java.math.BigDecimal;
import java.util.List;

import com.org.ze_delivery_spring_boot_back_end_java.models.enums.AddressType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponse {
	 private AddressType type;
	 private List<BigDecimal> coordinates;
}