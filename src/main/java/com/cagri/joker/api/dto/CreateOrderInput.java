package com.cagri.joker.api.dto;

import java.util.List;

public class CreateOrderInput {

	private String customerMail;
	private List<CreateOrderBookInfoInput> createOrderBookInfos;

	public String getCustomerMail() {
		return customerMail;
	}

	public void setCustomerMail(String customerMail) {
		this.customerMail = customerMail;
	}

	public List<CreateOrderBookInfoInput> getCreateOrderBookInfos() {
		return createOrderBookInfos;
	}

	public void setCreateOrderBookInfos(List<CreateOrderBookInfoInput> createOrderBookInfos) {
		this.createOrderBookInfos = createOrderBookInfos;
	}

}
