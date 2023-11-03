package com.useCase;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import com.Dao.AdminDao;
import com.Dao.AdminDaoImpl;
import com.Exception.ProductException;
import com.Main.Main;
import com.modal.Product;

public class AllProductUseCase {

	public static void main(String[] args) throws ParseException {
		
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
		Scanner sc=new Scanner(System.in);
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
				Main.adminMethod();
			}else
				System.out.println("Thanks for using my system.");
		}else
			System.out.println("Thanks for using my system.");
		sc.close();
	}

}
