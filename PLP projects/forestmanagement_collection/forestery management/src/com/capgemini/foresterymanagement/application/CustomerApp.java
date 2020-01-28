package com.capgemini.foresterymanagement.application;
import java.util.HashMap;
import java.util.InputMismatchException;


import java.util.Scanner;
import java.util.Set;

import com.capgemini.foresterymanagement.bean.ContractorBean;
import com.capgemini.foresterymanagement.bean.CustomerBean;
import com.capgemini.foresterymanagement.dao.CustomerDAO;
import com.capgemini.foresterymanagement.exception.*;
import com.capgemini.foresterymanagement.factory.ForestFactory;
import com.capgemini.foresterymangement.validation.Validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.ValidationException;

public class CustomerApp {
	public static void customer(){
		CustomerDAO customerDao=ForestFactory.instanceOfCustomerDAOImpl();

		Scanner scanner=new Scanner(System.in);


		while (true) {
			try {
				System.out.println("*******************WELCOME TO CUSTOMER HOUSE*********************");
				System.out.println("*Enter 1 to add the customer");
				System.out.println("*Enter 2 to search the customer");
				System.out.println("*Enter 3 to update the customer");
				System.out.println("*Enter 4 to remove the customer");
				System.out.println("*Enter 5 to get all the customer");
				System.out.println("*Enter 6 to Return HOME");

				String choice1=scanner.next();
				String choice1IDregex = "^[0-9]*$";
				Pattern choice1IDpattern = Pattern.compile(choice1IDregex);
				Matcher choice1IDmatcher = choice1IDpattern.matcher(choice1);
				if( choice1IDmatcher.matches()) {
					int	choice2=Integer.parseInt(choice1);

					switch (choice2) {
					case 1:
						CustomerBean customerBean=new CustomerBean();
						String password;
						boolean stay1=true;
						while(stay1) {
							try {
								System.out.println("Enter customer First Name: ");
								String fname=scanner.next();
								System.out.println("Enter customer middle Name(if not please enter underscore): ");
								String mname=scanner.next();
								System.out.println("Enter customer Last Name: ");
								String lname=scanner.next();
								String fullName=fname+" "+mname+" "+lname;
								if(Validations.fullNameValidation(fullName)) {
									customerBean.setName(fullName);
									stay1=false;
								}
							}catch (VallidationExceptionFMS e) {
								String message=e.getMessage();
								System.err.println(message);
							}	
						} 

						boolean stay2=true;
						while(stay2) 
						{
							try{ 
								System.out.println("Enter customer Town: ");
								String town=scanner.next();
								if(Validations.alphabetsValidation(town)) {
									customerBean.setTown(town);
									stay2=false;
								}
							}catch (VallidationExceptionFMS e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						}

						boolean stay4=true;
						while(stay4) {
							try{
								System.out.println("Enter customer Email: ");
								String email=scanner.next();
								if(Validations.emailValidation(email)) {
									customerBean.setEmail(email);
									stay4=false;
								}
							}catch (VallidationExceptionFMS e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						}

						boolean stay3=true;
						while(stay3) {
							try {
								System.out.println("Enter customer Postal: ");
								String postal=scanner.next();
								if(Validations.postalValidation(postal)) {
									Integer postal2=Integer.parseInt(postal);
									if(postal2>0) {
										customerBean.setPostal(postal2);
										stay3=false;
									}else {
										throw new VallidationExceptionFMS("Please Enter Vallid Number,Must Be More Than Zero");
									}
								}
							}catch (VallidationExceptionFMS e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						}

						boolean stay5=true;
						while(stay5) {
							try{
								System.out.println("Enter customer Phone: ");
								String phone=scanner.next();
								if(Validations.phoneNumberValidation(phone)) {
									Long phone2=Long.parseLong(phone);
									customerBean.setPhone(phone2);
									stay5=false;
								}
							}catch (VallidationExceptionFMS e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						}

						try{
							if(customerDao.addCustomer(customerBean)) {
								System.out.println("Customer Added Successfully with CustomerID: "+customerBean.getCustomerId());
								password=customerBean.getCustomerId()+customerBean.getTown()+"@"+customerBean.getPostal();
								customerBean.setPassword(password);
								System.out.println("Your Password is: "+password+ " Please Record It For Future Usage\n");
							}
						}catch (CustomerAppException e) {
							String message=e.getMessage();
							System.err.println(message);
						}
						break;

					case 2:

						try{
							System.out.println("enter the customer ID to search Customer: ");                 
							String ctidToSearch=scanner.next();
							if(Validations.numberValidation(ctidToSearch)) {
								Integer ctidToSearch2=Integer.parseInt(ctidToSearch);
								CustomerBean cbBean=customerDao.searchCustomer(ctidToSearch2);
								if(cbBean!=null) {
									System.out.println(cbBean);
								}else {
									throw new CustomerAppException("Customer Not found,try again with other ID");
								}
							}
						}catch (CustomerAppException e) {
							String message=e.getMessage();
							System.err.println(message);
						}
						break;

					case 3:
						CustomerBean customerBean2=new CustomerBean();

						boolean stay10=true;
						while(stay10) {
							System.out.println("Enter customer ID to update: ");
							try
							{
								String CostumerID=scanner.next();
								if(Validations.numberValidation(CostumerID)) {
									int customerId2=Integer.parseInt(CostumerID);
									if(customerId2>0) {
										CustomerBean coBean=customerDao.searchCustomer(customerId2);
										if(coBean!=null) {
											//For Automatic Password Updating while Admin Updation
											customerBean2.setPassword(coBean.getPassword());
											customerBean2.setCustomerId(customerId2);
											stay10=false;
										}else {
											try{
												throw new CustomerAppException("There Is No Such Customer_Id..! ");
											}catch (CustomerAppException e) {
												String message=e.getMessage();
												System.err.println(message);
												CustomerApp.customer();
											}
										}
									}else {
										stay10=true;
										throw new VallidationExceptionFMS("please Enter valid CID(greater than Zero)!");
									}
								}
							}
							catch (VallidationExceptionFMS e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						} 

						boolean stay11=true;
						while(stay11) {
							try {
								System.out.println("Enter customer First Name to update: ");
								String fname=scanner.next();
								System.out.println("Enter customer middle Name(if not please enter underscore): ");
								String mname=scanner.next();
								System.out.println("Enter customer Last Name: ");
								String lname=scanner.next();
								String fullName=fname+" "+mname+" "+lname;
								if(Validations.fullNameValidation(fullName)) {
									customerBean2.setName(fullName);
									stay11=false;
								}
							}catch (VallidationExceptionFMS e) {
								String message=e.getMessage();
								System.err.println(message);
							}	
						} 

						boolean stay12=true;
						while(stay12) 
						{
							try{ 
								System.out.println("Enter customer Town to Update: ");
								String town=scanner.next();
								if(Validations.alphabetsValidation(town)) {
									customerBean2.setTown(town);
									stay12=false;
								}
							}catch (VallidationExceptionFMS e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						}

						boolean stay14=true;
						while(stay14) {
							try{
								System.out.println("Enter customer Email to Update: ");
								String email=scanner.next();
								if(Validations.emailValidation(email)) {
									customerBean2.setEmail(email);
									stay14=false;
								}
							}catch (VallidationExceptionFMS e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						}

						boolean stay13=true;
						while(stay13) {
							try {
								System.out.println("Enter customer Postal to Update: ");
								String postal=scanner.next();
								if(Validations.postalValidation(postal)) {
									Integer postal2=Integer.parseInt(postal);
									if(postal2>0) {
										customerBean2.setPostal(postal2);
										stay13=false;
									}else {
										throw new VallidationExceptionFMS("Please Enter Vallid Number,Must Be More Than Zero");
									}
								}
							}catch (VallidationExceptionFMS e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						}

						boolean stay15=true;
						while(stay15) {
							try{
								System.out.println("Enter customer Phone to Update: ");
								String phone=scanner.next();
								if(Validations.phoneNumberValidation(phone)) {
									Long phone2=Long.parseLong(phone);
									customerBean2.setPhone(phone2);
									stay15=false;
								}
							}catch (VallidationExceptionFMS e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						}

						try{
							if(customerDao.updateCustomer(customerBean2.getCustomerId(), customerBean2)) {
								System.out.println("Data Updated Successfully..! GOOD DAY");
							}
						}catch (Exception e) {
							String message=e.getMessage();
							System.err.println(message);
						}
						break;

					case 4:
						try {
							System.out.println("enter your CID To Delete: ");
							String ctidToDelete=scanner.next();
							if(Validations.numberValidation(ctidToDelete)){	
								Integer ctidToSearch2=Integer.parseInt(ctidToDelete);
								if(customerDao.deleteCustomer(ctidToSearch2)) {
									System.out.println("Customer Deleted Successfully..!");									
								}
							}
						}catch (Exception e) {
							String message=e.getMessage();
							System.err.println(message);
						}
						break;

					case 5:
						try {
							HashMap<Integer,CustomerBean>	allContracts=customerDao.getAllCustomer();
							Set<Integer> keys=allContracts.keySet();
							for (Integer key : keys) {
								CustomerBean conBean=allContracts.get(key);
								conBean.setCustomerId(key);
								System.out.println(conBean);
							}
						}catch (CustomerAppException e) {
							String message=e.getMessage();
							System.err.println(message);
						}
						break;


					case 6:
						AdminHomeApllication.adminHome();
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