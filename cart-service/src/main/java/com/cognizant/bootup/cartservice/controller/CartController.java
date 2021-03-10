package com.cognizant.bootup.cartservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.bootup.cartservice.entity.Cart;
import com.cognizant.bootup.cartservice.model.UserCart;
import com.cognizant.bootup.cartservice.service.CartService;

@RestController
@CrossOrigin
@RequestMapping("/api/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PostMapping("/{loggedUser}")
	public UserCart addToCart(@RequestBody UserCart cart, @PathVariable String loggedUser) {
		
		return cartService.getCartTotal(cart, loggedUser);
	}
	
	@GetMapping("/{loggedUser}")
	public Cart getCartDetails(@PathVariable String loggedUser) {
		return cartService.getCartDetails(loggedUser);
	}
	
	@DeleteMapping("/{loggedUser}")
	public void deleteCartDetails(@PathVariable String loggedUser) {
		cartService.deleteCartData(loggedUser);
	}
}
