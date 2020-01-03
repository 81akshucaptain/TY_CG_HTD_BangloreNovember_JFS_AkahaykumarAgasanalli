package com.capgemini.foresterymanagement.application;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.foresterymanagement.bean.AdminBean;
import com.capgemini.foresterymanagement.dao.AdminDAO;
import com.capgemini.foresterymanagement.dao.AdminDAOImpl;

public class AdminApplication {
	private static final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})";

	public static void adminMain() {

		AdminDAO admin=new AdminDAOImpl();
		AdminBean ad=new AdminBean();
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("                            :::WElCOME ADMIN::::");
			
				System.out.println("                            ::::ADMIN LOGIN::::   ");
				System.out.println("Enter your userName: ");
				String uname=sc.next();
				System.out.println("Enter your password: ");
				String pswd=sc.next();
				boolean login= admin.adminLogin(uname, pswd,ad);
				if(login==true) {
					AdminHomeApllication.adminHome();
				}else {
					System.err.println("Invalid UserName or Password To Login..!");
				}
				break;
			}

		}
	}


