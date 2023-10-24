package com.Dao;

import java.util.List;

import com.Exception.AdminException;
import com.Exception.CustomerException;
import com.Exception.ProductException;
import com.modal.Admin;
import com.modal.Product;

public interface AdminDao {

	public String redisterAdmin(Admin admin) throws AdminException;
	public String logIn(Integer adminId ,String password) throws AdminException;
	public String deleteCustomer(Integer userId) throws CustomerException;
	public String deleteAdmin(Integer adminId) throws AdminException;
	public String addProduct(Product product);
	public String removeProduct(int pId) throws ProductException;
	public List<Product> allProduct() throws ProductException;
	public Product getProductById(Integer pId) throws ProductException;
	public String updatePrice(Integer pId,Integer newPrice) throws ProductException;
	public String updateQuantity(Integer pId,Integer increasedQuantity) throws ProductException;
	public String updateProduct(Product product) throws ProductException;
	public String updateAdmin(Admin admin) throws AdminException;
	
}
