package com.Main;

import java.text.ParseException;
import java.util.Scanner;

import com.Dao.CustomerDao;
import com.useCase.AddMoney;
import com.useCase.AddProduct;
import com.useCase.AllProductByName;
import com.useCase.AllProductByPriceRange;
import com.useCase.AllProductByType;
import com.useCase.AllProductUseCase;
import com.useCase.AllProductUseCaseCustomer;
import com.useCase.DeleteAdmin;
import com.useCase.DeleteCustomer;
import com.useCase.DeleteProduct;
import com.useCase.GetProductById;
import com.useCase.Login;
import com.useCase.LoginCustomer;
import com.useCase.MyCartUseCase;
import com.useCase.OrderItem;
import com.useCase.UpdateAdmin;
import com.useCase.UpdateCustomer;
import com.useCase.UpdateProduct;
import com.useCase.UpdateProductPrice;
import com.useCase.UpdateProductQuantity;
import com.useCase.registerAdmin;
import com.useCase.registerCustomer;

public class Main {

	public static void main(String[] args) throws ParseException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Press keys according to your choice. ");
		System.out.println(" ________________________________");
		System.out.println("|                                |");
		System.out.println("|  Press 1 for register.         | ");
		System.out.println("|  Press 2 for login customer.   | ");
		System.out.println("|  Press 3 for login admin.      | ");
		System.out.println("|  Press other key for Exit. 	 | ");
		System.out.println("|________________________________|");
		System.out.println();
		if(sc.hasNextInt()) {
			int x=sc.nextInt();
			if(x==1) {
				registerCustomer.main(args);
			}else if(x==2) {
				LoginCustomer.main(args);
			}else if(x==3) {
				Login.main(args);
			}else
				System.out.println("Thanks for using my system.");
		}else
			System.out.println("Thanks for using my system.");
		sc.close();
	}
	
	public static void customerMethod() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println();
		System.out.println("Press keys according to your choice. ");
		System.out.println(" _______________________________________");
		System.out.println("|                                       |");
		System.out.println("|  Press 1 for update yourself.         | ");
		System.out.println("|  Press 2 to see all product.          | ");
		System.out.println("|  Press 3 to search product by name.   | ");
		System.out.println("|  Press 4 to search product by type.   | ");
		System.out.println("|  Press 5 to search product by price.  | ");
		System.out.println("|  Press 6 to order product.            | ");
		System.out.println("|  Press 7 for add money.               | ");
		System.out.println("|  Press 8 show cart.                   | ");
		System.out.println("|  Press any key for Exit.              | ");
		System.out.println("|_______________________________________|");
		System.out.println();
		if(sc.hasNextInt()) {
			int x=sc.nextInt();
			if(x==1) {
				UpdateCustomer.main(null);
			}else if(x==2) {
				AllProductUseCaseCustomer.main(null);
			}else if(x==3) {
				AllProductByName.main(null);
			}else if(x==4) {
				AllProductByType.main(null);
			}else if(x==5) {
				AllProductByPriceRange.main(null);
			}else if(x==6) {
				OrderItem.main(null);
			}else if(x==7) {
				AddMoney.main(null);
			}else if(x==8) {
				MyCartUseCase.main(null);
			}else
				System.out.println("Thanks for using my system.");
		}else
			System.out.println("Thanks for using my system.");
		sc.close();
	}
	
public static void adminMethod() throws ParseException {
		
		Scanner sc=new Scanner(System.in);
		System.out.println();
		System.out.println("Press keys according to your choice. ");
		System.out.println(" _______________________________________");
		System.out.println("|                                       |");
		System.out.println("|  Press 0 to all product.              | ");
		System.out.println("|  Press 1 for register admin.          | ");
		System.out.println("|  Press 2 for update yourself.         | ");
		System.out.println("|  Press 3 to delete admin.             | ");
		System.out.println("|  Press 4 to delete customer.	        | ");
		System.out.println("|  Press 5 to get product by id.        | ");
		System.out.println("|  Press 6 to add Product.              | ");
		System.out.println("|  Press 7 to update product.           | ");
		System.out.println("|  Press 8 to remove product.           | ");
		System.out.println("|  Press 9 for update product quantity. | ");
		System.out.println("|  Press 10 for update product Price.	| ");
		System.out.println("|  Press any key for Exit.              | ");
		System.out.println("|_______________________________________|");
		System.out.println();
		if(sc.hasNextInt()) {
			int x=sc.nextInt();
			if(x==0) {
				AllProductUseCase.main(null);
			}else if(x==1) {
				registerAdmin.main(null);
			}else if(x==2) {
				UpdateAdmin.main(null);
			}else if(x==3) {
				DeleteAdmin.main(null);
			}else if(x==4) {
				DeleteCustomer.main(null);
			}else if(x==5) {
				GetProductById.main(null);
			}else if(x==6) {
				AddProduct.main(null);
			}else if(x==7) {
				UpdateProduct.main(null);
			}else if(x==8) {
				DeleteProduct.main(null);
			}else if(x==9) {
				UpdateProductQuantity.main(null);
			}else if(x==10) {
				UpdateProductPrice.main(null);
			}else
				System.out.println("Thanks for using my system.");
		}else
			System.out.println("Thanks for using my system.");
		sc.close();
	}


}
