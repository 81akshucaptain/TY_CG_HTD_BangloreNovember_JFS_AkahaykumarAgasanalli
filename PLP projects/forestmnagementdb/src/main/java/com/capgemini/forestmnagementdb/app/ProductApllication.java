package com.capgemini.forestmnagementdb.app;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.forestmnagementdb.bean.ContractorBean;
import com.capgemini.forestmnagementdb.bean.ProductBean;
import com.capgemini.forestmnagementdb.dao.ProductDAO;
import com.capgemini.forestmnagementdb.exception.ContractorAppException;
import com.capgemini.forestmnagementdb.exception.CustomerAppException;
import com.capgemini.forestmnagementdb.exception.ProductAppException;
import com.capgemini.forestmnagementdb.exception.VallidationExceptionFMS;
import com.capgemini.forestmnagementdb.factory.ForestFactoryJdbc;
import com.capgemini.forestmnagementdb.validations.Validations;

public class ProductApllication {
	void product(){
		ProductDAO productDao=ForestFactoryJdbc.createInstanceOfProductDAOImpl();
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
				if(Validations.numberValidation(choice1)) {
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
								if(Validations.numberValidation(productID)) {
									int productId2=Integer.parseInt(productID);
									if(productId2>0) {
										productBean.setProductId(productId2);
										stay=false;
									}else {
										stay=true;
										throw new ProductAppException("please Enter vallid PID(greater than Zero)!");
									}

								}
							}
							catch (Exception e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						} 


						boolean stay1=true;
						while(stay1) {
							try{
								System.out.println("Enter Product Name: ");
								String pname=scanner.next();
								if(Validations.alphabetsValidation(pname)){
									productBean.setName(pname);
									stay1=false;
								}
							} catch (VallidationExceptionFMS e) {
								String message=e.getMessage();
								System.err.println(message);
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
								if(Validations.numberValidation(quantity1)){
									Integer quantity=Integer.parseInt(quantity1); 
									if(quantity>0) {
										productBean.setQuantity(quantity);
										stay3=false;
									}else {
										stay3=true;
										throw new ProductAppException("please Enter the greater than zero values..!");
									}
								}
							}catch(Exception e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						}


						boolean stay5=true;
						while(stay5) {
							try{
								System.out.println("Enter Product Cost: ");
								String product1=scanner.next();
								if(Validations.numberValidation(product1)) {
									Integer cost=Integer.parseInt(product1);
									if(cost>0) {
										productBean.setCost(cost);
										stay5=false;
									}else {
										stay5=true;
										throw new ProductAppException("Enter the cost, must be more than zero");
									}
								}
							}catch(Exception e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						}

						if(productDao.addProduct(productBean)) {
							System.out.println("Product Added Successfully with PID: "+productBean.getProductId());
						}else {
							System.err.println("Product May Exist With Same ID, try again..!");
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
						ProductBean productBean2=new ProductBean();
						boolean stay10=true;
						while(stay10) {
							System.out.println("Enter Product ID to update: ");
							try
							{
								String productID=scanner.next();
								if(Validations.numberValidation(productID)) {
									int productId2=Integer.parseInt(productID);
									if(productId2>0) {
										productBean2.setProductId(productId2);
										stay10=false;
									}else {
										stay10=true;
										throw new ProductAppException("please Enter vallid PID(greater than Zero)!");
									}

								}
							}
							catch (Exception e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						} 

						boolean stay11=true;
						while(stay11) {
							try{
								System.out.println("Enter Product Name to Update: ");
								String pname=scanner.next();
								if(Validations.alphabetsValidation(pname)){
									productBean2.setName(pname);
									stay11=false;
								}
							}
							catch (Exception e) {
								String message=e.getMessage();
								System.err.println(message);
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
								if(Validations.numberValidation(quantity1)) {
									Integer quantity=Integer.parseInt(quantity1); 
									if(quantity>0) {
										productBean2.setQuantity(quantity);
										stay13=false;
									}else {
										stay13=true;
										throw new ProductAppException("please Enter the greater than zero values..!");
									}
								}
							}catch(Exception e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						}


						boolean stay15=true;
						while(stay15) {
							try{
								System.out.println("Enter Product Cost: ");
								String product1=scanner.next();
								if(Validations.numberValidation(product1)) {
									Integer cost=Integer.parseInt(product1);
									if(cost>0) {
										productBean2.setCost(cost);
										stay15=false;
									}else {
										stay15=true;
										throw new ProductAppException("Enter the cost, must be more than zero");
									}
								}
							}catch(Exception e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						}
						if(productDao.updateProduct(productBean2)) {
							System.out.println("New Data Updated Successfully..!");
						}else {
							System.err.println("Failed To Update Data..!");
						}
						break;

					case 4:
						try {
							System.out.println("enter your productID To Delete: ");
							String pidToDelete=scanner.next();
							if(Validations.numberValidation(pidToDelete)) {	
								Integer pidToSearch2=Integer.parseInt(pidToDelete);
								if(productDao.deleteProduct(pidToSearch2)) {
									System.out.println("Product Deleted Successfully..!");
								}
							}
						}catch (VallidationExceptionFMS e) {
							String message=e.getMessage();
							System.err.println(message);
						}
						break;

					case 5:
						List<ProductBean> productBeans= productDao.getAllProduct();
						if(productBeans!=null) {
							for (ProductBean productBean3 : productBeans) {
								System.out.println(productBean3);
							}
						}else {
							System.out.println("Empty Product Inventory..!");
						}
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
