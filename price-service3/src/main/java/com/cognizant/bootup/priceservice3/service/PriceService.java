package com.cognizant.bootup.priceservice3.service;

import com.cognizant.bootup.priceservice3.model.Price;

public interface PriceService {
	
	Price getPriceByProductId(int productId);

}
