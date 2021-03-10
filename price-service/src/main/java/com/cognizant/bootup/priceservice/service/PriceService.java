package com.cognizant.bootup.priceservice.service;

import com.cognizant.bootup.priceservice.model.Price;

public interface PriceService {
	
	Price getPriceByProductId(int productId);

}
