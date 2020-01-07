package com.capgemini.foresterymanagement.application;

import com.capgemini.foresterymanagement.bean.CustomerBean;
import com.capgemini.foresterymanagement.bean.ProductBean;

import com.capgemini.foresterymanagement.dao.*;
import com.capgemini.foresterymanagement.factory.ForestFactory;
import com.capgemini.foresterymangement.validation.Validations;
import com.capgemini.foresterymanagement.exception.*;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductApp {
	public void product() {

		ProductDAO productDao = ForestFactory.insatnceOfProductDAOImpl();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("*******************WELCOME TO PRODUCT HOUSE*******************");
				System.out.println("*Enter 1 to add the Product");
				System.out.println("*Enter 2 to search the Product");
				System.out.println("*Enter 3 to update the Product");
				System.out.println("*Enter 4 to remove the Product");
				System.out.println("*Enter 5 to get all the Product");
				System.out.println("*Enter 6 to return HOME");
				String choice1 = scanner.next();
				String choice1IDregex = "^[0-9]*$";
				Pattern choice1IDpattern = Pattern.compile(choice1IDregex);
				Matcher choice1IDmatcher = choice1IDpattern.matcher(choice1);
				if (choice1IDmatcher.matches()) {
					int choice2 = Integer.parseInt(choice1);

					switch (choice2) {
					case 1:
						ProductBean productBean = new ProductBean();

						boolean stay1 = true;
						while (stay1) {
							try {
								System.out.println("Enter Product Name: ");
								String name = scanner.next();
								if (Validations.alphabetsValidation(name)) {
									productBean.setName(name);
									stay1 = false;
								}
							} catch (VallidationExceptionFMS e) {
								String message = e.getMessage();
								System.out.println(message);
							}
						}

						boolean stay3 = true;
						while (stay3) {
							try {
								System.out.println("Enter Product Quantity: ");
								String quantity1 = scanner.next();
								if (Validations.numberValidation(quantity1)) {
									Integer quantity = Integer.parseInt(quantity1);
									if (quantity > 0) {
										productBean.setQuantity(quantity);
										stay3 = false;
									} else {
										stay3 = true;
										throw new ProductAppException("please Enter the greater than zero values..!");
									}
								}
							} catch (Exception e) {
								String message = e.getMessage();
								System.err.println(message);
							}
						}

						boolean stay2 = true;
						while (stay2) {
							System.out.println("Enter Product Class(A-Z): ");
							String pclass = scanner.next();
							String nameregex = "^[A-Z]{1}$";
							Pattern namepattern = Pattern.compile(nameregex);
							Matcher namematcher = namepattern.matcher(pclass);
							if (namematcher.matches()) {
								productBean.setProductClass(pclass);
								stay2 = false;
							} else {
								System.err.println("please Enter the VALID Class..!");
								stay2 = true;
							}
						}

						boolean stay5 = true;
						while (stay5) {
							try {
								System.out.println("Enter Product Cost: ");
								String product1 = scanner.next();
								if (Validations.numberValidation(product1)) {
									Integer cost = Integer.parseInt(product1);
									if (cost > 0) {
										productBean.setCost(cost);
										stay5 = false;
									} else {
										stay5 = true;
										throw new ProductAppException("Enter the cost, must be more than zero");
									}
								}
							} catch (Exception e) {
								String message = e.getMessage();
								System.err.println(message);
							}
						}

						try {
							boolean isAdded = productDao.addProduct(productBean);
							if (isAdded) {
								System.out.println("Product Added Successfully With PID: "+productBean.getPid());
							}
						} catch (ProductAppException e) {
							String message = e.getMessage();
							System.err.println(message);
						}
						break;

					case 2:
						try {
							System.out.println("enter the productID to search product: ");
							String ctidToSearch = scanner.next();
							if(Validations.numberValidation(ctidToSearch)) {
								Integer ctidToSearch2 = Integer.parseInt(ctidToSearch);
								ProductBean poBean = productDao.searchProduct(ctidToSearch2);
								if (poBean == null) {
									throw new ProductAppException("No such products,please try another CTID");
								} else {
									System.out.println(poBean);
								}
							}
						} catch (VallidationExceptionFMS e) {
							String message = e.getMessage();
							System.err.println(message);
						}
						break;

					case 3:
						ProductBean productBean2 = new ProductBean();
						boolean stay10 = true;
						while (stay10) {
							System.out.println("Enter Product ID to update: ");
							try {
								String productID = scanner.next();
								if(Validations.numberValidation(productID)) {
									int ContractID2 = Integer.parseInt(productID);
									if (ContractID2 > 0) {
										productBean2.setPid(ContractID2);
										stay10 = false;
									} else {
										stay10 = true;
										throw new ProductAppException("please Enter vallid PID(greater than Zero)!");
									}

								}
							} catch (Exception e) {
								String message = e.getMessage();
								System.err.println(message);
							}
						}

						boolean stay11 = true;
						while (stay11) {
							try{
								System.out.println("Enter Product Name to Update: ");
								String pname = scanner.next();
								if(Validations.alphabetsValidation(pname)) {
									productBean2.setName(pname);
									stay11 = false;
								}
							}
							catch (Exception e) {
								String message = e.getMessage();
								System.err.println(message);
							}
						}

						boolean stay12 = true;
						while (stay12) {
							System.out.println("Enter Product Class(A-Z) to Update: ");
							String productClass = scanner.next();
							String productClassgex = "^[A-Z]{1}$";
							Pattern productPattern = Pattern.compile(productClassgex);
							Matcher productMatcher = productPattern.matcher(productClass);
							if (productMatcher.matches()) {

								productBean2.setProductClass(productClass);
								stay12 = false;
							} else {
								System.err.println("please Enter the VALID PRODCUT CLASS NAME..!");
								stay12 = true;
							}
						}

						boolean stay13 = true;
						while (stay13) {
							try {
								System.out.println("Enter Product Quantity to update: ");
								String quantity1 = scanner.next();
								if(Validations.numberValidation(quantity1)) {
									Integer quantity = Integer.parseInt(quantity1);
									if (quantity > 0) {
										productBean2.setQuantity(quantity);
										stay13 = false;
									} else {
										stay13 = true;
										throw new ProductAppException("please Enter the greater than zero values..!");
									}
								}
							} catch (Exception e) {
								String message = e.getMessage();
								System.err.println(message);
							}
						}

						boolean stay15 = true;
						while (stay15) {
							try {
								System.out.println("Enter Product Cost: ");
								String product1 = scanner.next();
								if(Validations.numberValidation(product1)) {
									Integer cost = Integer.parseInt(product1);
									if (cost > 0) {
										productBean2.setCost(cost);
										stay15 = false;
									} else {
										stay15 = true;
										throw new ProductAppException("Enter the cost, must be more than zero");
									}
								}
							} catch (Exception e) {
								String message = e.getMessage();
								System.err.println(message);
							}
						}
						try{
							boolean isUpdated = productDao.updateProduct(productBean2.getPid(), productBean2);
							if (isUpdated == true) {
								System.out.println("Product updated successfully..!");
							} 
						} catch (ProductAppException e) {
							String message = e.getMessage();
							System.err.println(message);
						}
						break;
					case 4:
						try {
							System.out.println("enter your productID To Delete: ");
							String pidToDelete = scanner.next();
							if(Validations.numberValidation(pidToDelete)) {
								Integer pidToSearch2 = Integer.parseInt(pidToDelete);
								if(productDao.deleteProduct(pidToSearch2)) {
									System.out.println("Product Deleted Successfully..!");
								}
							}
						} catch (ProductAppException e) {
							String message = e.getMessage();
							System.err.println(message);
						}
						break;
					case 5:
						HashMap<Integer, ProductBean> allContracts = productDao.getAllProduct();
						if(allContracts!=null) {
							Set<Integer> keys = allContracts.keySet();
							for (Integer key : keys) {
								ProductBean conBean = allContracts.get(key);
								System.out.println(conBean);
							}
						}else {
							System.err.println("Data Not Found..!");
						}

						break;
					case 6:
						AdminHomeApllication.adminHome();
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