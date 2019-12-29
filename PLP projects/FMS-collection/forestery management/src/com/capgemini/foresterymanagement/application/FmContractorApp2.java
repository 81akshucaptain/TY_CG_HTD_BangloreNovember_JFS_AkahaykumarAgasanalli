package com.capgemini.foresterymanagement.application;
import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.foresterymanagement.bean.ContractorBean;
import com.capgemini.foresterymanagement.bean.ProductBean;
import com.capgemini.foresterymanagement.dao.*;
import com.capgemini.foresterymanagement.factory.ForestFactory;
import com.capgemini.foresterymanagement.exception.*;

public class FmContractorApp2 {
	public static void contract(int cidAuto) {
		ContractorDAO contractorDao=ForestFactory.instanceOfContractorDAOImpl();
		ProductDAO proBean=new ProductDAOImpl();
		Scanner scanner=new Scanner(System.in);
		while (true) {
			try {			
				System.out.println("\n********************WELCOME CUSTOMER TO CONTRACT HOUSE********************");
				System.out.println("*Enter 1 to add the Contract");
				System.out.println("*Enter 2 to search the Contract");
				System.out.println("*Enter 3 to update the Contract");
				System.out.println("*Enter 4 to remove the Contract");
				System.out.println("*Enter 5 to get all the Contract");
				System.out.println("*Enter 6 to Logout");
				String choice1=scanner.next();
				String choice1IDregex = "^[0-9]*$";
				Pattern choice1IDpattern = Pattern.compile(choice1IDregex);
				Matcher choice1IDmatcher = choice1IDpattern.matcher(choice1);
				if( choice1IDmatcher.matches()) {
					int	choice2=Integer.parseInt(choice1);

					switch (choice2) {
					case 1:
						ContractorBean contractorBean=new ContractorBean();
						contractorBean.setCustomerId(cidAuto);

						//						boolean stay4=true;
						//						while(stay4) {
						//							try{
						//								System.out.println("enter the Customer ID: ");
						//								contractorBean.setCustomerId(scanner.nextInt());
						//								stay4=false;
						//							}catch (Exception e) {
						//								System.err.println("Enter The Valid Integer For Quantity");
						//								stay4=true;
						//							}
						//						}

						//				boolean stay5=true;
						//				while(stay5) {
						//					try{
						//						System.out.println("enter the contract ID: ");
						//						contractorBean.setContractorId(scanner.nextInt());
						//						stay5=false;
						//					}catch (Exception e) {
						//						System.err.println("Enter The Valid Integer For Quantity");
						//						stay5=true;
						//					}
						//				}

						boolean stay7=true;
						while(stay7) {
							try{
								System.out.println("enter the Product ID: ");
								String ProductID=scanner.next();
								String ProductIDregex = "^[0-9]*$";
								Pattern ProductIDpattern = Pattern.compile(ProductIDregex);
								Matcher ProductIDmatcher = ProductIDpattern.matcher(ProductID);
								if(ProductIDmatcher.matches()) {
									int ProductID2=Integer.parseInt(ProductID);
									if(ProductID2==00000) {
										FmContractorApp2.contract(cidAuto);
									}
									boolean product=proBean.isThereProductId(ProductID2);
									if(product) {
										contractorBean.setProductId(ProductID2);
										stay7=false;

									}else {
										System.err.println("Ooops!! This product is out of Stock, try other product-Id's");
										stay7=true;
									}
								}else {
									stay7=true;
									throw new ContractorAppException("Enter the valid ProductID");
								}
							}catch (ContractorAppException e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						}


						boolean stay3=true;
						while(stay3) {
							try{
								System.out.println("enter the haulier ID:(ex: KA-25-FB-4512) ");
								String haulier=scanner.next();
								String haulierregex = "^[A-Z]{2}-[0-9]{2}-[A-Z]{2}-[0-9]{4}$";
								Pattern haulierpattern = Pattern.compile(haulierregex);
								Matcher hauliermatcher = haulierpattern.matcher(haulier);
								if( hauliermatcher.matches()) {
									contractorBean.setHaulierId(haulier);
									stay3=false;
								}else {
									stay3=true;
									throw new HaulierAddException("Please enter the Valid Haulier ID in mentioned format..!");
								}
							}catch (HaulierAddException e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						} 


						boolean stay1=true;
						while(stay1) {
							System.out.println("enter the delivery date in YYYY/MM/DD fromat: ");
							String date = scanner.next();

							String regex = "^[0-9]{4}/(1[0-2]|0[1-9])/(3[01]"
									+ "|[12][0-9]|0[1-9])$"; 
							Pattern pattern = Pattern.compile(regex); 
							Matcher matcher = pattern.matcher((CharSequence)date);
							if(matcher.matches()) {
								DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
								LocalDateTime now = LocalDateTime.now(); 
								String date2=dtf.format(now);
								if(date.compareTo(date2)<0||date.compareTo(date2)==0){
									System.err.println("Please enter the Future Date... ");
									stay1=true;
								}else {
									contractorBean.setDeliveryDate(date);
									stay1=false;
								}

							}else {
								System.err.println("Please Enter The Valid DATE-FORMATE..!");
								stay1=true;
							}

						}

						//				boolean stay2=true;
						//				while(stay2) {
						//					System.out.println("Enter The Delivery Day: ");
						//					String DAY=scanner.next();
						//					if(DAY.equals("sunday")||DAY.equals("monday")||DAY.equals("tuesday")||DAY.equals("wednesday")||DAY.equals("thursday")||DAY.equals("friday")||DAY.equals("saturday")||
						//							DAY.equals("SUNDAY")||DAY.equals("MONDAY")||DAY.equals("TUESDAY")||DAY.equals("WEDNESDAY")||DAY.equals("THURSDAY")||DAY.equals("FRIDAY")||DAY.equals("SATURDAY")) 
						//					{
						//						contractorBean.setDeliveryDay(DAY);
						//						stay2=false;
						//					}else {
						//						System.err.println("Please enter the valid DAY...!");
						//						stay2=true;
						//					}
						//				}
						boolean stay8=true;
						while(stay8) {
							try{
								System.out.println("Enter the quantiy required: ");
								String quantity=scanner.next();
								String quantityregex = "^[0-9]*$";
								Pattern quantitypattern = Pattern.compile(quantityregex);
								Matcher quantitymatcher = quantitypattern.matcher(quantity);
								if(quantitymatcher.matches()) {
									int quantity2=Integer.parseInt(quantity);
									contractorBean.setQunatity(quantity2);
									stay8=false;
								}else {
									System.err.println("please Enter the VALID Integer for quantity..!");
									stay8=true;
								}
							}catch (ContractorAppException e) {
								System.err.println("please try again for Quantity");
								stay8=true;
							}
						}
						if(contractorDao.addContarctor(contractorBean)) {
							System.out.println("contract added successfully..!");
						}else {
							System.err.println("somthing went wrong buddy, try again..!");
						}
						break;

					case 2:
						try{
							System.out.println("enter the contractorID to search Contractor: ");
							String ctidToSearch=scanner.next();
							String ctidToSearchregex = "^[0-9]*$";
							Pattern ctidToSearchpattern = Pattern.compile(ctidToSearchregex);
							Matcher ctidToSearchmatcher = ctidToSearchpattern.matcher(ctidToSearch);
							if(ctidToSearchmatcher.matches()) {	
								Integer ctidToSearch2=Integer.parseInt(ctidToSearch);
								ContractorBean coBean=contractorDao.searchContarctor(ctidToSearch2);
								if(coBean==null) {
									throw new ContractorAppException("No such Contracts,please try another CTID\n");
								}else {
									System.out.println(coBean+"\n");
								}
							}
						}catch (ContractorAppException e) {
							String message=e.getMessage();
							System.err.println(message);
						}
						break;

					case 3:

						ContractorBean contractorBean2=new ContractorBean();
						contractorBean2.setCustomerId(cidAuto);

						boolean stop5=true;
						while(stop5){
							System.out.println("enter the Contractor ID to update: ");
							String ContractID=scanner.next();
							String haulierregex = "^[0-9]*$";
							Pattern haulierpattern = Pattern.compile(haulierregex);
							Matcher hauliermatcher = haulierpattern.matcher(ContractID);
							if( hauliermatcher.matches()) {
								int ContractID2=Integer.parseInt(ContractID);
								contractorBean2.setContractId(ContractID2);
								stop5=false;
							}else {
								System.err.println("please Enter the VALID Integer for CTID..!");
								stop5=true;
							}				
						}


						//						boolean stop4=true;
						//						while(stop4) {
						//							try{
						//								System.out.println("enter the Customer ID To Update: ");
						//								contractorBean2.setCustomerId(scanner.nextInt());
						//								stop4=false;
						//							}catch (Exception e) {
						//								System.err.println("Enter The Valid Integer For Quantity");
						//								stop4=true;
						//							}
						//						}
						//

						boolean stop7=true;
						while(stop7) {
							try{
								System.out.println("enter the Product ID: ");
								String ProductID=scanner.next();
								String ProductIDregex = "^[0-9]*$";
								Pattern ProductIDpattern = Pattern.compile(ProductIDregex);
								Matcher ProductIDmatcher = ProductIDpattern.matcher(ProductID);
								if(ProductIDmatcher.matches()) {
									int ProductID2=Integer.parseInt(ProductID);
									if(ProductID2==00000) {
										FmContractorApp2.contract(cidAuto);
									}
									boolean product=proBean.isThereProductId(ProductID2);
									if(product) {
										contractorBean2.setProductId(ProductID2);
										stop7=false;

									}else {
										stop7=true;
										throw new com.capgemini.foresterymanagement.exception.
										ContractorAppException("Ooops!! This product is out of Stock, try other product-Id's");
									}
								}else {
									stop7=true;
									throw new ContractorAppException("Please enter the valid Input..!");
								}
							}catch (ContractorAppException e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						}

						boolean stop6=true;
						while(stop6) {
							try {
								System.out.println("enter the haulier ID to update:(ex: KA-25-FB-4512) ");
								String haulier=scanner.next();
								String haulierregex = "^[A-Z]{2}-[0-9]{2}-[A-Z]{2}-[0-9]{4}$";
								Pattern haulierpattern = Pattern.compile(haulierregex);
								Matcher hauliermatcher = haulierpattern.matcher(haulier);
								if( hauliermatcher.matches()) {
									contractorBean2.setHaulierId(haulier);
									stop6=false;
								}else {
									stop6=true;
									throw new HaulierAddException("Enter the vallid HaulierID in the given format");
								}
							}catch (Exception e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						} 

						boolean stop1=true;
						while(stop1) {
							System.out.println("enter the delivery date in YYYY/MM/DD fromat To Update: ");
							String date = scanner.next();

							String regex = "^[0-9]{4}/(1[0-2]|0[1-9])/(3[01]"
									+ "|[12][0-9]|0[1-9])$"; 
							Pattern pattern = Pattern.compile(regex); 
							Matcher matcher = pattern.matcher((CharSequence)date);
							if(matcher.matches()) {
								contractorBean2.setDeliveryDate(date);
								stop1=false;
							}else {
								System.err.println("Please Enter The Valid DATE-FORMATE..!");
								stop1=true;
							}

						}

						//				boolean stop2=true;
						//				while(stop2) {
						//					System.out.println("Enter The Delivery Day To Update: ");
						//					String DAY=scanner.next();
						//					if(DAY.equals("sunday")||DAY.equals("monday")||DAY.equals("tuesday")||DAY.equals("wednesday")||DAY.equals("thursday")||DAY.equals("friday")||DAY.equals("saturday")||
						//							DAY.equals("SUNDAY")||DAY.equals("MONDAY")||DAY.equals("TUESDAY")||DAY.equals("WEDNESDAY")||DAY.equals("THURSDAY")||DAY.equals("FRIDAY")||DAY.equals("SATURDAY")) 
						//					{
						//						contractorBean2.setDeliveryDay(DAY);
						//						stop2=false;
						//					}else {
						//						System.err.println("Please enter the valid DAY...!");
						//						stop2=true;
						//					}
						//				}
						boolean stay10=true;
						while(stay10) {
							try{
								System.out.println("Enter the quantiy required to update: ");
								String quantity=scanner.next();
								String quantityregex = "^[0-9]*$";
								Pattern quantitypattern = Pattern.compile(quantityregex);
								Matcher quantitymatcher = quantitypattern.matcher(quantity);
								if(quantitymatcher.matches()) {
									int quantity2=Integer.parseInt(quantity);
									contractorBean2.setQunatity(quantity2);
									stay10=false;
								}else {
									System.err.println("please Enter the VALID Integer for quantity..!");
									stay10=true;
								}
							}catch (ContractorAppException e) {
								System.err.println("please try again for Quantity");
								stay10=true;
							}
						}


						Boolean isUpdated=contractorDao.updateContarctor(contractorBean2.getContractId(),contractorBean2);
						if(isUpdated) {
							System.out.println("Updated successfully..!\n");
						}else {
							System.err.println("Upadation failed..!\n");
						}
						break;

					case 4:

						ContractorBean contractBean3=new ContractorBean();
						try {
							System.out.println("enter your CTID To Delete: ");
							String ctidToDelete=scanner.next();
							String ctidToDeleteregex = "^[0-9]*$";
							Pattern ctidToDeletepattern = Pattern.compile(ctidToDeleteregex);
							Matcher ctidToDeletematcher = ctidToDeletepattern.matcher(ctidToDelete);
							if(ctidToDeletematcher.matches()) {	
								Integer ctidToSearch2=Integer.parseInt(ctidToDelete);
								contractBean3.setContractId(ctidToSearch2);
								boolean isDeleted=contractorDao.deletecontarctor(contractBean3.getContractId());
								if(isDeleted) {
									System.out.println("Specified Contract got deleted..\n");
								}else {
									System.err.println("Contrct not found..!");
								}
							}else {
								throw new ContractorAppException("Please Enter The Valid CTID, an INTEGER..!\n");
							}
						}catch (Exception e) {
							String message=e.getMessage();
							System.err.println(message);
						}
						break;					

					case 5:
						contractorDao.getAllContarctor();
						break;

					case 6:
						FmHome.main(null);

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