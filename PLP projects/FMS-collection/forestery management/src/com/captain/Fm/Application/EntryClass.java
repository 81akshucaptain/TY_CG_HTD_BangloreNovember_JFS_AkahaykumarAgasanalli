package com.captain.Fm.Application;

import java.util.Scanner;

import com.captain.Fm.DAO.CustomerDAO;
import com.captain.Fm.DAO.CustomerDAOImpl;

public class EntryClass {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		CustomerDAO dao=new CustomerDAOImpl();

		System.out.println("                          :::WELCOME TO FORESTER MANAGEMENT PORTAL::::");
		
		while(true) {
			System.out.println("1.Admin ");
			System.out.println("2.Customer");
			int choice=sc.nextInt();
			switch (choice) {
			case 1:
				HomeApplication.main(null);
				break;

			case 2:
				System.out.println("                            :::CUSTOMER LOGIN::::");
				System.out.println("Enter your name:");
				String name=sc.next();
				System.out.println("Enter your email:");
				String email=sc.next();
				boolean log=dao.customerlogin(name, email);
				if(log==true) {
					FmApllication2.contractor();
				}else {
					System.err.println("Wrong credentials...!");
				}
				break;
			default:System.err.println("Enter the valid choice..!");
			break;
			}
		}
	}
}
