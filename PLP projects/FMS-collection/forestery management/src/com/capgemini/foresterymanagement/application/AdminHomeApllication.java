package com.capgemini.foresterymanagement.application;

import java.util.Scanner;

import com.capgemini.foresterymanagement.dao.ContractorDAO;
import com.capgemini.foresterymanagement.dao.ContractorDAOImpl;

public class AdminHomeApllication {
	static void adminHome() {
		Scanner sc=new Scanner(System.in);
		ContractorDAO dao=new ContractorDAOImpl();
		while(true) {
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^WELCOME TO FORESTERY MANAGMENT^^^^^^^^^^^^^^^^^^^^^^^^");
			System.out.println("                            ::::ADMIN HOME::::");
			System.out.println("1.To Operate Cutomers ");
			System.out.println("2.To Operate Products ");
			System.out.println("3.To Operate Lands ");
			System.out.println("4.To view Contracts ");
			System.out.println("5.Logout ");

			int options=sc.nextInt();
			switch (options) {
			case 1:
				FmApplication1.customer();
				break;

			case 2:
				FmApplication3 f3=new FmApplication3();
				f3.product();
				break;
				
			case 3:
				FmApllication4.land();
				
			case 4:
				try{
					dao.getAllContarctor();
				}catch (Exception e) {
					System.err.println("Currently there is problem with Contrcats..!");
				}
				break;
				
			case 5: 
				FmHome.main(null);
				break;
				
			default:
				break;
			}
		}
	}
}