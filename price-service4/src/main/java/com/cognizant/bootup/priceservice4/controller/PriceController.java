package com.cognizant.bootup.priceservice4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.bootup.priceservice4.model.Price;
import com.cognizant.bootup.priceservice4.service.PriceService;

@RestController
@CrossOrigin
@RequestMapping("/api/price")
public class PriceController {

	@Autowired
	private PriceService priceService;
	
	@GetMapping("/{productId}")
	public Price getPriceByProductId(@PathVariable("productId") int productId) {
		return priceService.getPriceByProductId(productId);
	}
	
}
