package com.org.ze_delivery_spring_boot_back_end_java.models.dtos.responses;

import java.util.Collection;

import com.org.ze_delivery_spring_boot_back_end_java.models.enums.AddressType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponse {
	 private AddressType type;
	 private Collection<Long> coordinates;
}