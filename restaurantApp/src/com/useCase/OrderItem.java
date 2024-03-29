package com.useCase;

import java.util.Scanner;

import com.Dao.AdminDao;
import com.Dao.AdminDaoImpl;
import com.Dao.CustomerDao;
import com.Dao.CustomerDaoImpl;
import com.Exception.AdminException;
import com.Exception.CustomerException;
import com.Exception.ProductException;
import com.Main.Main;

public class OrderItem {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		CustomerDao dao=new CustomerDaoImpl();
		while(true) {
			System.out.print("Enter product Id : ");
			int pid=sc.nextInt();
			System.out.print("Enter quantity : ");
			int qn=sc.nextInt();
			System.out.print("Enter user id : ");
			int uid=sc.nextInt();
		
				String str;
				try {
					str = dao.orderItem(pid, uid, qn);
					System.out.println(str);
				} catch (ProductException | CustomerException e) {
					System.out.println(e.getMessage());
				}
	        System.out.println("Do you want to buy more product?(Y/N).");
			String res=sc.next();
			if(res.equalsIgnoreCase("n")) {
				break;
			}
	        
		}
		System.out.println("Press keys according to your choice. ");
		System.out.println(" ________________________________");
		System.out.println("|                                |");
		System.out.println("|  Press 1 for back.             | ");
		System.out.println("|  Press other key for Exit. 	 | ");
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
