package com.useCase;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.Dao.AdminDao;
import com.Dao.AdminDaoImpl;
import com.Exception.ProductException;
import com.modal.Product;

public class UpdateProduct {

	public static void main(String[] args) throws ParseException {

		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("Enter following Details to update product.");
			System.out.println("Enter product id");
			int id=sc.nextInt();
			System.out.println("Enter product name");
			String n=sc.next();
			System.out.println("Enter product type.");
			String t=sc.next();
			System.out.println("Enter price.");
			double p=sc.nextDouble();
			System.out.println("Enter quantity");
			int q=sc.nextInt();
			System.out.println("Enter mfgDate in (yyyy-MM-dd) format.");
	        String dateStr = sc.next();      
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        java.util.Date utilDate = dateFormat.parse(dateStr);
	        Date mfd = new Date(utilDate.getTime());
	        System.out.println("Enter ExpiryDate in (yyyy-MM-dd) format.");
	        String dateStr2 = sc.next();
	        java.util.Date utilDate2 = dateFormat.parse(dateStr2);
	        Date exp = new Date(utilDate2.getTime());
	   
			AdminDao dao=new AdminDaoImpl();
			Product p2=new Product(id, t, n, p,exp, mfd, q);
			try {
				String res=dao.updateProduct(p2);
				System.out.println(res);
			} catch (ProductException e) {
				System.out.println(e.getMessage());
			}
			
			
			System.out.println("Do you want to add more product?(Y/N)");
			String res2=sc.next();
			if(res2.equalsIgnoreCase("n")) {
				System.out.println("Thanks for using my system.");
				break;
			}
			
		}
	}

}
