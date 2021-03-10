package com.cognizant.bootup.cartservice.model;

public class Product {
	
	private int id;
	private String name;
	private Double price;
	private double itemTotal;
	
	public Product() {}

	public Product(int id, String name, Double price, double itemTotal) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.itemTotal = itemTotal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public double getItemTotal() {
		return itemTotal;
	}

	public void setItemTotal(double itemTotal) {
		this.itemTotal = itemTotal;
	}

}
