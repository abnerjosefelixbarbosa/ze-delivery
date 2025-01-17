package com.org.ze_delivery_spring_boot_back_end_java.models.entities;

import com.org.ze_delivery_spring_boot_back_end_java.models.enums.AddressType;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {
	 @Column(name = "address_type")
	 private AddressType type;
	 @Column(name = "address_coordinate", nullable = false)
	 private String coordinate;
}