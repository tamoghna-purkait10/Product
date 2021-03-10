package com.cognizant.bootup.orderservice.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cognizant.bootup.orderservice.Model.Cart;
import com.cognizant.bootup.orderservice.dao.OrderDao;
import com.cognizant.bootup.orderservice.entity.Orders;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	RestTemplate restTemplate;
	
	private String cartUrl = "http://localhost:1111/api/cart";
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public Orders createOrder(String loggedUser) {
		
		Orders order = null;
		
		Cart cart = restTemplate.getForObject(cartUrl + "/" +loggedUser, Cart.class);
		
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sss");
		Date currentDate = new Date();
		String orderDate = sdf.format(currentDate);
		
		if(cart != null) {
			order = new Orders();
			order.setDate(orderDate);
			order.setamount(cart.getAmount());
			order.setUser(loggedUser);
			orderDao.save(order);
		}
		
		restTemplate.delete(cartUrl + "/" +loggedUser, loggedUser);
		return order;
		
	}

}
