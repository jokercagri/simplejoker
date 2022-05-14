package com.cagri.joker.api.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "CUSTOMER_ADDRESS")
public class CustomerAddress implements Serializable {

	private static final long serialVersionUID = 8700422753060972308L;

	@Id
	private String id;

	@Field("country")
	private String country;

	@Field("province")
	private String province;

	@Field("district")
	private String district;

	@Field("line")
	private String line;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

}
