package com.cognizant.bootup.priceservice2.service;

import com.cognizant.bootup.priceservice2.model.Price;

public interface PriceService {
	
	Price getPriceByProductId(int productId);

}
