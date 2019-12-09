package com.capgemini.jdbc.controller;

import java.util.Scanner;

import com.capgemini.jdbc.bean.UserBean;
import com.capgemini.jdbc.factory.UserFactory;
import com.capgemini.jdbc.services.UserServices;

public class DeleteUser {
	public static void main(String[] args) {
		UserServices services=UserFactory.instanceOfUSerServices();
		UserBean user=new UserBean();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter your USN: ");
		String usn=sc.nextLine();
		System.out.println("enter your password: ");
		String password=sc.nextLine();
		if(services.deleteUser(usn,password)) {
			System.out.println("student deleted successfully");
		}else {
			System.err.println("OOPS..!something went wrong..!");
		}
	}
}
