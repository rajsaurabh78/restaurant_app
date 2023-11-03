package com.useCase;

import java.util.Scanner;

import com.Dao.CustomerDao;
import com.Dao.CustomerDaoImpl;
import com.Exception.CustomerException;
import com.modal.Customer;

public class registerCustomer {

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
		
		CustomerDao dao=new CustomerDaoImpl();
		Customer cus=new Customer();
		cus.setAddress(a);
		cus.setAmount(0);
		cus.setEmail(e);
		cus.setMobile(m);
		cus.setName(n);
		cus.setPassword(p);
		cus.setPinCode(pin);
		try {
			String res=dao.registerCustomer(cus);
			if(res!= null) {
				System.out.println(res);
				System.out.println();
				System.out.println("You have to login first.");
				System.out.println();
				LoginCustomer.main(args);
			}else {
				main(args);
			}
			
		} catch (CustomerException e1) {
			System.out.println(e1.getMessage());
		}
		
	}

}
