package com.capgemini.forestmnagementdb.app;

import java.util.List;
import java.util.Scanner;

import com.capgemini.forestmnagementdb.bean.ContractorBean;
import com.capgemini.forestmnagementdb.dao.ContractorDAO;
import com.capgemini.forestmnagementdb.dao.ContractorDAOImpl;
import com.capgemini.forestmnagementdb.factory.ForestFactoryJdbc;


public class AdminApp {
	public  void adminMain(){
		Scanner sc=new Scanner(System.in);
		ContractorDAO coDao=ForestFactoryJdbc.createInstanceOfContractorDAOImpl();
		while(true) {
			System.out.println("----------------------------WELCOME TO FORESTERY MANAGMENT--------------------------");
			System.out.println("                                ::::ADMIN HOME::::");
			System.out.println("Enter Options To Move Forward");
			System.out.println("1.Enter one to Operate Cutomers ");
			System.out.println("2.Enter two to Operate Products ");
			System.out.println("3.Enter three to View all Contracts ");
			System.out.println("4.Enter four to add land details");
			System.out.println("5.logout");


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
				List<ContractorBean> contractBeans= coDao.getAllContarctor();
				if(contractBeans!=null) {
					for (ContractorBean contracts : contractBeans) {
						System.out.println(contracts);
					}
				}else {
					System.out.println("Currently No Contracts..!");
				}
				break;


			case 4:
				LandsApplication laApplication=new LandsApplication();
				laApplication.land();
				break;
			case 5: 
				ForestHomeJdbc.main(null);
				break;

			default: System.err.println("Enter the correct value...!");
			break;
			}
		}
	}
}
