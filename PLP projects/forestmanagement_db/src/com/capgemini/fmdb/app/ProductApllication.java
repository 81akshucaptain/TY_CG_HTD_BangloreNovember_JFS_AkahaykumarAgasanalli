package com.capgemini.fmdb.app;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.fmbd.dao.ProductDAO;
import com.capgemini.fmdb.bean.ProductBean;
import com.capgemini.fmdb.factory.ForestFactoryFmDb;

public class ProductApllication {
	void product(){
		ProductDAO dao=ForestFactoryFmDb.createInstanceOfProductDAOImpl();
		Scanner sc=new Scanner(System.in);
		while (true) {
			System.out.println("*******************WELCOME TO PRODUCT HOUSE*********************");
			System.out.println("*Enter 1 to add the Product");
			System.out.println("*Enter 2 to search the Product");
			System.out.println("*Enter 3 to update the Product");

			System.out.println("*Enter 4 to delete the Product");
			System.out.println("*Enter 5 to get all the Product");
			System.out.println("*Enter 6 to Retur HOME");
			int option=sc.nextInt();

			switch (option) {

			case 1:
				ProductBean cb1=new ProductBean();

				boolean stay=true;
				while(stay) {

					System.out.println("Enter Product ID: ");
					try
					{
						int pid=sc.nextInt();
						cb1.setPID(pid);
						stay=false;
					}
					catch (Exception e) {
						String msg1=e.getMessage();
						System.err.println(msg1+"please Enter the INTEGER value..!");
						stay=true;
					}
				} 

				boolean stay1=true;
				while(stay1) {
					System.out.println("Enter Product Name: ");
					String pname=sc.next();
					String nameregex = "^[A-Za-z]*";
					Pattern namepattern = Pattern.compile(nameregex);
					Matcher namematcher = namepattern.matcher(pname);
					if( namematcher.matches()) {
						cb1.setName(pname);
						stay1=false;
					}else {
						System.err.println("please Enter the VALID NAME..!");
						stay1=true;
					}
				} 

				boolean stay2=true;
				while(stay2) 
				{
					System.out.println("Enter Product Class(A-Z): ");
					String productClass=sc.next();
					String productClassgex = "^[A-Z]{1}$";
					Pattern productPattern = Pattern.compile(productClassgex);
					Matcher productMatcher = productPattern.matcher(productClass);
					if( productMatcher.matches()) {

						cb1.setProductClass(productClass);
						stay2=false;
					}else {
						System.err.println("please Enter the VALID PRODCUT CLASS NAME..!");
						stay2=true;
					}
				}

				boolean stay3=true;
				while(stay3) {
					System.out.println("Enter Product Quantity: ");
					int quantity=sc.nextInt();
					String quantity1=Integer.toString(quantity);
					String quantityregex = "^[0-9]*";
					Pattern quantitypattern = Pattern.compile(quantityregex);
					Matcher quantitymatcher = quantitypattern.matcher(quantity1);
					if( quantitymatcher.matches()) {

						cb1.setQantity(quantity);
						stay3=false;
					}else {
						System.err.println("please Enter the VALID QUANTITY..!");
						stay3=true;
					}
				}

				boolean stay5=true;
				while(stay5) {
					System.out.println("Enter Product Cost: ");
					Integer cost=sc.nextInt();
					String product1=cost.toString();
					String productregex = "^[0-9]*";
					Pattern productpattern = Pattern.compile(productregex);
					Matcher phonematcher = productpattern.matcher(product1);
					if( phonematcher.matches()) {

						cb1.setCost(cost);
						stay5=false;
					}else {
						System.err.println("please Enter the VALID COST..!");
						stay5=true;
					}
				}

				if(dao.addProduct(cb1)) {
					System.out.println("GOOD DAY");
				}else System.err.println("somthing went wrong buddy, try again..!");
				break;

			case 2:
				System.out.println("enter the Product ID to search Product: ");
				int pidToUpdate=sc.nextInt();
				ProductBean prBean=dao.searchProduct(pidToUpdate);
				System.out.println(prBean);
				break;

			case 3: 
				ProductBean cb2=new ProductBean();
				boolean stay10=true;
				while(stay10) {

					System.out.println("Enter Product ID to Update: ");
					try
					{
						int pid=sc.nextInt();
						cb2.setPID(pid);
						stay10=false;
					}
					catch (Exception e) {
						String msg1=e.getMessage();
						System.err.println(msg1+"please Enter the INTEGER value..!");
						stay10=true;
					}
				} 

				boolean stay11=true;
				while(stay11) {
					System.out.println("Enter Product Name to Update: ");
					String pname=sc.next();
					String nameregex = "^[A-Za-z]*";
					Pattern namepattern = Pattern.compile(nameregex);
					Matcher namematcher = namepattern.matcher(pname);
					if( namematcher.matches()) {
						cb2.setName(pname);
						stay11=false;
					}else {
						System.err.println("please Enter the VALID NAME..!");
						stay11=true;
					}
				} 

				boolean stay12=true;
				while(stay12) 
				{
					System.out.println("Enter Product Class(A-Z) to Update: ");
					String productClass=sc.next();
					String productClassgex = "^[A-Z]{1}$";
					Pattern productPattern = Pattern.compile(productClassgex);
					Matcher productMatcher = productPattern.matcher(productClass);
					if( productMatcher.matches()) {

						cb2.setProductClass(productClass);
						stay12=false;
					}else {
						System.err.println("please Enter the VALID PRODCUT CLASS NAME..!");
						stay12=true;
					}
				}

				boolean stay13=true;
				while(stay13) {
					System.out.println("Enter Product Quantity to Update: ");
					int quantity=sc.nextInt();
					String quantity1=Integer.toString(quantity);
					String quantityregex = "^[0-9]*";
					Pattern quantitypattern = Pattern.compile(quantityregex);
					Matcher quantitymatcher = quantitypattern.matcher(quantity1);
					if( quantitymatcher.matches()) {

						cb2.setQantity(quantity);
						stay13=false;
					}else {
						System.err.println("please Enter the VALID QUANTITY..!");
						stay13=true;
					}
				}

				boolean stay15=true;
				while(stay15) {
					System.out.println("Enter Product Cost to Update: ");
					Integer cost=sc.nextInt();
					String product1=cost.toString();
					String productregex = "^[0-9]*";
					Pattern productpattern = Pattern.compile(productregex);
					Matcher phonematcher = productpattern.matcher(product1);
					if( phonematcher.matches()) {

						cb2.setCost(cost);
						stay15=false;
					}else {
						System.err.println("please Enter the VALID COST..!");
						stay15=true;
					}
				}

				if(dao.updateProduct(cb2)) {
					System.out.println("GOOD DAY, DETAILS UPDATED");
				}else System.err.println("somthing went wrong buddy, try again..!");
				break;

			case 4:
				System.out.println("enter the Product ID to Delete Product: ");
				int pidToDelete=sc.nextInt();
				dao.deleteProduct(pidToDelete);
				break;
			case 5:
				dao.getAllProduct();
				break;
			case 6:
				AdminApp admin=new AdminApp();
				admin.adminMain();
				break;
			}


		}
	}
}
