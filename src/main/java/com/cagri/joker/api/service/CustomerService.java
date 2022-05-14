package com.cagri.joker.api.service;

import com.cagri.joker.api.dto.CreateCustomerInput;
import com.cagri.joker.api.dto.CustomerInfoOutput;

public interface CustomerService {
	
	public void createCustomer(CreateCustomerInput input);

	public CustomerInfoOutput getCustomerInfo(String email);

}
