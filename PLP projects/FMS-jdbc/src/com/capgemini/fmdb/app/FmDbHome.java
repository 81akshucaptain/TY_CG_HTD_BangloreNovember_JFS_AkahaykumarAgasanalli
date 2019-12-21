package com.capgemini.fmdb.app;

import java.util.Scanner;


public class FmDbHome {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		System.out.println("---------------------WELCOME TO FORESTERY MANAGMENT----------------------");
		System.out.println("::::HOME::::");
		System.out.println("Enter Options To Move Forward");
		System.out.println("1.To Operate Cutomers ");
		System.out.println("2.To  Operate Contractors ");
		System.out.println("3.To Operate Products ");
		int options=sc.nextInt();
		switch (options) {
		case 1:
			CustomerApplication f1=new CustomerApplication();
			f1.customer();
			break;

		case 2:
			ProductApllication f2=new ProductApllication();
			f2.product();
			break;

		case 3:
			/*FmApplication3 f3=new FmApplication3();
	f3.product();*/
		default:
			break;
		}
	}
}

