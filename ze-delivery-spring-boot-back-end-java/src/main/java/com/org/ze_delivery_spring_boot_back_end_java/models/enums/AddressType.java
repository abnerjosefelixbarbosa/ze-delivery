package com.org.ze_delivery_spring_boot_back_end_java.models.enums;

public enum AddressType {
	Point("Point");
	
	private String value;

	private AddressType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
