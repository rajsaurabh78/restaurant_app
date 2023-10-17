package com.useCase;

import java.util.Scanner;

import com.Dao.AdminDao;
import com.Dao.AdminDaoImpl;
import com.Exception.AdminException;
import com.modal.Admin;

public class registerAdmin {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter following Details to register .");
		//sc.wait(2);
		System.out.println("Enter name");
		String n=sc.next();
		System.out.println("Enter email");
		String e=sc.next();
		System.out.println("Enter mobile no.");
		String m=sc.next();
		System.out.println("Enter Password");
		String p=sc.next();
		System.out.println("Enter address");
		String a=sc.next();
		System.out.println("Enter pinCode");
		String pin=sc.next();
		
		AdminDao dao=new AdminDaoImpl();
		Admin cus=new Admin();
		cus.setAddress(a);
		cus.setEmail(e);
		cus.setMobile(m);
		cus.setName(n);
		cus.setPassword(p);
		cus.setPinCode(pin);
		try {
			String res=dao.redisterAdmin(cus);
			System.out.println(res);
		} catch (AdminException e1) {
			e1.getMessage();
		}

	}

}
