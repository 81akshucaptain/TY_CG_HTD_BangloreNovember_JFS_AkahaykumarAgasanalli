package com.capgemini.foresterymanagement.application;

import java.util.Scanner;

import com.capgemini.foresterymanagement.dao.CustomerDAO;
import com.capgemini.foresterymanagement.dao.CustomerDAOImpl;

public class FmHome {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		CustomerDAO dao=new CustomerDAOImpl();

		System.out.println("                            :::WELCOME TO FORESTER MANAGEMENT PORTAL::::");
		
		while(true) {
			System.out.println("1.Admin ");
			System.out.println("2.Customer");
			System.out.println("2.Schedular");

			int choice=sc.nextInt();
			switch (choice) {
			case 1:
				AdminApplication.adminMain(null);
				break;

			case 2:
				System.out.println("                            :::CUSTOMER LOGIN::::");
				System.out.println("Enter your UniqueCstomerID:");
				int cid=sc.nextInt();
				System.out.println("Enter your emailId:");
				String email=sc.next();
				boolean log=dao.customerLogin(cid, email);
				if(log==true) {
					FmApllication2.contract();
				}else {
					System.err.println("Wrong credentials...!");
				}
				break;
			
			case 3:
				SchedularApplication.schedularMain();
				
			default:System.err.println("Enter the valid choice..!");
			break;
			}
		}
	}
}
