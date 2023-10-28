package com.Dao;

import java.util.List;

import com.Exception.CustomerException;
import com.Exception.ProductException;
import com.modal.Customer;
import com.modal.Product;

public interface CustomerDao {
	
	public String registerCustomer(Customer customer) throws CustomerException;
	public String logIn(Integer userId ,String password) throws CustomerException;
	public String updateCustomer(Customer customer) throws CustomerException;
	public List<Product> allProduct() throws ProductException;
	public List<Product> getProductByName(String name) throws ProductException;
	public List<Product> getProductByType(String type) throws ProductException;
	public List<Product> getProductByPrice(Integer min,Integer max,String order) throws ProductException;
	public String addMoney(int Userid,int rs)throws CustomerException;
	public String orderItem(int pId,int userId,int quantity)throws ProductException, CustomerException;
	public List<Product> myCart(int userId) throws ProductException;
	
}
