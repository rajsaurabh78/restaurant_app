package com.useCase;

import java.util.Scanner;

import com.Dao.AdminDao;
import com.Dao.AdminDaoImpl;
import com.Exception.CustomerException;

public class DeleteCustomer {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true) {
	        try {
	            System.out.print("Enter user Id to delete customer: ");
	            int id = sc.nextInt();
	            AdminDao dao=new AdminDaoImpl();
				try {
					String res=dao.deleteCustomer(id);
					System.out.println(res);
					System.out.println();
				} catch (CustomerException e) {
					System.out.println(e.getMessage());
				}

	            
	        } catch (java.util.InputMismatchException e) {
	            System.out.println("Oops! That's not an integer.");
	            System.out.println();
	        }
			System.out.println("Do you want to Delete more customer?(Y/N)");
			String res2=sc.next();
			if(res2.equalsIgnoreCase("n")) {
				System.out.println("Thanks for Using this System.");
				break;
			}
		}
	}
}
