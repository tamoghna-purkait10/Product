package com.cognizant.bootup.cartservice.model;

public class UserCart {
	
	private Product item;
	private int qty;
	
	public UserCart() {}

	public UserCart(Product item, int qty) {
		super();
		this.item = item;
		this.qty = qty;
	}

	public Product getItem() {
		return item;
	}

	public void setItem(Product item) {
		this.item = item;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

}
