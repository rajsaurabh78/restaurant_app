package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.Exception.CustomerException;
import com.modal.Customer;
import com.modal.Product;
import com.utility.DBUtil;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public String registerCustomer(Customer customer) throws CustomerException{
		String msg=null;
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("insert into Customer (name,email,mobile,password,address,pinCode,amount) values(?,?,?,?,?,?,?)");
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getEmail());
			ps.setString(3, customer.getMobile());
			ps.setString(4, customer.getPassword());
			ps.setString(5, customer.getAddress());
			ps.setString(6, customer.getPinCode());
			ps.setDouble(7, customer.getAmount());
			int x=ps.executeUpdate();
			if(x>0) {
				msg=customer.getName()+" is registered";
			}else
				throw new CustomerException("Not registered.");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return msg;
		
	}

	@Override
	public String updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> allProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductByPrice(Integer price, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String logIn(Integer userId, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
