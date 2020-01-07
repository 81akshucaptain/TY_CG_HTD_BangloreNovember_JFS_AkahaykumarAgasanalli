package com.capgemini.foresterymanagement.application;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.foresterymanagement.bean.ContractorBean;
import com.capgemini.foresterymanagement.dao.ContractorDAO;
import com.capgemini.foresterymanagement.dao.ContractorDAOImpl;
import com.capgemini.foresterymanagement.factory.ForestFactory;

public class AdminHomeApllication {
	static void adminHome() {
		Scanner sc=new Scanner(System.in);
		ContractorDAO dao=new ContractorDAOImpl();
		while(true) {
			try {			
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^WELCOME TO FORESTERY MANAGMENT^^^^^^^^^^^^^^^^^^^^^^^^");
				System.out.println("                            ::::ADMIN HOME::::");
				System.out.println("1.To Operate Cutomers ");
				System.out.println("2.To Operate Products ");
				System.out.println("3.To Operate Lands ");
				System.out.println("4.To view Contracts ");
				System.out.println("5.Logout ");
				String choice1=sc.next();
				String choice1IDregex = "^[0-9]*$";
				Pattern choice1IDpattern = Pattern.compile(choice1IDregex);
				Matcher choice1IDmatcher = choice1IDpattern.matcher(choice1);
				if( choice1IDmatcher.matches()) {
					int	choice2=Integer.parseInt(choice1);

					switch (choice2) {
					case 1:
						CustomerApp.customer();
						break;

					case 2:
						ProductApp f3=new ProductApp();
						f3.product();
						break;

					case 3:
						LandsApp.land();
						break;

					case 4:
						ContractorDAO contractorDao=ForestFactory.instanceOfContractorDAOImpl();
						HashMap<Integer, ContractorBean> allContracts = contractorDao.getAllContarctor();

						if(allContracts!=null) {
							Set<Integer> keys = allContracts.keySet();
							for (Integer key : keys) {
								ContractorBean conBean = allContracts.get(key);
								System.out.println(conBean);
							}
						}else {
							System.err.println("Currentlly There Are No Contracts..!");
						}
						break;					case 5: 
						ForestHomeCollections.main(null);
						break;

					default: System.err.println("Enter the valid choice to move further");
					break;

					}
				}else {
					System.err.println("Please enter the valid choice, in terms of Digit..!");
				}

			}catch (Exception e) {
				System.err.println("try again with valid input..!");
			}

		}
	}
}