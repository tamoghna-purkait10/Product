package com.cognizant.bootup.orderservice.service;

import com.cognizant.bootup.orderservice.entity.Orders;

public interface OrderService {
	
	public Orders createOrder(String loggedUser);

}
