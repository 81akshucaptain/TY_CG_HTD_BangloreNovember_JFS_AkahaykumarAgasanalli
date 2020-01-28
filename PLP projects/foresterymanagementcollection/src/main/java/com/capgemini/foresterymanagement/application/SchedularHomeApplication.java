package com.capgemini.foresterymanagement.application;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.foresterymanagement.bean.ContractorBean;
import com.capgemini.foresterymanagement.bean.ProductBean;
import com.capgemini.foresterymanagement.dao.ContractorDAO;
import com.capgemini.foresterymanagement.dao.ContractorDAOImpl;
import com.capgemini.foresterymanagement.dao.ProductDAO;
import com.capgemini.foresterymanagement.dao.ProductDAOImpl;

public class SchedularHomeApplication {
	public static void schedularHome() {

		Scanner sc=new Scanner(System.in);
		ContractorDAO conDao=new ContractorDAOImpl();
		ProductDAO proDao=new ProductDAOImpl();
		while(true) {
			try {			
				System.out.println("///////////////////////WELCOME TO FORESTERY MANAGMENT\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
				System.out.println("                            ::::SCHEDULAR HOME::::");
				System.out.println("1.View all contracts");
				System.out.println("2.View all prodcts");
				System.out.println("3.Schedule the order ");
				System.out.println("4.Logout ");
				String choice1=sc.next();
				String choice1IDregex = "^[0-9]*$";
				Pattern choice1IDpattern = Pattern.compile(choice1IDregex);
				Matcher choice1IDmatcher = choice1IDpattern.matcher(choice1);
				if( choice1IDmatcher.matches()) {
					int	choice2=Integer.parseInt(choice1);

					switch (choice2) {
					case 1:
						conDao.getAllContarctor();
						break;
					case 2: 
						proDao.getAllProduct();
						break;
					case 3:
						System.out.println("Enter the CONTRACT-ID to Schedule the contract: ");
						int ctid=sc.nextInt();
						ContractorBean coBean = conDao.searchContarctor(ctid);
						System.out.println(coBean);
						//String contractFields=coBean.toString();
						System.out.println("=========================================================");
						System.out.println("Enter the Demanded PRODUCT-ID of for verification and delivery: ");
						int pid=sc.nextInt();
						ProductBean prBean = proDao.searchProduct(pid);
						System.out.println(prBean);
						//String productFields=prBean.toString();

						if(coBean.getQunatity()<prBean.getQuantity()) {
							System.out.println("VERIFICATION DONE WITH PRODUCT STOCKS, DEMANDED PRODUCT \n"
									+ "QUANTITY WILL BE DELIVERED ON DATE: "+coBean.getDeliveryDate()
									+"\n Sending confiramtion mail to customer with CUSTOMER-ID: "+coBean.getCustomerId()+"\n");
						}else {
							System.err.println("REQUESTED CONTRACT FOR PRODUCTS WILL BE DELAYED DUE TO\n "
									+ "INSUFFICIENT STOCKS, DELIVERED AS SOON AS POSIIBLE..");
						}
					case 4: ForestHomeCollections.main(null);
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