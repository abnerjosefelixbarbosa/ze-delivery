package com.org.ze_delivery_spring_boot_back_end_java.models.entities;

import java.util.List;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {
	 private String addressType;
	 @OneToMany(mappedBy = "partner", fetch = FetchType.EAGER)
	 private List<AddressCoordinate> addressCoordinates;
}