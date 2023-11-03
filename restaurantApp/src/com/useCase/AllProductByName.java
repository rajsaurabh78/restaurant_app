package com.useCase;

import java.util.List;
import java.util.Scanner;

import com.Dao.CustomerDao;
import com.Dao.CustomerDaoImpl;
import com.Exception.ProductException;
import com.Main.Main;
import com.modal.Product;

public class AllProductByName {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.print("Enter name to get products : ");
			String name=sc.next();
			
			CustomerDao dao=new CustomerDaoImpl();
			try {
				List<Product> list=dao.getProductByName(name);
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
			System.out.println("Do you want to search more products by name?(y/n)");
			String res=sc.next();
			if(res.equalsIgnoreCase("n")) {
				break;
			}
		}
		System.out.println("Press keys according to your choice. ");
		System.out.println(" ________________________________");
		System.out.println("|                                |");
		System.out.println("|  Press 1 for back.             | ");
		System.out.println("|  Press other key for Exit app. | ");
		System.out.println("|________________________________|");
		System.out.println();
		if(sc.hasNextInt()) {
			int x=sc.nextInt();
			if(x==1) {
				Main.customerMethod();;
			}else
				System.out.println("Thanks for using my system.");
		}else
			System.out.println("Thanks for using my system.");
		sc.close();
	}

}
