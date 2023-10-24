package com.useCase;

import java.util.Scanner;

import com.Dao.AdminDao;
import com.Dao.AdminDaoImpl;
import com.Exception.ProductException;
import com.modal.Product;

public class GetProductById {

	public static void main(String[] args) {
		
		AdminDao dao=new AdminDaoImpl();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter product Id to get Details : ");
		int id=sc.nextInt();
		
			try {
				Product s=dao.getProductById(id);
				System.out.println("pId = "+s.getpId());
				System.out.println("Type = "+s.getType());
				System.out.println("Name = "+s.getpName());
				System.out.println("Price = Rs "+s.getPrice());
				System.out.println("Quantity = "+s.getQuantity());
				System.out.println("Mfg Date = "+s.getMfgDate());
				System.out.println("Expiry Date = "+s.getExpiryDate());
				System.out.println("----------------------------------------");
			} catch (ProductException e) {
				System.out.println(e.getMessage());
			}



	}

}
