package com.useCase;

import java.util.List;
import java.util.Scanner;

import com.Dao.CustomerDao;
import com.Dao.CustomerDaoImpl;
import com.Exception.ProductException;
import com.Main.Main;
import com.modal.Product;

public class MyCartUseCase {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter user Id to get cart details : ");
		int id=sc.nextInt();
		CustomerDao dao=new CustomerDaoImpl();
		try {
			List<Product> list=dao.myCart(id);
			list.forEach((s->{
				System.out.println("pId = "+s.getpId());
				System.out.println("Type = "+s.getType());
				System.out.println("Name = "+s.getpName());
				System.out.println("Price = Rs "+s.getPrice());
				System.out.println("Quantity = "+s.getQuantity());
				System.out.println("Mfg Date = "+s.getMfgDate());
				System.out.println("Expiry Date = "+s.getExpiryDate());
				System.out.println("Total price Rs : "+s.getQuantity()*s.getPrice());
				System.out.println("----------------------------------------");
			}));
		} catch (ProductException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Press keys according to your choice. ");
		System.out.println(" ________________________________");
		System.out.println("|                                |");
		System.out.println("|  Press 1 for back.             | ");
		System.out.println("|  Press 2 for retry.            | ");
		System.out.println("|  Press other key for Exit. 	 | ");
		System.out.println("|________________________________|");
		System.out.println();
		if(sc.hasNextInt()) {
			int x=sc.nextInt();
			if(x==1) {
				Main.customerMethod();;
			}else if(x==2) {
				main(args);
			}
			else
				System.out.println("Thanks for using my system.");
		}else
			System.out.println("Thanks for using my system.");
		sc.close();
	}

}
