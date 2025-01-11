package com.org.ze_delivery_spring_boot_back_end_java.models.entities;

import jakarta.persistence.Column;
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
	@Column(name = "partner_id", nullable = false)
	private String id;
	@Column(name = "trading_name", nullable = false)
	private String tradingName;
	@Column(name = "owner_name", nullable = false)
	private String ownerName;
	@Column(name = "document", nullable = false, unique = true)
	private String document;
	@Embedded
	private CoverageArea coverageArea;
	@Embedded
	private Address address;
}
