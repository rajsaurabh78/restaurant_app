package com.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Exception.AdminException;
import com.Exception.CustomerException;
import com.Exception.ProductException;
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
		String res=null;
		try(Connection conn=DBUtil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("insert into product (pName,type,price,expiryDate,mfgDate,quantity) values(?,?,?,?,?,?)");
			ps.setString(1, product.getpName());
			ps.setString(2, product.getType());
			ps.setDouble(3, product.getPrice());
			ps.setDate(4, product.getExpiryDate());
			ps.setDate(5, product.getMfgDate());
			ps.setInt(6, product.getQuantity());
			int x=ps.executeUpdate();
			if(x>0) {
				res=product.getpName()+" is registered .";
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return res;
	}

	@Override
	public String removeProduct(int pId) throws ProductException {

		String res=null;
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("delete from product where pId = ?");
			ps.setInt(1, pId);
			int x=ps.executeUpdate();
			if(x>0) {
				res ="Deleted successfully .";
			}else
				throw new ProductException("Inviled product Id .");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return res;
		
	}



	@Override
	public Product getProductById(Integer pId) throws ProductException {
		Product res=null;
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("select * from product where pId = ?");
			ps.setInt(1, pId);
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				do {
	            	int id=rs.getInt("pId");
					String n=rs.getString("pName");
					String t=rs.getString("type");
					double pr=rs.getDouble("price");
					int qn=rs.getInt("quantity");
					Date mfg=rs.getDate("mfgDate");
					Date exp=rs.getDate("expiryDate");
					Product pd=new Product(id, t, n, pr, exp, mfg, qn);
					res=pd;
				} while (rs.next());
			} else {
				throw new ProductException("Inviled product Id .");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return res;
	}

	@Override
	public String updatePrice(Integer pId,Integer newPrice) throws ProductException {
		String res="";
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("update product set price=? where pId = ?");
			ps.setInt(2, pId);
			ps.setInt(1, newPrice);
			int x= ps.executeUpdate();
			if(x>0) {
				res="Price updated.";
			} else {
				throw new ProductException("Inviled product Id .");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return res;
	}

	@Override
	public String updateQuantity(Integer pId,Integer increasedQuantity) throws ProductException {
		
		String res="";
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("update product set quantity=quantity+? where pId = ?");
			ps.setInt(2, pId);
			ps.setInt(1, increasedQuantity);
			int x= ps.executeUpdate();
			if(x>0) {
				res="Quantity updated.";
			} else {
				throw new ProductException("Inviled product Id .");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return res;
		
	}

	@Override
	public String updateProduct(Product product) throws ProductException {
		
		String res="";
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("update product set pName=?, type=?, expiryDate=?, quantity=?,  price=?, mfgDate=? where pId = ?");
			ps.setString(1, product.getpName());
			ps.setString(2, product.getType());
			ps.setDouble(5, product.getPrice());
			ps.setDate(3, product.getExpiryDate());
			ps.setDate(6, product.getMfgDate());
			ps.setInt(4, product.getQuantity());
			ps.setInt(7, product.getpId());
			int x= ps.executeUpdate();
			
			if(x>0) {
				res="Product updated.";
			} else {
				throw new ProductException("Inviled product Id .");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return res;
		
	}

	@Override
	public String updateAdmin(Admin admin) throws AdminException {
		String res="";
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("update admin set name=?, email=?, mobile=?, password=?,  address=?, pinCode=? where adminId = ?");
			ps.setString(1, admin.getName());
			ps.setString(2, admin.getEmail());
			ps.setString(3, admin.getMobile());
			ps.setString(4, admin.getPassword());
			ps.setString(5, admin.getAddress());
			ps.setString(6, admin.getPinCode());
			ps.setInt(7, admin.getAdminId());
			int x= ps.executeUpdate();
			
			if(x>0) {
				res="Admin updated.";
			} else {
				throw new AdminException("Inviled admin Id .");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return res;
	}

	@Override
	public String logIn(Integer adminId, String password) throws AdminException {
		String res="";
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("select * from admin where adminId = ? and password=?");
			ps.setInt(1, adminId);
			ps.setString(2, password);
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				do {
					String n=rs.getString("name");
					res="Welcome to my restaurent : "+n;
				} while (rs.next());
			} else {
				throw new AdminException("Inviled admin Id or password .");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return res;
	}

	@Override
	public List<Product> allProduct() throws ProductException {
		
		List<Product> list=new ArrayList<>();
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("select * from product");
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("pId");
				String n=rs.getString("pName");
				String t=rs.getString("type");
				double pr=rs.getDouble("price");
				int qn=rs.getInt("quantity");
				Date mfg=rs.getDate("mfgDate");
				Date exp=rs.getDate("expiryDate");
				
				Product pd=new Product(id, t, n, pr, exp, mfg, qn);
				list.add(pd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(list.size()>0) {
			return list;
		}else {
			throw new ProductException("Empty list .");
		}
	}

}
