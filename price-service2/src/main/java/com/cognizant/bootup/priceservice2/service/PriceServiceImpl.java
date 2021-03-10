package com.cognizant.bootup.priceservice2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cognizant.bootup.priceservice2.model.Price;
import com.cognizant.bootup.priceservice2.model.Product;

@Service
public class PriceServiceImpl implements PriceService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private String productUrl = "http://localhost:8081/api/products";
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public Price getPriceByProductId(int productId) {
		
		Price priceObj = null;
		
		Product product = restTemplate.getForObject(productUrl + "/" + productId, Product.class);
		
		if (product != null) {
			priceObj = new Price();
			priceObj.setId(product.getId());
			priceObj.setName(product.getName());
			priceObj.setPrice(product.getPrice());
		}
		
		return priceObj;
		
	}

}
