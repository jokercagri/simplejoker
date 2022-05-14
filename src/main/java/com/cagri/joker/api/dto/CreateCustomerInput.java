package com.cagri.joker.api.dto;

public class CreateCustomerInput {

	private String name;
	private String surName;
	private String email;
	private String phone;
	private CreateCustomerAddressInput customerAddress;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public CreateCustomerAddressInput getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(CreateCustomerAddressInput customerAddress) {
		this.customerAddress = customerAddress;
	}

}
