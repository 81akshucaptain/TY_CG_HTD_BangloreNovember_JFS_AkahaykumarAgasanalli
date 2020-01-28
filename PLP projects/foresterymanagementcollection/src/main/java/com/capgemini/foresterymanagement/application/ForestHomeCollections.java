package com.capgemini.foresterymanagement.application;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.foresterymanagement.dao.CustomerDAO;
import com.capgemini.foresterymanagement.dao.CustomerDAOImpl;
import com.capgemini.foresterymanagement.exception.CustomerAppException;

public class ForestHomeCollections {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		CustomerDAO dao=new CustomerDAOImpl();

		System.out.println("                            :::WELCOME TO FORESTER MANAGEMENT PORTAL::::");

		while(true) {
			try {
				System.out.println("1.Admin ");
				System.out.println("2.Customer");
				System.out.println("3.Schedular");

				String choice1=scanner.next();
				String choice1IDregex = "^[0-9]*$";
				Pattern choice1IDpattern = Pattern.compile(choice1IDregex);
				Matcher choice1IDmatcher = choice1IDpattern.matcher(choice1);
				if( choice1IDmatcher.matches()) {
					int	choice2=Integer.parseInt(choice1);

					switch (choice2) {
					case 1:
						AdminApplication.adminMain();
						break;

					case 2:
						try{
							System.out.println("                            :::CUSTOMER LOGIN::::");
							System.out.println("Enter your UniqueCstomerID:");
							int cid=scanner.nextInt();
							System.out.println("Enter your password:");
							String password=scanner.next();
							boolean log=dao.customerLogin(cid, password);
							if(log==true) {
								System.out.println("successfully logged in..!");
								ContractorApp.contract(cid);
							}else {
								System.err.println("Wrong credentials...!");
							}
						}catch (CustomerAppException e) {
							String message=e.getMessage();
							System.err.println(message);
						}
						break;

					case 3:
						SchedularApplication.schedularMain();

					default: System.err.println("Enter the valid choice to move further");
					break;

					}
				}else {
					System.err.println("Please enter the valid choice, in terms of Digit..!");
				}

			}catch (Exception e) {
				System.err.println("try again with valid input..!");
			}

		}
	}
}