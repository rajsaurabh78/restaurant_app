package com.useCase;

import java.util.List;
import java.util.Scanner;

import com.Dao.CustomerDao;
import com.Dao.CustomerDaoImpl;
import com.Exception.ProductException;
import com.modal.Product;

public class AllProductByPriceRange {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("Enter following details to get products : ");
			System.out.print("Enter min price : ");
			int min=sc.nextInt();
			System.out.print("Enter max price : ");
			int max=sc.nextInt();
			System.out.print("Enter sorting order (asc/desc) : ");
			String order=sc.next();
			
			CustomerDao dao=new CustomerDaoImpl();
			try {
				List<Product> list=dao.getProductByPrice(min, max, order);
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
			System.out.println("Do you want to search more products by price ?(y/n)");
			String res=sc.next();
			if(res.equalsIgnoreCase("n")) {
				System.out.println("Thanks for using my system.");
				break;
			}
		}
	}

}
