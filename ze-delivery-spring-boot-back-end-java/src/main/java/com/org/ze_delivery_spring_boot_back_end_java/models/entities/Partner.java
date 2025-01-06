package com.org.ze_delivery_spring_boot_back_end_java.models.entities;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "partners")
public class Partner {
	@Id
	private String id;
	private String tradingName;
	private String ownerName;
	private String document;
	@Embedded
	private CoverageArea coverageArea;
	@Embedded
	private Address address;
}
