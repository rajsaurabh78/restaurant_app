package com.useCase;

import java.util.Scanner;

import com.Dao.AdminDao;
import com.Dao.AdminDaoImpl;
import com.Exception.AdminException;
import com.modal.Admin;

public class UpdateAdmin {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("Enter following Details to update admin .");
			System.out.print("Enter admin id : ");
			int id=sc.nextInt();
			System.out.print("Enter name : ");
			String n=sc.next();
			System.out.print("Enter email : ");
			String e=sc.next();
			System.out.print("Enter mobile no. : ");
			String m=sc.next();
			System.out.print("Enter Password : ");
			String p=sc.next();
			System.out.print("Enter address : ");
			String a=sc.next();
			System.out.print("Enter pinCode : ");
			String pin=sc.next();
			
			AdminDao dao=new AdminDaoImpl();
			Admin cus=new Admin();
			cus.setAdminId(id);
			cus.setAddress(a);
			cus.setEmail(e);
			cus.setMobile(m);
			cus.setName(n);
			cus.setPassword(p);
			cus.setPinCode(pin);
			
			try {
				String str=dao.updateAdmin(cus);
				System.out.println(str);
			} catch (AdminException e1) {
				System.out.println(e1.getMessage());
			}
			System.out.println("Do you to to update more admin ?(y/n)");
			String res=sc.next();
			if(res.equalsIgnoreCase("n")) {
				System.out.println("Thanks for using my system.");
				break;
			}
		
		}

	}

}
