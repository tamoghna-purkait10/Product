package com.cognizant.bootup.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.bootup.orderservice.entity.Orders;
import com.cognizant.bootup.orderservice.service.OrderService;

@RestController
@CrossOrigin
@RequestMapping("/api/orders")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/{loggedUser}")
	public Orders createNewOrder(@PathVariable String loggedUser) {
		return orderService.createOrder(loggedUser);
	}

}
