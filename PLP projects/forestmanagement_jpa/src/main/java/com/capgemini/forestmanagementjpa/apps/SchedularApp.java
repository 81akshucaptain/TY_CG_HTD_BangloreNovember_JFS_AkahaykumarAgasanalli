package com.capgemini.forestmanagementjpa.apps;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.forestmanagementjpa.dao.ContractorDAO;
import com.capgemini.forestmanagementjpa.dao.ContractorDAOImpl;
import com.capgemini.forestmanagementjpa.dao.ProductDAO;
import com.capgemini.forestmanagementjpa.dao.ProductDAOImpl;
import com.capgemini.forestmanagementjpa.dto.ContractorBean;
import com.capgemini.forestmanagementjpa.dto.ProductBean;
import com.capgemini.forestmanagementjpa.validations.Validations;

public class SchedularApp {
	public void schedularHome() {

		Scanner sc = new Scanner(System.in);
		ContractorDAO conDao = new ContractorDAOImpl();
		ProductDAO proDao = new ProductDAOImpl();
		while (true) {
			try {
				System.out.println(
						"==========================WELCOME TO FORESTERY MANAGMENT============================");
				System.out.println("                            ::::SCHEDULAR HOME::::");
				System.out.println("1.View all Contracts");
				System.out.println("2.View all Prodcts");
				System.out.println("3.Schedule the Order ");
				System.out.println("4.List Of Scheduled Contracts ");
				System.out.println("5.Logout ");
				String choice1 = sc.next();
				if (Validations.numberValidation(choice1)) {
					int choice2 = Integer.parseInt(choice1);

					switch (choice2) {
					case 1:
						try {
							List<ContractorBean> contractBeans = conDao.getAllContarctor();
							if (contractBeans != null) {
								for (ContractorBean contracts : contractBeans) {
									System.out.println(contracts);
								}
							} else {
								System.out.println("Currently There Are No Contracts..!");
							}
						} catch (Exception e) {
							String message = e.getMessage();
							System.err.println(message);
						}
						break;

					case 2:
						List<ProductBean> productBeans = proDao.getAllProduct();
						if (productBeans != null) {
							System.out.println(":::::PRODUCT DETTAILS::::::");
							for (ProductBean productBean3 : productBeans) {
								System.out.println(productBean3);
							}
						} else {
							System.out.println("Empty Product Inventory, No Data Found..!");
						}
						break;

					case 3:
						System.out.println("Enter The CONTRACT-ID To Schedule The Contract: ");
						int ctid = sc.nextInt();
						ContractorBean coBean = conDao.searchContarctor(ctid);
						if (coBean != null) {
							System.out.println(coBean);
							// String contractFields=coBean.toString();
							System.out.println("=========================================================");
							System.out.println("Enter The Demanded PRODUCT-ID For Inventory Check ");
							int pid = sc.nextInt();
							ProductBean prBean = proDao.searchProduct(pid);
							System.out.println(prBean);
							// String productFields=prBean.toString();

							if (coBean.getQunatity() < prBean.getQuantity()) {
								coBean.setStatus("ordered");
								System.out.println("                   ::::::::STATUS::::::::\n"
										+ "VERIFICATION DONE WITH PRODUCT STOCKS, REQUESTED PRODUCT WITH \n"
										+ "QUANTITY WILL BE DELIVERED ON DATE: " + coBean.getDeliveryDate()
										+ "\n SENDING CONFIRAMTION MAIL TO CUSTOMER WITH CUSTOMER-ID: " + ""
										+ coBean.getCustomerId() + "\n");
							} else {
								System.out.println("                   ::::::::STATUS::::::::\n"
										+ "SENDDING MAIL:REQUESTED CONTRACT FOR PRODUCTS WILL BE DELAYED DUE TO\n "
										+ "INSUFFICIENT STOCKS, WILL NOTIFY YOU AS SOON AS POSSIBLE");
							}
						} else {
							System.out.println("Contract ID Not Exist..!");
						}
						break;
					case 4:
						try {
							List<ContractorBean> contractBeans = conDao.getAllContarctor();
							if (contractBeans != null) {
								boolean isOrder = false;
								for (ContractorBean contracts : contractBeans) {
									if ((contracts.getStatus()).equals("ordered")) {
										System.out.println(contracts);
										isOrder = true;
									}
								}
								if (isOrder == false) {
									System.out.println("No Ordered Contracts");
								}
							} else {
								System.out.println("Currently There Are No Contracts..!");
							}
						} catch (Exception e) {
							String message = e.getMessage();
							System.err.println(message);
						}
						break;
					case 5:
						ForestHomeJpa.main(null);

					default:
						System.err.println("Enter the valid choice to move further");
						break;

					}
				} else {
					System.err.println("Please enter the valid choice, in terms of Digit..!");
				}

			} catch (Exception e) {
				System.err.println("try again with valid input..!");
			}

		}
	}
}
