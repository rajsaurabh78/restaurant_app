package com.useCase;

import java.util.Scanner;

import com.Dao.AdminDao;
import com.Dao.AdminDaoImpl;
import com.Exception.AdminException;
import com.Exception.CustomerException;
import com.Exception.ProductException;

public class UpdateProductPrice {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		AdminDao dao=new AdminDaoImpl();
		while(true) {
			System.out.print("Enter product Id to update product price : ");
			int id=sc.nextInt();
			System.out.print("Enter new price in Rs : ");
			int rs=sc.nextInt();
			try {
				String str=dao.updatePrice(id, rs);
				System.out.println(str);
			} catch (ProductException e) {
				System.out.println(e.getMessage());
			}
			
	        System.out.println("Do you want to Delete more product?(Y/N)");
			String res=sc.next();
			if(res.equalsIgnoreCase("n")) {
				System.out.println("Thanks for Using this System.");
				break;
			}
	        
		}
	}
}
