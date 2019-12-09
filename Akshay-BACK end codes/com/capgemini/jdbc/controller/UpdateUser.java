package com.capgemini.jdbc.controller;

import java.util.Scanner;

import com.capgemini.jdbc.bean.UserBean;
import com.capgemini.jdbc.factory.UserFactory;
import com.capgemini.jdbc.services.UserServices;

public class UpdateUser {
public static void main(String[] args) {
	UserServices services=UserFactory.instanceOfUSerServices();
	UserBean user=new UserBean();
	Scanner sc=new Scanner(System.in);
	System.out.println("enter your uname to update: ");
	String uname=sc.nextLine();
	System.out.println("enter your USN: ");
	String usn=sc.nextLine();
	System.out.println("enter your password: ");
	String password=sc.nextLine();
	if(services.updateUser(uname,usn,password)) {
		System.out.println("student UPDATED successfully");
	}else {
		System.err.println("OOPS..!something went wrong..!");
	}
}
}
