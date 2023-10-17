package com.modal;

public class Customer extends Details{
	
	private Integer userId;
	private double amount;
	
	public Customer() {
		
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Customer(Integer userId, double amount) {
		super();
		this.userId = userId;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", amount=" + amount + "]";
	}

	
}
