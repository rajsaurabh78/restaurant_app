package com.useCase;

import java.util.List;

import com.Dao.AdminDao;
import com.Dao.AdminDaoImpl;
import com.Exception.ProductException;
import com.modal.Product;

public class AllProductUseCase {

	public static void main(String[] args) {
		
		AdminDao dao=new AdminDaoImpl();
		try {
			List<Product> list=dao.allProduct();
			list.forEach((s->{
				System.out.println("pId = "+s.getpId());
				System.out.println("Type = "+s.getType());
				System.out.println("Name = "+s.getpName());
				System.out.println("Price = Rs "+s.getPrice());
				System.out.println("Quantity = "+s.getQuantity());
				System.out.println("Mfg Date = "+s.getMfgDate());
				System.out.println("Expiry Date = "+s.getExpiryDate());
				System.out.println("----------------------------------------");
			}));
		} catch (ProductException e) {
			System.out.println(e.getMessage());
		}

	}

}