package com.capgemini.forestmanagementjpa.apps;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.forestmanagementjpa.dao.ProductDAO;
import com.capgemini.forestmanagementjpa.dto.ProductBean;
import com.capgemini.forestmanagementjpa.exceptions.ContractorAppException;
import com.capgemini.forestmanagementjpa.exceptions.ProductAppException;
import com.capgemini.forestmanagementjpa.factory.ForestFactoryFmJpa;
public class ProductApllication {
	public void product() {
		ProductDAO productDao=ForestFactoryFmJpa.createInstanceOfProductDAOImpl();
		Scanner scanner=new Scanner(System.in);
		while (true) {
			try {
				System.out.println("*******************WELCOME TO PRODUCT HOUSE*********************");
				System.out.println("*Enter 1 to add the Product");
				System.out.println("*Enter 2 to search the Product");
				System.out.println("*Enter 3 to update the Product");

				System.out.println("*Enter 4 to delete the Product");
				System.out.println("*Enter 5 to get all the Product");
				System.out.println("*Enter 6 to Retur HOME");
				String choice1=scanner.next();
				String choice1IDregex = "^[0-9]*$";
				Pattern choice1IDpattern = Pattern.compile(choice1IDregex);
				Matcher choice1IDmatcher = choice1IDpattern.matcher(choice1);
				if( choice1IDmatcher.matches()) {
					int	choice2=Integer.parseInt(choice1);

					switch (choice2) {
					case 1:
						ProductBean productBean=new ProductBean();

						boolean stay=true;
						while(stay) {
							System.out.println("Enter Product ID: ");
							try
							{
								String productID=scanner.next();
								String productIDregex = "^[0-9]*$";
								Pattern productIDpattern = Pattern.compile(productIDregex);
								Matcher productIDmatcher = productIDpattern.matcher(productID);
								if( productIDmatcher.matches()) {
									int ContractID2=Integer.parseInt(productID);
									if(ContractID2>0) {
										productBean.setPID(ContractID2);
										stay=false;
									}else {
										stay=true;
										throw new ProductAppException("please Enter vallid PID(greater than Zero)!");
									}

								}else {
									stay=true;
									throw new ProductAppException("please Enter the INTEGER value..!");
								}
							}
							catch (ProductAppException e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						} 

						boolean stay1=true;
						while(stay1) {
							System.out.println("Enter Product Name: ");
							String pname=scanner.next();
							String nameregex = "^[A-Za-z]*";
							Pattern namepattern = Pattern.compile(nameregex);
							Matcher namematcher = namepattern.matcher(pname);
							if( namematcher.matches()) {
								productBean.setName(pname);
								stay1=false;
							}else {
								System.err.println("please Enter the VALID NAME..!");
								stay1=true;
							}
						} 

						boolean stay2=true;
						while(stay2) 
						{
							System.out.println("Enter Product Class(A-Z): ");
							String productClass=scanner.next();
							String productClassgex = "^[A-Z]{1}$";
							Pattern productPattern = Pattern.compile(productClassgex);
							Matcher productMatcher = productPattern.matcher(productClass);
							if( productMatcher.matches()) {

								productBean.setProductClass(productClass);
								stay2=false;
							}else {
								System.err.println("please Enter the VALID PRODCUT CLASS NAME..!");
								stay2=true;
							}
						}

						boolean stay3=true;
						while(stay3) {
							try{
								System.out.println("Enter Product Quantity: ");
								String quantity1=scanner.next();
								String quantityregex = "^[0-9]*";
								Pattern quantitypattern = Pattern.compile(quantityregex);
								Matcher quantitymatcher = quantitypattern.matcher(quantity1);
								if( quantitymatcher.matches()) {
									Integer quantity=Integer.parseInt(quantity1); 
									if(quantity>0) {
										productBean.setQantity(quantity);
										stay3=false;
									}else {
										stay3=true;
										throw new ProductAppException("please Enter the greater than zero values..!");
									}
								}else {
									System.err.println("please Enter the VALID QUANTITY..!");
									stay3=true;
								}
							}catch(ProductAppException e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						}


						boolean stay5=true;
						while(stay5) {
							try{
								System.out.println("Enter Product Cost: ");
								String product1=scanner.next();
								String productregex = "^[0-9]*";
								Pattern productpattern = Pattern.compile(productregex);
								Matcher phonematcher = productpattern.matcher(product1);
								if( phonematcher.matches()) {
									Integer cost=Integer.parseInt(product1);
									if(cost>0) {
										productBean.setCost(cost);
										stay5=false;
									}else {
										stay5=true;
										throw new ProductAppException("Enter the cost, must be more than zero");
									}
								}else {
									System.err.println("please Enter the VALID COST..!");
									stay5=true;
								}
							}catch(ProductAppException e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						}

						if(productDao.addProduct(productBean)) {
							System.out.println("Product Added Successfully..!");
						}else {
							System.err.println("Something went wrong while Adding,try again..!");
						}
						break;

					case 2:
						try{
							System.out.println("enter the productID to search product: ");
							String ctidToSearch=scanner.next();
							String ctidToSearchregex = "^[0-9]*$";
							Pattern ctidToSearchpattern = Pattern.compile(ctidToSearchregex);
							Matcher ctidToSearchmatcher = ctidToSearchpattern.matcher(ctidToSearch);
							if(ctidToSearchmatcher.matches()) {	
								Integer ctidToSearch2=Integer.parseInt(ctidToSearch);
								ProductBean prBean=productDao.searchProduct(ctidToSearch2);
								if(prBean==null) {
									throw new ContractorAppException("Product Not Found, try again");
								}else {
									System.out.println(prBean);
								}
							}
						}catch (ContractorAppException e) {
							String message=e.getMessage();
							System.out.println(message);
						}
						break;


					case 3: 
						ProductBean productBean2=new ProductBean();
						boolean stay10=true;
						while(stay10) {
							System.out.println("Enter Product ID to update: ");
							try
							{
								String productID=scanner.next();
								String productIDregex = "^[0-9]*$";
								Pattern productIDpattern = Pattern.compile(productIDregex);
								Matcher productIDmatcher = productIDpattern.matcher(productID);
								if( productIDmatcher.matches()) {
									int productID2=Integer.parseInt(productID);
									if(productID2>0) {
										productBean2.setPID(productID2);
										stay10=false;
									}else {
										stay10=true;
										throw new ProductAppException("please Enter vallid PID(greater than Zero)!");
									}

								}else {
									stay10=true;
									throw new ProductAppException("please Enter the INTEGER value..!");
								}
							}
							catch (ProductAppException e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						} 

						boolean stay11=true;
						while(stay11) {
							System.out.println("Enter Product Name to Update: ");
							String pname=scanner.next();
							String nameregex = "^[A-Za-z]*";
							Pattern namepattern = Pattern.compile(nameregex);
							Matcher namematcher = namepattern.matcher(pname);
							if( namematcher.matches()) {
								productBean2.setName(pname);
								stay11=false;
							}else {
								System.err.println("please Enter the VALID NAME..!");
								stay11=true;
							}
						} 

						boolean stay12=true;
						while(stay12) 
						{
							System.out.println("Enter Product Class(A-Z) to Update: ");
							String productClass=scanner.next();
							String productClassgex = "^[A-Z]{1}$";
							Pattern productPattern = Pattern.compile(productClassgex);
							Matcher productMatcher = productPattern.matcher(productClass);
							if( productMatcher.matches()) {

								productBean2.setProductClass(productClass);
								stay12=false;
							}else {
								System.err.println("please Enter the VALID PRODCUT CLASS NAME..!");
								stay12=true;
							}
						}

						boolean stay13=true;
						while(stay13) {
							try{
								System.out.println("Enter Product Quantity to update: ");
								String quantity1=scanner.next();
								String quantityregex = "^[0-9]*";
								Pattern quantitypattern = Pattern.compile(quantityregex);
								Matcher quantitymatcher = quantitypattern.matcher(quantity1);
								if( quantitymatcher.matches()) {
									Integer quantity=Integer.parseInt(quantity1); 
									if(quantity>0) {
										productBean2.setQantity(quantity);
										stay13=false;
									}else {
										stay13=true;
										throw new ProductAppException("please Enter the greater than zero values..!");
									}
								}else {
									System.err.println("please Enter the VALID QUANTITY..!");
									stay13=true;
								}
							}catch(ProductAppException e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						}


						boolean stay15=true;
						while(stay15) {
							try{
								System.out.println("Enter Product Cost: ");
								String product1=scanner.next();
								String productregex = "^[0-9]*";
								Pattern productpattern = Pattern.compile(productregex);
								Matcher phonematcher = productpattern.matcher(product1);
								if( phonematcher.matches()) {
									Integer cost=Integer.parseInt(product1);
									if(cost>0) {
										productBean2.setCost(cost);
										stay15=false;
									}else {
										stay15=true;
										throw new ProductAppException("Enter the cost, must be more than zero");
									}
								}else {
									System.out.println("please Enter the VALID COST..!");
									stay15=true;
								}
							}catch(ProductAppException e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						}
						if(productDao.updateProduct(productBean2)) {
							System.out.println("PRODUCT DATA UPDATED,GOOD DAY");
						}else {
							System.out.println("something went wrong while updating Product Details, please try again..!");
						}
						break;

					case 4:
						try {
							System.out.println("enter your productID To Delete: ");
							String pidToDelete=scanner.next();
							String pidToDeleteregex = "^[0-9]*$";
							Pattern pidToDeletepattern = Pattern.compile(pidToDeleteregex);
							Matcher pidToDeletematcher = pidToDeletepattern.matcher(pidToDelete);
							if(pidToDeletematcher.matches()) {	
								Integer pidToSearch2=Integer.parseInt(pidToDelete);
								if(productDao.deleteProduct(pidToSearch2)) {
									System.out.println("Product Deleted Successfully..!");
								}else {
									System.out.println("Product Not Found To Delete, try again");
								}
							}else {
								throw new ProductAppException("Please Enter The Valid PID, an INTEGER..!");
							}
						}catch (ProductAppException e) {
							String message=e.getMessage();
							System.out.println(message);
						}
						break;

					case 5:
						productDao.getAllProduct();
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
				System.err.println("try again with valid input..!");
			}

		}
	}
}
