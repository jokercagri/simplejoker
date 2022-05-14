package com.cagri.joker.api.service;

import com.cagri.joker.api.dto.CreateOrderInput;
import com.cagri.joker.api.dto.CreateOrderOutput;

public interface OrderService {
	
	public CreateOrderOutput createOrder(CreateOrderInput input);

}
