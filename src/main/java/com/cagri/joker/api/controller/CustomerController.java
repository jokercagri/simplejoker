package com.cagri.joker.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cagri.joker.api.dto.ApiOutput;
import com.cagri.joker.api.dto.ApiStatusOutput;
import com.cagri.joker.api.dto.CreateCustomerInput;
import com.cagri.joker.api.dto.CustomerInfoOutput;
import com.cagri.joker.api.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping(path = "/createCustomer")
	public void processTicketForOtpPayment(@Valid @RequestBody CreateCustomerInput input) {
		customerService.createCustomer(input);
	}
	
	@GetMapping(path = "/getCustomerInfo/{email}")
	public ApiOutput<CustomerInfoOutput> getCustomerInfo(@PathVariable String email) {
		CustomerInfoOutput output = customerService.getCustomerInfo(email);
		return new ApiOutput<CustomerInfoOutput>(ApiStatusOutput.SUCCESS, output);
	}

}
