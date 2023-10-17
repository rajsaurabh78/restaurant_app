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
		System.out.println("Enter amount");
		Double am=sc.nextDouble();
		
		CustomerDao dao=new CustomerDaoImpl();
		Customer cus=new Customer();
		cus.setAddress(a);
		cus.setAmount(am);
		cus.setEmail(e);
		cus.setMobile(m);
		cus.setName(n);
		cus.setPassword(p);
		cus.setPinCode(pin);
		try {
			String res=dao.registerCustomer(cus);
			System.out.println(res);
		} catch (CustomerException e1) {
			System.out.println(e1.getMessage());
		}

	}

}
