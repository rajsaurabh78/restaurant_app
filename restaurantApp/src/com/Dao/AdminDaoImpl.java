package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.Exception.AdminException;
import com.Exception.CustomerException;
import com.modal.Admin;
import com.modal.Product;
import com.utility.DBUtil;

public class AdminDaoImpl implements AdminDao{

	@Override
	public String redisterAdmin(Admin admin) throws AdminException{
		String msg=null;
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("insert into Admin (name,email,mobile,password,address,pinCode) values(?,?,?,?,?,?)");
			ps.setString(1, admin.getName());
			ps.setString(2, admin.getEmail());
			ps.setString(3, admin.getMobile());
			ps.setString(4, admin.getPassword());
			ps.setString(5, admin.getAddress());
			ps.setString(6, admin.getPinCode());
			int x=ps.executeUpdate();
			if(x>0) {
				msg=admin.getName()+" is registered";
			}else
				throw new AdminException("Not registered.");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return msg;
	}

	@Override
	public String deleteCustomer(Integer userId) throws CustomerException {
		String res=null;
		
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("delete from customer where userId = ?");
			ps.setInt(1, userId);
			int x=ps.executeUpdate();
			if(x>0) {
				res ="Deleted successfully .";
			}else
				throw new CustomerException("Inviled user Id .");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return res;
	}

	@Override
	public String deleteAdmin(Integer adminId) throws AdminException {
		
		String res=null;
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("delete from admin where adminId = ?");
			ps.setInt(1, adminId);
			int x=ps.executeUpdate();
			if(x>0) {
				res ="Deleted successfully .";
			}else
				throw new AdminException("Inviled admin Id .");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return res;
		
	}

	@Override
	public String addProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeProduct(int pId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> allProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProductById(Integer pId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updatePrice(Boolean newPrice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateQuantity(Integer increasedQuantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String logIn(Integer adminId, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
