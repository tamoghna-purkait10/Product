package com.cognizant.bootup.priceservice4.service;

import com.cognizant.bootup.priceservice4.model.Price;

public interface PriceService {
	
	Price getPriceByProductId(int productId);

}
