package com.useCase;

import java.util.Scanner;

import com.Dao.AdminDao;
import com.Dao.AdminDaoImpl;
import com.Dao.CustomerDao;
import com.Dao.CustomerDaoImpl;
import com.Exception.AdminException;
import com.Exception.CustomerException;
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
				System.out.println("Thanks for using my system.");
				break;
			}
		
		}
		sc.close();
	}

}
