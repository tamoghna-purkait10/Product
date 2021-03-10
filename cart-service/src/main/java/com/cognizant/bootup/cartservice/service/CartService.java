package com.cognizant.bootup.cartservice.service;

import com.cognizant.bootup.cartservice.entity.Cart;
import com.cognizant.bootup.cartservice.model.UserCart;

public interface CartService {
	
	UserCart getCartTotal(UserCart cart, String loggedUser);
	
	Cart getCartDetails(String loggedUser);
	
	void deleteCartData(String loggedUser);

}
