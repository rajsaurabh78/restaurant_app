package com.useCase;

import java.util.Scanner;

import com.Dao.AdminDao;
import com.Dao.AdminDaoImpl;
import com.Dao.CustomerDao;
import com.Dao.CustomerDaoImpl;
import com.Exception.AdminException;
import com.Exception.CustomerException;
import com.Main.Main;
import com.modal.Admin;

public class AddMoney {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.print("Enter user id : ");
			int id=sc.nextInt();
			System.out.print("Enter amount : ");
			int rs=sc.nextInt();
			
			CustomerDao dao=new CustomerDaoImpl();
			
			try {
				String str=dao.addMoney(id, rs);
				System.out.println(str);
			} catch (CustomerException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Do you to to add more money ?(y/n)");
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
			}
			else
				System.out.println("Thanks for using my system.");
		}else
			System.out.println("Thanks for using my system.");
		sc.close();
	}

}
