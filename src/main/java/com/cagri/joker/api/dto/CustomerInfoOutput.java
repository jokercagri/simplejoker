package com.cagri.joker.api.dto;

public class CustomerInfoOutput {

	private String name;
	private String surName;
	private String email;
	private String phone;
	private CustomerAddressInfoOutput addressInfo;

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

	public CustomerAddressInfoOutput getAddressInfo() {
		return addressInfo;
	}

	public void setAddressInfo(CustomerAddressInfoOutput addressInfo) {
		this.addressInfo = addressInfo;
	}

}
