package com.capgemini.jdbc.controller;

import java.util.Scanner;

import com.capgemini.jdbc.bean.UserBean;
import com.capgemini.jdbc.factory.UserFactory;
import com.capgemini.jdbc.services.UserServices;

public class InsertUser {
	public static void main(String[] args) {
UserServices services=UserFactory.instanceOfUSerServices();
UserBean user=new UserBean();
Scanner sc=new Scanner(System.in);
System.out.println("enter your USN: ");
user.setUsn(sc.nextLine());
System.out.println("enter your age: ");
user.setAge(Integer.parseInt(sc.nextLine()));
System.out.println("enetr your address: ");
user.setAdress(sc.nextLine());
System.out.println("enetr your college: ");
user.setCollege(sc.nextLine());
System.out.println("enetr your name: ");
user.setName(sc.nextLine());
System.out.println("enter your uname: ");
user.setUname(sc.nextLine());
System.out.println("enter your password: ");
user.setPsw(sc.nextLine());
if(services.insertUser(user)) {
	System.out.println("student successfully added");
}else {
	System.err.println("OOPS..!MONU...!something went wrong..!");
}
}
}