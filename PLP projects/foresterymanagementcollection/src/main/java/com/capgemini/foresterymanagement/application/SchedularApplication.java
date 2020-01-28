package com.capgemini.foresterymanagement.application;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.foresterymanagement.bean.SchedularBean;
import com.capgemini.foresterymanagement.dao.SchedularDAO;
import com.capgemini.foresterymanagement.dao.SchedularDAOImpl;

public class SchedularApplication {
	private static final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})";

	public static void schedularMain() {
		SchedularBean scbean= new SchedularBean();
		SchedularDAO sdao=new SchedularDAOImpl();
		Scanner sc=new Scanner(System.in);


		while(true) {
			String userName="sdlr";
			String password="sdlr";
			System.out.println("                            :::WElCOME SCHEDULAR::::");
				System.out.println("                            ::::SCHEDULAR LOGIN::::   ");
				System.out.println("Enter your userName: ");
				String uname=sc.next();
				System.out.println("Enter your password: ");
				String pswd=sc.next();
				if((uname.equals(userName))&&(pswd.equals(password))) {
					SchedularHomeApplication.schedularHome();
				}else {
					System.err.println("Invalid UserName or Password To Login..!");
				}

			}

		}
	}

