package com.cagri.joker.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cagri.joker.api.dto.CreateCustomerInput;
import com.cagri.joker.api.dto.CustomerAddressInfoOutput;
import com.cagri.joker.api.dto.CustomerInfoOutput;
import com.cagri.joker.api.dto.CreateCustomerAddressInput;
import com.cagri.joker.api.exceptions.BusinessException;
import com.cagri.joker.api.model.Customer;
import com.cagri.joker.api.model.CustomerAddress;
import com.cagri.joker.api.repository.CustomerAddressRepository;
import com.cagri.joker.api.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerAddressRepository customerAddressRepository;

	@Override
	public void createCustomer(CreateCustomerInput input) throws BusinessException {

		Customer customer = customerRepository.findByEmailIgnoreCase(input.getEmail());

		if (customer == null) {
			customer = new Customer();
			customer.setEmail(input.getEmail());
			customer.setName(input.getName());
			customer.setSurName(input.getSurName());
			customer.setPhone(input.getPhone());
			customer.setCustomerAddress(prepareAndOperationsAddress(input.getCustomerAddress()));
		} else {
			throw new BusinessException("Customer is already registered...");
		}

		customerRepository.save(customer);
	}

	private CustomerAddress prepareAndOperationsAddress(CreateCustomerAddressInput input) {
		CustomerAddress address = new CustomerAddress();
		address.setCountry(input.getCountry());
		address.setDistrict(input.getDistrict());
		address.setLine(input.getLine());
		address.setProvince(input.getProvince());
		customerAddressRepository.save(address);
		return address;
	}

	@Override
	public CustomerInfoOutput getCustomerInfo(String email)  {
		Customer customer = customerRepository.findByEmailIgnoreCase(email);
		CustomerInfoOutput customerOutput = null;
		if (customer != null) {
			customerOutput = new CustomerInfoOutput();
			customerOutput.setAddressInfo(prepareCustomerAddressInfoOutput(customer.getCustomerAddress()));
			customerOutput.setEmail(customer.getEmail());
			customerOutput.setName(customer.getName());
			customerOutput.setPhone(customer.getPhone());
			customerOutput.setSurName(customer.getSurName());
			return customerOutput;
		}else {
			throw new BusinessException("Customer not found...");
		}
		
	}

	private CustomerAddressInfoOutput prepareCustomerAddressInfoOutput(CustomerAddress customerAddress) {
		CustomerAddressInfoOutput output = new CustomerAddressInfoOutput();
		output.setCountry(customerAddress.getCountry());
		output.setDistrict(customerAddress.getDistrict());
		output.setLine(customerAddress.getLine());
		output.setProvince(customerAddress.getProvince());
		return output;
	}

}
