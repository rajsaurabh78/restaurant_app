package com.Dao;

import java.util.List;

import com.Exception.CustomerException;
import com.modal.Customer;
import com.modal.Product;

public interface CustomerDao {
	
	public String registerCustomer(Customer customer) throws CustomerException;
	public String logIn(Integer userId ,String password);
	public String updateCustomer(Customer customer);
	public List<Product> allProduct();
	public List<Product> getProductByName(String name);
	public List<Product> getProductByType(String type);
	public List<Product> getProductByPrice(Integer price,String order);
	
}
