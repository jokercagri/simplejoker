package com.cagri.joker.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cagri.joker.api.dto.CreateOrderBookInfoInput;
import com.cagri.joker.api.dto.CreateOrderInput;
import com.cagri.joker.api.dto.CreateOrderOutput;
import com.cagri.joker.api.model.Order;
import com.cagri.joker.api.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public CreateOrderOutput createOrder(CreateOrderInput input) {
		Order order = prepareOrderModel(input);
		orderRepository.save(order);
		
		CreateOrderOutput output = prepareCreateOrderOutput(orderRepository.findByCustomerEmailIgnoreCase(input.getCustomerMail()));

		return output;
	}

	private CreateOrderOutput prepareCreateOrderOutput(Order order) {
		CreateOrderOutput output = new CreateOrderOutput();
		output.setCustomerMail(order.getCustomerEmail());
		output.setOrderId(order.getId());
		return output;
	}

	private Order prepareOrderModel(CreateOrderInput input) {
		Integer totalPrice = 0;
		Order order = new Order();
		order.setCustomerEmail(input.getCustomerMail());
		for (CreateOrderBookInfoInput createOrderBookInfoInput : input.getCreateOrderBookInfos()) {
			totalPrice = totalPrice + createOrderBookInfoInput.getTotalPriceForABook();
		}
		order.setTotalPrice(totalPrice);
		return order;
	}

}
