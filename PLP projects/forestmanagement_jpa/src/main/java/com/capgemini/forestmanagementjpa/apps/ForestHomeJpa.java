package com.capgemini.forestmanagementjpa.apps;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.forestmanagementjpa.dao.CustomerDAO;
import com.capgemini.forestmanagementjpa.exceptions.CustomerAppException;
import com.capgemini.forestmanagementjpa.factory.ForestFactoryFmJpa;
import com.capgemini.forestmanagementjpa.validations.Validations;

public class ForestHomeJpa {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		CustomerDAO dao = ForestFactoryFmJpa.createInstanceOfCustomerDAOImpl();

		System.out.println("                               :::WELCOME TO FORESTER MANAGEMENT PORTAL::::");

		while (true) {
			try {
				System.out.println("1.Admin ");
				System.out.println("2.Customer");
				System.out.println("3.Schedular");
				String choice1 = scanner.next();
				if (Validations.numberValidation(choice1)) {
					int choice2 = Integer.parseInt(choice1);

					switch (choice2) {
					case 1:
						String userName = "admin";
						String password = "admin@Ak123";
						System.out.println("                            :::ADMIN LOGIN::::");
						System.out.println("Enter your userName:");
						String uname = scanner.next();
						System.out.println("Enter your password:");
						String psw = scanner.next();
						if ((uname.equals(userName)) && (psw.equals(password))) {
							AdminApp admin = new AdminApp();
							admin.adminMain();
						} else {
							System.err.println("OOPS..! Wrong credentials...try again!");
						}
						break;

					case 2:

						try {
							int costumerID2 = 0;
							System.out.println("                            :::CUSTOMER LOGIN::::");
							System.out.println("Enter your Unique CustomerID:");
							String costumerID = scanner.next();
							if (Validations.numberValidation(costumerID)) {
								costumerID2 = Integer.parseInt(costumerID);

								System.out.println("Enter your Password:");
								String userPassword = scanner.next();

								boolean log = dao.customerlogin(costumerID2, userPassword);

								if (log == true) {
									ContractorApplication cApplication = new ContractorApplication();
									cApplication.contractor(costumerID2);
								} else {
									System.err.println("Wrong credentials...!");
								}
							} else {
								throw new CustomerAppException(
										"please Enter valid input (An Integer and must be greater than Zero !");
							}

						} catch (Exception e) {
							String message = e.getMessage();
							System.out.println(message);
						}
						break;

					case 3:

						String userName2 = "sdlr";
						String password2 = "sdlr@Ak123";
						System.out.println("                            :::SCHEDULAR LOGIN::::");
						System.out.println("Enter your userId:");
						String uname2 = scanner.next();
						System.out.println("Enter your password:");
						String psw2 = scanner.next();
						if ((uname2.equals(userName2)) && (psw2.equals(password2))) {
							SchedularApp sched = new SchedularApp();
							sched.schedularHome();
						} else {
							System.err.println("OOPS..! Wrong credentials...try again!");
						}
						break;

					default:
						System.err.println("Enter the valid choice..!");
						break;
					}
				} else {
					System.err.println("Please enter the valid choice, in terms of Digit..!");
				}
			} catch (Exception e) {
				System.err.println("try again with valid integer..!");
			}
		}

	}
}