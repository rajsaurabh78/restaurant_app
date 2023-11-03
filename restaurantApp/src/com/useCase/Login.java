package com.useCase;

import java.text.ParseException;
import java.util.Scanner;

import com.Dao.AdminDao;
import com.Dao.AdminDaoImpl;
import com.Exception.AdminException;
import com.Exception.CustomerException;
import com.Exception.ProductException;
import com.Main.Main;

public class Login {

	public static void main(String[] args) throws ParseException {
		Scanner sc=new Scanner(System.in);
		AdminDao dao=new AdminDaoImpl();
		System.out.print("Enter email to logged in : ");
		String id=sc.next();
		System.out.print("Enter password : ");
		String ps=sc.next();
		try {
			String str=dao.logIn(id, ps);
			System.out.println(str);
			Main.adminMethod();
		} catch (AdminException e) {
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
