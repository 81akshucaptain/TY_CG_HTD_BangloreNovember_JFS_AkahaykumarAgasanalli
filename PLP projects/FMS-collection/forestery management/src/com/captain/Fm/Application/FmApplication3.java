package com.captain.Fm.Application;
import com.captain.Fm.*;

import com.captain.Fm.DAO.*;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.captain.Fm.Factory.ForestFactory;
import com.captain.Fm.bean.ProductBean;

public class FmApplication3 {
	public void product() {

		ProductDAO cdao=ForestFactory.insatnceOfProductDAOImpl();
		Scanner sc=new Scanner(System.in);
		while (true) {
			System.out.println("*******************WELCOME TO PRODUCT HOUSE*******************");
			System.out.println("*Enter 1 to add the Product");
			System.out.println("*Enter 2 to search the Product");
			System.out.println("*Enter 3 to update the Product");
			System.out.println("*Enter 4 to remove the Product");
			System.out.println("*Enter 5 to get all the Product");
			System.out.println("*Enter 6 to return HOME");

			int option=sc.nextInt();


			switch (option) {
			case 1:
				ProductBean cb3=new ProductBean();

				//				boolean stay5=true;
				//				while(stay5) {
				//					System.out.println("Enter Product Name: ");
				//					String name=sc.next();
				//					String name1=name.toString();
				//					String nameregex = "^[0-9]*";
				//					Pattern namepattern = Pattern.compile(nameregex);
				//					Matcher namematcher = namepattern.matcher(name1);
				//					if( namematcher.matches()) {
				//						cb3.setName(name);
				//						stay5=false;
				//					}else {
				//						System.err.println("please Enter the VALID Name..!");
				//						stay5=true;
				//					}
				//				} 	

				boolean stay1=true;
				while(stay1) {
					System.out.println("Enter Product Name: ");
					String name=sc.next();
					String nameregex = "^[A-Za-z]*";
					Pattern namepattern = Pattern.compile(nameregex);
					Matcher namematcher = namepattern.matcher(name);
					if( namematcher.matches()) {
						cb3.setName(name);
						stay1=false;
					}else {
						System.err.println("please Enter the VALID NAME..!");
						stay1=true;
					}
				} 				

				boolean stay3=true;
				while(stay3) {
					System.out.println("Enter Quantity of Product: ");
					Integer quantity=sc.nextInt();
					String quantity1=quantity.toString();
					String nameregex = "^[0-9]*";
					Pattern namepattern = Pattern.compile(nameregex);
					Matcher namematcher = namepattern.matcher(quantity1);
					if( namematcher.matches()) {
						cb3.setQuantity(quantity);
						stay3=false;
					}else {
						System.err.println("please Enter the VALID Quantity (An Integer)..!");
						stay3=true;
					}
				} 				


				boolean stay2=true;
				while(stay2) {
					System.out.println("Enter Product Class(A/B/C/D/E): ");
					String pclass=sc.next();
					String nameregex = "^[A-Z]{1}$";
					Pattern namepattern = Pattern.compile(nameregex);
					Matcher namematcher = namepattern.matcher(pclass);
					if( namematcher.matches()) {
						cb3.setProductClass(pclass);
						stay2=false;
					}else {
						System.err.println("please Enter the VALID Class..!");
						stay2=true;
					}
				} 

				boolean stay4=true;
				while(stay4) {
					System.out.println("Enter Product Cost: ");
					Integer cost=sc.nextInt();
					String cost1=cost.toString();
					String nameregex = "^[0-9]*";
					Pattern namepattern = Pattern.compile(nameregex);
					Matcher namematcher = namepattern.matcher(cost1);
					if( namematcher.matches()) {
						cb3.setCost(cost);
						stay4=false;
					}else {
						System.err.println("please Enter the VALID Cost (An Integer)..!");
						stay4=true;
					}
				} 

				boolean isAdded=cdao.addProduct(cb3);
				if(isAdded) {
					System.out.println("Done with Addition of product");
				}else {
					System.err.println("Problem with Addition, try again..!");
				}
				break;


			case 2:
				try{
					System.out.println("enter the ProductID to search Product: ");
					int pid=sc.nextInt();
					ProductBean product= cdao.searchProduct(pid);
					if(product!=null) {
						System.out.println(product);
					}else {
						System.err.println("There is Product with mentioned ID");
					}
				}catch (Exception e) {
					System.out.println("Please enter the vallid input");
				}
				break;
			case 3:
				ProductBean cb4=new ProductBean();
				boolean stay6=true;
				while(stay6) {
					System.out.println("Enter Product CID To Update: ");
					Integer pid2=sc.nextInt();
					String pid3=pid2.toString();
					String nameregex = "^[0-9]*";
					Pattern namepattern = Pattern.compile(nameregex);
					Matcher namematcher = namepattern.matcher(pid3);
					if( namematcher.matches()) {
						cb4.setPid(pid2);
						stay6=false;
					}else {
						System.err.println("please Enter the VALID PID To Update (An Integer..!");
						stay6=true;
					}
				} 	

				boolean stay7=true;
				while(stay7) {
					System.out.println("Enter Product Name To Update: ");
					String name3=sc.next();
					String nameregex = "^[A-Za-z]*";
					Pattern namepattern = Pattern.compile(nameregex);
					Matcher namematcher = namepattern.matcher(name3);
					if( namematcher.matches()) {
						cb4.setName(name3);
						stay7=false;
					}else {
						System.err.println("please Enter the VALID NAME To Update..!");
						stay7=true;
					}
				} 				

				boolean stay8=true;
				while(stay8) {
					System.out.println("Enter Quantity of Product To Update: ");
					Integer quantity2=sc.nextInt();
					String quantity1=quantity2.toString();
					String nameregex = "^[0-9]*";
					Pattern namepattern = Pattern.compile(nameregex);
					Matcher namematcher = namepattern.matcher(quantity1);
					if( namematcher.matches()) {
						cb4.setQuantity(quantity2);
						stay8=false;
					}else {
						System.err.println("please Enter the VALID Quantity To Update (An Integer)..!");
						stay8=true;
					}
				} 				


				boolean stay9=true;
				while(stay9) {
					System.out.println("Enter Product Class(A/B/C/D/E) To Update: ");
					String class2=sc.next();
					String nameregex = "^[A-Z]{1}$";
					Pattern namepattern = Pattern.compile(nameregex);
					Matcher namematcher = namepattern.matcher(class2);
					if( namematcher.matches()) {
						cb4.setProductClass(class2);
						stay9=false;
					}else {
						System.err.println("please Enter the VALID Class To Update..!");
						stay9=true;
					}
				} 

				boolean stay10=true;
				while(stay10) {
					System.out.println("Enter Product COST To Update: ");
					Integer cost2=sc.nextInt();
					String cost1=cost2.toString();
					String nameregex = "^[0-9]*";
					Pattern namepattern = Pattern.compile(nameregex);
					Matcher namematcher = namepattern.matcher(cost1);
					if( namematcher.matches()) {
						cb4.setCost(cost2);
						stay10=false;
					}else {
						System.err.println("please Enter the VALID Cost To Update (An Integer)..!");
						stay10=true;
					}
				} 

				boolean isUpdated=cdao.updateProduct(cb4.getPid(),cb4);
				if(isUpdated==true) {
					System.out.println("Product updated successfully..!");
				}else {
					System.err.println("There is problem in updation, try again..!");
				}
				break;
			case 4:
				System.out.println("Enter The Product ID to delete the account:");
				try {
					int pidToDelete=sc.nextInt();
					boolean isDeleted=cdao.deleteProduct(pidToDelete);
					if(isDeleted) {
						System.out.println("The product with PRODUCT-ID: "+pidToDelete+" deleted successfully");
					}else {
						System.err.println("Product-ID not found..!");
					}
				}catch (Exception e) {
					System.err.println("Please enter the valid input..!");
				}
				break;
			case 5:
				cdao.getAllProduct();
				break;
			case 6:
				AdminHomeApllication.adminHome();

			}
		}
	}
}