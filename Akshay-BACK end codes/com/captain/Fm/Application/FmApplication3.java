package com.captain.Fm.Application;
import com.captain.Fm.*;
import com.captain.Fm.DAO.*;

import java.util.Scanner;

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
				System.out.println("enter the name: ");
				cb3.setName(sc.next());
				System.out.println("enter the quantity: ");
				cb3.setQuantity(sc.nextInt());
				System.out.println("enter the product class: ");
				cb3.setProductClass(sc.next().charAt(0));
				System.out.println("enter the cost: ");
				cb3.setCost(sc.nextInt());
				if(cdao.addProduct(cb3)) {
					System.out.println("product added successfully..!");
				}else System.err.println("somthing went wrong buddy, try again..!");
				break;


			case 2:
				System.out.println("enter the ProductID to search Product: ");
				int pid=sc.nextInt();
				ProductBean pdetails=cdao.searchProduct(pid);
				System.out.println("The details of Product with "+pid+" is:");
				System.out.println(pdetails);
				break;
			case 3:
				ProductBean cb4=new ProductBean();
				System.out.println("enter your PID to update: ");
				int pidToUpdate=sc.nextInt();
				System.out.println("enter your product NAME to update: ");
				cb4.setName(sc.next());
				System.out.println("enter your Product CLASS to update: ");
				cb4.setProductClass(sc.next().charAt(0));
				System.out.println("enter your Product COST to update: ");
				cb4.setCost(sc.nextInt());
				System.out.println("enter your Product Quantity to update: ");
				cb4.setQuantity(sc.nextInt());
				boolean update=cdao.updateProduct(pidToUpdate,cb4);
				if(update==true) {
					System.out.println("New details added successfully..!");
				}else System.err.println("Something went wrong to update..!");
				break;
			case 4:
				System.out.println("Enter The Product ID to delete the account:");
				int pidToDelete=sc.nextInt();
				boolean delete=cdao.deleteProduct(pidToDelete);
				break;
			case 5:
				cdao.getAllProduct();
				break;
			case 6:
				MainApllication m=new MainApllication();
				m.main(null);
			}
		}
	}
}