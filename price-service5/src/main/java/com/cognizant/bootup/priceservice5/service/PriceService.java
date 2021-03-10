package com.cognizant.bootup.priceservice5.service;

import com.cognizant.bootup.priceservice5.model.Price;

public interface PriceService {
	
	Price getPriceByProductId(int productId);

}
