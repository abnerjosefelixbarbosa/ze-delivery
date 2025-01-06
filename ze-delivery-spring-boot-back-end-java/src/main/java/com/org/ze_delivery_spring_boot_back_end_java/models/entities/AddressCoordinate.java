package com.org.ze_delivery_spring_boot_back_end_java.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address_coordinates")
public class AddressCoordinate {
	@Id
	private String id;
	private Long x;
	private Long y;
	@ManyToOne
	private Partner partner;
}