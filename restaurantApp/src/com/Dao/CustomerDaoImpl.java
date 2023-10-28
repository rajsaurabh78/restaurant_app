package com.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Exception.CustomerException;
import com.Exception.ProductException;
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
	public String updateCustomer(Customer customer) throws CustomerException {
		String res="";
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("update customer set name=?, email=?, mobile=?, password=?,  address=?, pinCode=? ,amount=amount+? where userId = ?");
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getEmail());
			ps.setString(3, customer.getMobile());
			ps.setString(4, customer.getPassword());
			ps.setString(5, customer.getAddress());
			ps.setString(6, customer.getPinCode());
			ps.setDouble(7, customer.getAmount());
			ps.setInt(8, customer.getUserId());
			int x= ps.executeUpdate();
			
			if(x>0) {
				res="Customer updated.";
			} else {
				throw new CustomerException("Inviled customer Id .");
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

	@Override
	public List<Product> getProductByName(String name) throws ProductException {
		List<Product> list=new ArrayList<>();
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("select * from product where pName=?");
			ps.setString(1, name);
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

	@Override
	public List<Product> getProductByType(String type) throws ProductException {
		List<Product> list=new ArrayList<>();
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("select * from product where type=?");
			ps.setString(1, type);
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

	@Override
	public List<Product> getProductByPrice(Integer min,Integer max, String order) throws ProductException {
		List<Product> list=new ArrayList<>();
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("select * from product where price BETWEEN ? AND ? order By price "+order);
			ps.setInt(1, min);
			ps.setInt(2, max);
		//	ps.setString(3, order);
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

	@Override
	public String logIn(Integer userId, String password) throws CustomerException {
		String res="";
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("select * from customer where userId = ? and password=?");
			ps.setInt(1, userId);
			ps.setString(2, password);
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				do {
					String n=rs.getString("name");
					res="Welcome to my restaurent : "+n;
				} while (rs.next());
			} else {
				throw new CustomerException("Inviled user Id or password .");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return res;
	}

	@Override
	public String addMoney(int userid, int rs) throws CustomerException {
		String res="";
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("update customer set amount=amount+? where userId = ?");
			ps.setInt(2,userid);
			ps.setInt(1, rs);
			int x= ps.executeUpdate();
			
			if(x>0) {
				res="Amount added.";
			} else {
				throw new CustomerException("Inviled customer Id .");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return res;
	}

	@Override
	public String orderItem(int pId, int userId,int quantity) throws ProductException, CustomerException {
		String res=null;
		try(Connection conn=DBUtil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("select * from product where pId=?");
			ps.setInt(1,pId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				do {
				//	String n=rs.getString("pName");
					int qnt=rs.getInt("quantity");
					double price=rs.getInt("price");
					double total=qnt*price;
					PreparedStatement ps2=conn.prepareStatement("select amount from customer where userId=?");
					ps2.setInt(1, userId);
					ResultSet rs2=ps2.executeQuery();
					if(rs2.next()) {
						double amount=rs2.getDouble("amount");
						if(total<amount) {
							PreparedStatement ps3=conn.prepareStatement("insert into customer_product(pId,userId) values(?,?)");
							ps3.setInt(1, pId);
							ps3.setInt(2, userId);
							PreparedStatement ps4=conn.prepareStatement("update customer set amount=amount - ? where userId=?");
							ps4.setDouble(1, amount);
							ps4.setInt(2, userId);
							ps3.executeUpdate();
							ps4.executeUpdate();
							res="Ordered";
							
						}else {
							throw new CustomerException("Insufisient balance.");
						}
					}else {
						throw new CustomerException("Inviled user id.");
					}
					
				} while (rs.next());
			}else
				throw new ProductException("Inviled product id");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		return res;
	}

	@Override
	public List<Product> myCart(int userId) throws ProductException {
		// TODO Auto-generated method stub
		return null;
	}

}
