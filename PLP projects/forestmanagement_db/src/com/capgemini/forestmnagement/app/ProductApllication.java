package com.capgemini.forestmnagement.app;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.forestmnagement.bean.ContractorBean;
import com.capgemini.forestmnagement.bean.ProductBean;
import com.capgemini.forestmnagement.dao.ProductDAO;
import com.capgemini.forestmnagement.exception.ContractorAppException;
import com.capgemini.forestmnagement.exception.CustomerAppException;
import com.capgemini.forestmnagement.exception.ProductAppException;
import com.capgemini.forestmnagement.factory.ForestFactoryFmDb;

public class ProductApllication {
	void product(){
		ProductDAO productDao=ForestFactoryFmDb.createInstanceOfProductDAOImpl();
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
							System.out.println("GOOD DAY");
						}else {
							System.err.println("somthing went wrong buddy, try again..!");
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
								ProductBean poBean=productDao.searchProduct(ctidToSearch2);
								if(poBean!=null) {
									System.out.println(poBean);
								}else {
									throw new ContractorAppException("No such products,please try another CTID");
								}
							}
						}catch (ContractorAppException e) {
							String message=e.getMessage();
							System.err.println(message);
						}
						break;


					case 3: 
						ProductBean cb2=new ProductBean();
						boolean stay10=true;
						while(stay10) {

							System.out.println("Enter Product ID to Update: ");
							try
							{
								int pid=scanner.nextInt();
								cb2.setPID(pid);
								stay10=false;
							}
							catch (Exception e) {
								String msg1=e.getMessage();
								System.err.println(msg1+"please Enter the INTEGER value..!");
								stay10=true;
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
								cb2.setName(pname);
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

								cb2.setProductClass(productClass);
								stay12=false;
							}else {
								System.err.println("please Enter the VALID PRODCUT CLASS NAME..!");
								stay12=true;
							}
						}

						boolean stay13=true;
						while(stay13) {
							System.out.println("Enter Product Quantity to Update: ");
							int quantity=scanner.nextInt();
							String quantity1=Integer.toString(quantity);
							String quantityregex = "^[0-9]*";
							Pattern quantitypattern = Pattern.compile(quantityregex);
							Matcher quantitymatcher = quantitypattern.matcher(quantity1);
							if( quantitymatcher.matches()) {

								cb2.setQantity(quantity);
								stay13=false;
							}else {
								System.err.println("please Enter the VALID QUANTITY..!");
								stay13=true;
							}
						}

						boolean stay15=true;
						while(stay15) {
							System.out.println("Enter Product Cost to Update: ");
							Integer cost=scanner.nextInt();
							String product1=cost.toString();
							String productregex = "^[0-9]*";
							Pattern productpattern = Pattern.compile(productregex);
							Matcher phonematcher = productpattern.matcher(product1);
							if( phonematcher.matches()) {

								cb2.setCost(cost);
								stay15=false;
							}else {
								System.err.println("please Enter the VALID COST..!");
								stay15=true;
							}
						}

						if(productDao.updateProduct(cb2)) {
							System.out.println("GOOD DAY, DETAILS UPDATED");
						}else System.err.println("somthing went wrong buddy, try again..!");
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
								productDao.deleteProduct(pidToSearch2);
							}else {
								throw new ProductAppException("Please Enter The Valid PID, an INTEGER..!");
							}
						}catch (ProductAppException e) {
							String message=e.getMessage();
							System.err.println(message);
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
