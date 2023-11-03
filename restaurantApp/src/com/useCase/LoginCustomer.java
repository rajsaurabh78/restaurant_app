package com.useCase;

import java.util.Scanner;

import com.Dao.CustomerDao;
import com.Dao.CustomerDaoImpl;
import com.Exception.CustomerException;
import com.Main.Main;

public class LoginCustomer {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		CustomerDao dao=new CustomerDaoImpl();
		System.out.print("Enter Email to logged in : ");
		String id=sc.next();
		System.out.print("Enter password : ");
		String ps=sc.next();
		try {
			String str=dao.logIn(id, ps);
			System.out.println(str);
			Main.customerMethod();
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
			System.out.println("Press 1 for try again else press any key to exit.");
			if(sc.hasNextInt()) {
				int x=sc.nextInt();
				if(x==1) {
					System.out.println("Welcome back.");
					main(args);
				}else
					System.out.println("Thanks for using my system.");
			}else
				System.out.println("Thanks for using my system.");
		}
		sc.close();
	}
}
