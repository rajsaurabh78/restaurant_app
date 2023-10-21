package com.useCase;

import java.util.Scanner;

import com.Dao.AdminDao;
import com.Dao.AdminDaoImpl;
import com.Exception.AdminException;
import com.Exception.CustomerException;

public class DeleteAdmin {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.print("Enter admin Id to delete admin : ");
			if (sc.hasNextInt()) {
	            int id = sc.nextInt();
	            AdminDao dao=new AdminDaoImpl();
	            try {
					String res=dao.deleteAdmin(id);
					System.out.println(res);
					
				} catch (AdminException e) {
					System.out.println(e.getMessage());
				}
	        System.out.println("Do you want to Delete more admin?(Y/N)");
			String res2=sc.next();
			if(res2.equalsIgnoreCase("n")) {
				System.out.println("Thanks for Using this System.");
				break;
			}
	        } else {
	            System.out.println("Oops! That's not an integer.");
	            continue;
	        }
		}
	}
}
