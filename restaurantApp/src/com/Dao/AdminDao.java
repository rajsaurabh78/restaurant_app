package com.Dao;

import java.util.List;

import com.Exception.AdminException;
import com.Exception.CustomerException;
import com.modal.Admin;
import com.modal.Product;

public interface AdminDao {

	public String redisterAdmin(Admin admin) throws AdminException;
	public String logIn(Integer adminId ,String password);
	public String deleteCustomer(Integer userId) throws CustomerException;
	public String deleteAdmin(Integer adminId) throws AdminException;
	public String addProduct(Product product);
	public String removeProduct(int pId);
	public List<Product> allProduct();
	public Product getProductById(Integer pId);
	public String updatePrice(Boolean newPrice);
	public String updateQuantity(Integer increasedQuantity);
	public String updateProduct(Product product);
	public String updateAdmin(Admin admin);
	
}
