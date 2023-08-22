package com.mtco.domain.enums;

public enum RoleType {

	ROLE_CUSTOMER("Customer"),
	ROLE_ADMIN("Administrator");
	// TODO sonra seller da eklenebilir
	private String name;
	
	private RoleType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
