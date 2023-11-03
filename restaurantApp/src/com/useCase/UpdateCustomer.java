package com.useCase;

import java.util.Scanner;

import com.Dao.CustomerDao;
import com.Dao.CustomerDaoImpl;
import com.Exception.CustomerException;
import com.Main.Main;
import com.modal.Customer;

public class UpdateCustomer {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter following Details to update Customer .");
		System.out.print("Enter Customer id : ");
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
		System.out.print("Enter amount : ");
		double rs=sc.nextDouble();
		
		CustomerDao dao=new CustomerDaoImpl();
		Customer cus=new Customer();
		cus.setUserId(id);
		cus.setAddress(a);
		cus.setEmail(e);
		cus.setMobile(m);
		cus.setName(n);
		cus.setPassword(p);
		cus.setPinCode(pin);
		cus.setAmount(rs);
		
		try {
			String str=dao.updateCustomer(cus);
			System.out.println(str);
			Main.customerMethod();
		} catch (CustomerException e1) {
			System.out.println(e1.getMessage());
		}
		sc.close();
	}

}
