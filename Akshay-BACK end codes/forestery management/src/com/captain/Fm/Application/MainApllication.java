package com.captain.Fm.Application;

import java.util.Scanner;

import com.captain.Fm.DAO.ContractorDAO;
import com.captain.Fm.DAO.ContractorDAOImpl;

public class MainApllication {
	static void mainApp() {
		Scanner sc=new Scanner(System.in);
		ContractorDAO dao=new ContractorDAOImpl();
		System.out.println("///////////////////////WELCOME TO FORESTERY MANAGMENT\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
		System.out.println("                            ::::HOME::::");
		System.out.println("1.To Operate Cutomers ");
		System.out.println("2.To Operate Products ");
		System.out.println("3.To view Contracts ");
		System.out.println("4.Logout ");

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
			try{
				dao.getAllContarctor();
			}catch (Exception e) {
				System.err.println("Currently there is no Contrcats..!");
			}
			break;
		case 4: 
			EntryClass.main(null);
		default:
			break;
		}
	}
}
