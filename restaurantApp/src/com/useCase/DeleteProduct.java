package com.useCase;

import java.util.Scanner;

import com.Dao.AdminDao;
import com.Dao.AdminDaoImpl;
import com.Exception.AdminException;
import com.Exception.CustomerException;
import com.Exception.ProductException;

public class DeleteProduct {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.print("Enter product Id to delete product : ");
			if (sc.hasNextInt()) {
	            int id = sc.nextInt();
	            AdminDao dao=new AdminDaoImpl();
	            try {
					String res=dao.removeProduct(id);
					System.out.println(res);
					
				} catch (ProductException e) {
					System.out.println(e.getMessage());
				}
	        System.out.println("Do you want to Delete more product?(Y/N)");
			String res2=sc.next();
			if(res2.equalsIgnoreCase("n")) {
				System.out.println("Thanks for Using this System.");
				break;
			}
	        } else {
	            System.out.println("Oops! That's not an integer.");
	            main(args);
	        }
		}
	}
}
