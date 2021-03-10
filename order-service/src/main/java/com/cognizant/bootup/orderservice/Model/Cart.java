package com.cognizant.bootup.orderservice.Model;

public class Cart {

	private String loggedUser;
	private int itemId;
	private int qty;
	private double amount;
	
	public Cart() {}

	public Cart(String loggedUser, int itemId, int qty, double amount) {
		super();
		this.loggedUser = loggedUser;
		this.itemId = itemId;
		this.qty = qty;
		this.amount = amount;
	}

	public String getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(String loggedUser) {
		this.loggedUser = loggedUser;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
