package com.useCase;

import java.util.Scanner;

import com.Dao.AdminDao;
import com.Dao.AdminDaoImpl;
import com.Exception.AdminException;
import com.Exception.CustomerException;
import com.Exception.ProductException;

public class Login {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		AdminDao dao=new AdminDaoImpl();
		System.out.print("Enter admin Id to logged in : ");
		int id=sc.nextInt();
		System.out.print("Enter password : ");
		String ps=sc.next();
		try {
			String str=dao.logIn(id, ps);
			System.out.println(str);
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
	}
}
