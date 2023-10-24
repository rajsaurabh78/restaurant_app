package com.modal;

import java.sql.Date;

public class Product {
	
	private int pId;
	private String type;
	private String pName;
	private double price;
	private Date expiryDate;
	private Date mfgDate;
	private int quantity;
	
	public Product() {
		
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Date getMfgDate() {
		return mfgDate;
	}

	public void setMfgDate(Date mfgDate) {
		this.mfgDate = mfgDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product(int pId, String type, String pName, double price, Date expiryDate, Date mfgDate, int quantity) {
		super();
		this.pId = pId;
		this.type = type;
		this.pName = pName;
		this.price = price;
		this.expiryDate = expiryDate;
		this.mfgDate = mfgDate;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [pId=" + pId + ", type=" + type + ", pName=" + pName + ", price=" + price + ", expiryDate="
				+ expiryDate + ", mfgDate=" + mfgDate + ", quantity=" + quantity + "]";
	}

	
}
