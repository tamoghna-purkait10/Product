package com.cognizant.bootup.cartservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cognizant.bootup.cartservice.dao.CartDao;
import com.cognizant.bootup.cartservice.entity.Cart;
import com.cognizant.bootup.cartservice.model.UserCart;
import com.cognizant.bootup.cartservice.model.Price;
import com.cognizant.bootup.cartservice.model.Product;

@Service
@RibbonClient(name="price-proxy", configuration = PriceServiceConfiguration.class)
public class CartServiceImpl implements CartService {
	
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Autowired
	@LoadBalanced
	private RestTemplate restTemplate;
	
	@Autowired
	private CartDao cartDao;
	
	private String priceUrl = "http://price-service/api/price";

	@Override
	public UserCart getCartTotal(UserCart cart, String loggedUser) {
		
		UserCart finalCart = new UserCart();
		double productPrice = 0;
		
		int productId = cart.getItem().getId();
		
		if (cart.getItem().getPrice() == null) {
			Price price = restTemplate.getForObject(priceUrl + "/" + productId, Price.class);
			if (price != null) {
				productPrice = price.getPrice();
			}
		} else {
			productPrice = cart.getItem().getPrice();
		}
		
		double finalCartPrice = cart.getQty() * productPrice;
		
		Cart cartEntity = new Cart();
		cartEntity.setLoggedUser(loggedUser);
		cartEntity.setItemId(cart.getItem().getId());
		cartEntity.setQty(cart.getQty());
		cartEntity.setAmount(finalCartPrice);
		cartDao.save(cartEntity);
		
		Product item = new Product();
		item.setId(productId);
		item.setName(cart.getItem().getName());
		item.setPrice(productPrice);
		item.setItemTotal(finalCartPrice);
		
		finalCart.setItem(item);
		finalCart.setQty(cart.getQty());
		
		return finalCart;
		
	}
	
	@Override
	public Cart getCartDetails(String loggedUser) {
		return cartDao.findCartByloggedUserIgnoreCase(loggedUser);
	}

	@Override
	public void deleteCartData(String loggedUser) {
		cartDao.deleteCartByloggedUserIgnoreCase(loggedUser);
		
	}
}
