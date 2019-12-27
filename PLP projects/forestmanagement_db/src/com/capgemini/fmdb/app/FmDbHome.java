package com.capgemini.fmdb.app;

import java.util.Scanner;

import com.capgemini.fmbd.dao.CustomerDAO;
import com.capgemini.fmbd.dao.CustomerDAOImpl;
import com.capgemini.fmdb.factory.ForestFactoryFmDb;


public class FmDbHome {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		CustomerDAO dao=ForestFactoryFmDb.createInstanceOfCustomerDAOImpl();

		System.out.println("                            :::WELCOME TO FORESTER MANAGEMENT PORTAL::::");

		while(true) {
			System.out.println("1.Admin ");
			System.out.println("2.Customer");
			System.out.println("3.Schedular");
			int choice=sc.nextInt();
			switch (choice) {
			case 1:
				String userName="admin";
				String password="admin";
				System.out.println("                            :::ADMIN LOGIN::::");
				System.out.println("Enter your userId:");
				String uname=sc.next();
				System.out.println("Enter your password:");
				String psw=sc.next();
				if((uname.equals(userName))&&(psw.equals(password))) {
					AdminApp admin=new AdminApp();
					admin.adminMain();
				}else {
					System.err.println("OOPS..! Wrong credentials...try again!");
				}
				break;

			case 2:
				System.out.println("                            :::CUSTOMER LOGIN::::");
				System.out.println("Enter your UniqueCstomerID:");
				int cid=sc.nextInt();
				System.out.println("Enter your emailId:");
				String email=sc.next();
				boolean log=dao.customerlogin(cid, email);
				if(log==true) {
					ContractorApplication cApplication=new ContractorApplication();
					cApplication.contractor(cid);
				}else {
					System.err.println("Wrong credentials...!");
				}
				break;

			case 3:

				String userName2="sdlr";
				String password2="sdlr";
				System.out.println("                            :::SCHEDULAR LOGIN::::");
				System.out.println("Enter your userId:");
				String uname2=sc.next();
				System.out.println("Enter your password:");
				String psw2=sc.next();
				if((uname2.equals(userName2))&&(psw2.equals(password2))) {
					SchedularApp sched=new SchedularApp();
					sched.schedularHome();
				}else {
					System.err.println("OOPS..! Wrong credentials...try again!");
				}
				break;


			default:System.err.println("Enter the valid choice..!");
			break;
			}
		}
	}
}

