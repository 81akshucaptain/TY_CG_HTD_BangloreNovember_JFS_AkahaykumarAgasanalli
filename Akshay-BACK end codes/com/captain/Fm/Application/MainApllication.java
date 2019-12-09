package com.captain.Fm.Application;

import java.util.Scanner;

public class MainApllication {
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
		FmApplication1 f1=new FmApplication1();
		f1.customer();
		break;
		
	case 2:
		FmApllication2 f2=new FmApllication2();
		f2.contractor();
		break;
		
	case 3:
		FmApplication3 f3=new FmApplication3();
		f3.product();
	default:
		break;
	}
	}
}
