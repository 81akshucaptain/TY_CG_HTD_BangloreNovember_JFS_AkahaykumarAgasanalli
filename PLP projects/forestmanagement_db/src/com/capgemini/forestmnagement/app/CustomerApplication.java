package com.capgemini.forestmnagement.app;


import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.forestmnagement.bean.ContractorBean;
import com.capgemini.forestmnagement.bean.CustomerBean;
import com.capgemini.forestmnagement.dao.CustomerDAO;
import com.capgemini.forestmnagement.exception.ContractorAppException;
import com.capgemini.forestmnagement.exception.CustomerAppException;
import com.capgemini.forestmnagement.factory.ForestFactoryFmDb;


public class CustomerApplication {
	void customer(){
		CustomerDAO customerDao=ForestFactoryFmDb.createInstanceOfCustomerDAOImpl();
		Scanner scanner=new Scanner(System.in);
		while (true) {
			try {
				System.out.println("*******************WELCOME TO CUSTOMER HOUSE*********************");
				System.out.println("*Enter 1 to add the customer");
				System.out.println("*Enter 2 to search the customer");
				System.out.println("*Enter 3 to update the customer");

				System.out.println("*Enter 4 to delete the customer");
				System.out.println("*Enter 5 to get all the customer");
				System.out.println("*Enter 6 to Retur HOME");
				String choice1=scanner.next();
				String choice1IDregex = "^[0-9]*$";
				Pattern choice1IDpattern = Pattern.compile(choice1IDregex);
				Matcher choice1IDmatcher = choice1IDpattern.matcher(choice1);
				if( choice1IDmatcher.matches()) {
					int	choice2=Integer.parseInt(choice1);

					switch (choice2) {
					case 1:
						CustomerBean customerBean=new CustomerBean();

						boolean stay=true;
						while(stay) {

							System.out.println("Enter customer ID: ");
							try
							{
								String CostumerID=scanner.next();
								String CostumerIDregex = "^[0-9]*$";
								Pattern CostumerIDpattern = Pattern.compile(CostumerIDregex);
								Matcher CostumerIDmatcher = CostumerIDpattern.matcher(CostumerID);
								if( CostumerIDmatcher.matches()) {
									int ContractID2=Integer.parseInt(CostumerID);
									if(ContractID2>0) {
										customerBean.setCid(ContractID2);
										stay=false;
									}else {
										stay=true;
										throw new CustomerAppException("please Enter vallid CID(greater than Zero)!");
									}

								}else {
									stay=true;
									throw new CustomerAppException("please Enter the INTEGER value..!");
								}
							}
							catch (CustomerAppException e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						} 

						boolean stay1=true;
						while(stay1) {
							System.out.println("Enter customer First Name: ");
							String fname=scanner.next();
							System.out.println("Enter customer middle Name(if not please enter underscore): ");
							String mname=scanner.next();
							System.out.println("Enter customer Last Name: ");
							String lname=scanner.next();
							String fullName=fname+" "+mname+" "+lname;
							String nameregex = "^[A-Za-z _?A-Za-z A-Za-z]*";
							Pattern namepattern = Pattern.compile(nameregex);
							Matcher namematcher = namepattern.matcher(fullName);
							if( namematcher.matches()) { 
								customerBean.setName(fullName);
								stay1=false;
							}else {
								System.err.println("please Enter the VALID NAME..!");
								stay1=true;
							}
						} 

						boolean stay2=true;
						while(stay2) 
						{
							System.out.println("Enter customer Town: ");
							String town=scanner.next();
							String townregex = "^[A-Za-z]*";
							Pattern townpattern = Pattern.compile(townregex);
							Matcher townmatcher = townpattern.matcher(town);
							if( townmatcher.matches()) {

								customerBean.setTown(town);
								stay2=false;
							}else {
								System.err.println("please Enter the VALID TOWN NAME..!");
								stay2=true;
							}
						}

						boolean stay4=true;
						while(stay4) {
							System.out.println("Enter customer Email: ");
							String email=scanner.next();
							String emailregex = "^(.+)@(.+)\\.(.+)$";
							Pattern emailpattern = Pattern.compile(emailregex);
							Matcher emailmatcher = emailpattern.matcher((CharSequence)email);
							if( emailmatcher.matches()) {

								customerBean.setEmail(email);
								stay4=false;
							}else {
								System.err.println("please Enter the VALID EMAIL ID..!");
								stay4=true;
							}
						}

						boolean stay3=true;
						while(stay3) {
							try {
								System.out.println("Enter customer Postal: ");
								String postal=scanner.next();
								String postalregex = "^[0-9]{6}";
								Pattern postalpattern = Pattern.compile(postalregex);
								Matcher postalmatcher = postalpattern.matcher(postal);
								if( postalmatcher.matches()) {
									Integer postal2=Integer.parseInt(postal);
									if(postal2>0) {
										customerBean.setPostal(postal2);
										stay3=false;
									}else {
										stay3=true;
										throw new CustomerAppException("Postal must be Greater Than Zero");
									}
								}else {
									stay3=true;
									throw new CustomerAppException("please Enter the VALID POSTAL CODE, an Integer..!");
								}
							}catch (CustomerAppException e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						}

						boolean stay5=true;
						while(stay5) {
							System.out.println("Enter customer Phone: ");
							String phone=scanner.next();
							String phoneregex = "^[6789][0-9]{9}";
							Pattern phonepattern = Pattern.compile(phoneregex);
							Matcher phonematcher = phonepattern.matcher(phone);
							if( phonematcher.matches()) {

								customerBean.setPhone(phone);
								stay5=false;
							}else {
								System.err.println("please Enter the VALID PHONE..!");
								stay5=true;
							}
						}

						if(customerDao.addCustomer(customerBean)) {
							System.out.println("GOOD DAY");
						}else System.err.println("somthing went wrong buddy, try again..!");
						break;

					case 2:
						try{
							System.out.println("enter the customer ID to search Customer: ");
							String ctidToSearch=scanner.next();
							String ctidToSearchregex = "^[0-9]*$";
							Pattern ctidToSearchpattern = Pattern.compile(ctidToSearchregex);
							Matcher ctidToSearchmatcher = ctidToSearchpattern.matcher(ctidToSearch);
							if(ctidToSearchmatcher.matches()) {	
								Integer ctidToSearch2=Integer.parseInt(ctidToSearch);
								customerDao.searchCustomer(ctidToSearch2);
							}
						}catch (ContractorAppException e) {
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
								String CostumerIDregex = "^[0-9]*$";
								Pattern CostumerIDpattern = Pattern.compile(CostumerIDregex);
								Matcher CostumerIDmatcher = CostumerIDpattern.matcher(CostumerID);
								if( CostumerIDmatcher.matches()) {
									int ContractID2=Integer.parseInt(CostumerID);
									if(ContractID2>0) {
										customerBean2.setCid(ContractID2);
										stay10=false;
									}else {
										stay10=true;
										throw new CustomerAppException("please Enter vallid CID(greater than Zero)!");
									}

								}else {
									stay10=true;
									throw new CustomerAppException("please Enter the INTEGER value..!");
								}
							}
							catch (CustomerAppException e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						} 

						boolean stay11=true;
						while(stay11) {
							System.out.println("Enter customer First Name to update: ");
							String fname=scanner.next();
							System.out.println("Enter customer middle Name(if not please enter underscore): ");
							String mname=scanner.next();
							System.out.println("Enter customer Last Name: ");
							String lname=scanner.next();
							String fullName=fname+" "+mname+" "+lname;
							String nameregex = "^[A-Za-z _?A-Za-z A-Za-z]*";
							Pattern namepattern = Pattern.compile(nameregex);
							Matcher namematcher = namepattern.matcher(fullName);
							if( namematcher.matches()) { 
								customerBean2.setName(fullName);
								stay11=false;
							}else {
								System.err.println("please Enter the VALID NAME to update..!");
								stay11=true;
							}
						} 

						boolean stay12=true;
						while(stay12) 
						{
							System.out.println("Enter customer Town to update: ");
							String town2=scanner.next();
							String townregex = "^[A-Za-z]*";
							Pattern townpattern = Pattern.compile(townregex);
							Matcher townmatcher = townpattern.matcher(town2);
							if( townmatcher.matches()) {

								customerBean2.setTown(town2);
								stay12=false;
							}else {
								System.err.println("please Enter the VALID TOWN NAME..!");
								stay12=true;
							}
						}
						boolean stay14=true;
						while(stay14) {
							System.out.println("Enter customer Email to update: ");
							String email2=scanner.next();
							String emailregex = "^(.+)@(.+)\\.(.+)$";
							Pattern emailpattern = Pattern.compile(emailregex);
							Matcher emailmatcher = emailpattern.matcher((CharSequence)email2);
							if( emailmatcher.matches()) {

								customerBean2.setEmail(email2);
								stay14=false;
							}else {
								System.err.println("please Enter the VALID EMAIL ID..!");
								stay14=true;
							}
						}

						boolean stay13=true;
						while(stay13) {
							System.out.println("Enter customer Postal: ");
							int postal2=scanner.nextInt();
							String postal1=Integer.toString(postal2);
							String postalregex = "^[0-9]{6}";
							Pattern postalpattern = Pattern.compile(postalregex);
							Matcher postalmatcher = postalpattern.matcher(postal1);
							if( postalmatcher.matches()) {
								if(postal2>0) {
									customerBean2.setPostal(postal2);
									stay13=false;
								}else {
									stay13=true;
									throw new ContractorAppException("please enter the vallid Postal,greater Than zero");
								}
							}else {
								System.err.println("please Enter the VALID POSTALCODE..!");
								stay13=true;
							}
						}

						boolean stay15=true;
						while(stay15) {
							System.out.println("Enter customer Phone: ");
							String phone2=scanner.next();
							String phoneregex = "^[6786][0-9]{9}";
							Pattern phonepattern = Pattern.compile(phoneregex);
							Matcher phonematcher = phonepattern.matcher(phone2);
							if( phonematcher.matches()) {

								customerBean2.setPhone(phone2);
								stay15=false;
							}else {
								System.err.println("please Enter the VALID PHONE..!");
								stay15=true;
							}
						}

						if(customerDao.updateCustomer(customerBean2)) {
							System.out.println(" GOOD DAY");
						}else System.err.println("somthing went wrong buddy, try again..!");
						break;
					case 4:
						try {
							System.out.println("enter your CID To Delete: ");
							String ctidToDelete=scanner.next();
							String ctidToDeleteregex = "^[0-9]*$";
							Pattern ctidToDeletepattern = Pattern.compile(ctidToDeleteregex);
							Matcher ctidToDeletematcher = ctidToDeletepattern.matcher(ctidToDelete);
							if(ctidToDeletematcher.matches()) {	
								Integer ctidToSearch2=Integer.parseInt(ctidToDelete);
								customerDao.deleteCustomer(ctidToSearch2);
							}else {
								throw new ContractorAppException("Please Enter The Valid CID, must be an INTEGER..!");
							}
						}catch (Exception e) {
							String message=e.getMessage();
							System.err.println(message);
						}
						break;
					case 5:
						customerDao.getAllCustomer();
						break;
					case 6:
						AdminApp admin=new AdminApp();
						admin.adminMain();
						break;
					default: System.err.println("Enter the valid choice to move further");
					break;

					}
				}else {
					System.err.println("Please enter the valid choice, in terms of Digit..!");
				}

			}catch (Exception e) {
				System.err.println("try again with valid inputs..!");
			}

		}
	}
}

