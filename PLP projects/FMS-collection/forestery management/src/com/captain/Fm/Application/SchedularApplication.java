package com.captain.Fm.Application;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.captain.Fm.DAO.SchedularDAO;
import com.captain.Fm.DAO.SchedularDAOImpl;
import com.captain.Fm.bean.SchedularBean;

public class SchedularApplication {
	private static final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})";

	public static void schedularMain() {
		SchedularBean scbean= new SchedularBean();
		SchedularDAO sdao=new SchedularDAOImpl();
		Scanner sc=new Scanner(System.in);


		while(true) {
			System.out.println("                            :::WElCOME SCHEDULAR::::");
			System.out.println("1.Enter one to Login");
			System.out.println("2.Enter two to Register");
			int option=sc.nextInt();
			switch (option) {
			case 1:
				System.out.println("                            ::::SCHEDULAR LOGIN::::   ");
				System.out.println("Enter your userName: ");
				String uname=sc.next();
				System.out.println("Enter your password: ");
				String pswd=sc.next();
				boolean login= sdao.schedularLogin(uname, pswd, scbean);
				if(login==true) {
					SchedularHomeApplication.schedularHome();
				}else {
					System.err.println("Invalid UserName or Password To Login..!");
				}
				break;


			case 2:
				System.out.println("                            ::::SCHEDULAR REGISTRATION::::   ");
				boolean stay1=true;
				while(stay1) {
					System.out.println("Enter user name");
					String name=sc.next();
					String nameregex = "^[A-Za-z]*";
					Pattern namepattern = Pattern.compile(nameregex);
					Matcher namematcher = namepattern.matcher(name);
					if( namematcher.matches()) {
						scbean.setUserName(name);
						stay1=false;
					}else {
						System.err.println("please Enter the VALID USER NAME..!");
						stay1=true;
					}
				} 

				boolean stay2=true;
				while(stay2) {
					System.out.println("Enter Password");
					System.out.println("NOTE: (at leat one lowerCase,upperCase,digit,specialSymbol charecter and minimum 6 charecter)");
					String password=sc.next();
					//String passwordgex = "[A-Za-z0-9]*(?=.[!@#\\$%\\^&])";
					Pattern passwordpattern = Pattern.compile(PASSWORD_PATTERN);
					Matcher passwordmatcher = passwordpattern.matcher(password);
					if( passwordmatcher.matches()) {
						System.out.println("Confirm The Password\n");
						String password2=sc.next();
						if(password.equals(password2)) {
							scbean.setPassword(password);
							stay2=false;
						}else {
							System.err.println("Password mismatch, Enter correct password");
						}
					}else {
						System.err.println("Your passwird is Weak..! Enter Strong Password");
						stay2=true;
					}
				} 
				System.out.println("Registered successfully");
				break;
			}

		}
	}
}
