package com.cognizant.bootup.orderservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Orders {

	@Id
	@GeneratedValue
	private int id;
	private String date;
	private double amount;
	private String user;
	
	public Orders() {}

	public Orders(int id, String date, double amount, String user) {
		super();
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getamount() {
		return amount;
	}

	public void setamount(double amount) {
		this.amount = amount;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	

}
