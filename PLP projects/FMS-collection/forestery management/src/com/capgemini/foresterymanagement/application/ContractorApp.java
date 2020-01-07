package com.capgemini.foresterymanagement.application;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.foresterymanagement.bean.ContractorBean;
import com.capgemini.foresterymanagement.bean.ProductBean;
import com.capgemini.foresterymanagement.dao.*;
import com.capgemini.foresterymanagement.factory.ForestFactory;
import com.capgemini.foresterymangement.validation.Validations;
import com.capgemini.foresterymanagement.exception.*;

public class ContractorApp {
	public static void contract(int cidAuto) {
		ContractorDAO contractorDao = ForestFactory.instanceOfContractorDAOImpl();
		ProductDAO proBean = new ProductDAOImpl();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("\n********************WELCOME CUSTOMER TO CONTRACT HOUSE********************");
				System.out.println("*Enter 1 to add the Contract");
				System.out.println("*Enter 2 to search the Contract");
				System.out.println("*Enter 3 to update the Contract");
				System.out.println("*Enter 4 to remove the Contract");
				System.out.println("*Enter 5 to get all the Contract");
				System.out.println("*Enter 6 to Logout");
				String choice1 = scanner.next();
				String choice1IDregex = "^[0-9]*$";
				Pattern choice1IDpattern = Pattern.compile(choice1IDregex);
				Matcher choice1IDmatcher = choice1IDpattern.matcher(choice1);
				if (choice1IDmatcher.matches()) {
					int choice2 = Integer.parseInt(choice1);

					switch (choice2) {
					case 1:
						ContractorBean contractorBean = new ContractorBean();
						contractorBean.setCustomerId(cidAuto);

						boolean stay7 = true;
						while (stay7) {
							try {
								System.out.println("enter the Product ID: ");
								String productID = scanner.next();
								if (Validations.numberValidation(productID)) {
									int productID2 = Integer.parseInt(productID);
									if (productID2 == 00000) {
										ContractorApp.contract(cidAuto);
									}
									boolean product = proBean.isThereProductId(productID2);
									if (product) {
										contractorBean.setProductId(productID2);
										stay7 = false;

									} else {
										System.err.println(
												"Ooops!! This product is out of Stock, try other product-Id's");
										stay7 = true;
									}
								}
							} catch (VallidationExceptionFMS e) {
								String message = e.getMessage();
								System.err.println(message);
							}
						}

						boolean stay3 = true;
						while (stay3) {
							try {
								System.out.println("enter the haulier ID:(ex: KA-25-FB-4512) ");
								String haulier = scanner.next();
								if (Validations.haulierIdVallidation(haulier)) {
									contractorBean.setHaulierId(haulier);
									stay3 = false;
								}
							} catch (VallidationExceptionFMS e) {
								String message = e.getMessage();
								System.err.println(message);
							}
						}

						boolean stay1 = true;
						while (stay1) {
							try {
								System.out.println("enter the delivery date in YYYY/MM/DD fromat: ");
								String date = scanner.next();
								if (Validations.dateValidation(date)) {
									DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
									LocalDateTime now = LocalDateTime.now();
									String date2 = dtf.format(now);
									if (date.compareTo(date2) < 0 || date.compareTo(date2) == 0) {
										System.err.println("Please enter the Future Date... ");
										stay1 = true;
									} else {
										contractorBean.setDeliveryDate(date);
										stay1 = false;
									}
								}
							} catch (VallidationExceptionFMS e) {
								String message = e.getMessage();
								System.err.println(message);
							}
						}

						boolean stay8 = true;
						while (stay8) {
							try {
								System.out.println("Enter the quantiy required: ");
								String quantity = scanner.next();
								if (Validations.numberValidation(quantity)) {
									int quantity2 = Integer.parseInt(quantity);
									contractorBean.setQunatity(quantity2);
									stay8 = false;
								}
							} catch (VallidationExceptionFMS e) {
								String message = e.getMessage();
								System.err.println(message);
							}
						}

						try {
							if (contractorDao.addContarctor(contractorBean)) {
								System.out.println(
										"Contract Added Successfully with CTID: " + contractorBean.getContractId());
							}
						} catch (CustomerAppException e) {
							String message = e.getMessage();
							System.err.println(message);
						}

						break;

					case 2:
						try {
							System.out.println("enter the contractorID to search Contractor: ");
							String ctidToSearch = scanner.next();
							if (Validations.numberValidation(ctidToSearch)) {
								Integer ctidToSearch2 = Integer.parseInt(ctidToSearch);
								ContractorBean coBean = contractorDao.searchContarctor(ctidToSearch2);
								if (coBean == null) {
									throw new ContractorAppException("No such Contracts,please try another CTID\n");
								} else {
									System.out.println(coBean + "\n");
								}
							}
						} catch (VallidationExceptionFMS e) {
							String message = e.getMessage();
							System.err.println(message);
						}
						break;

					case 3:

						ContractorBean contractorBean2 = new ContractorBean();
						contractorBean2.setCustomerId(cidAuto);

						boolean stop5 = true;
						while (stop5) {
							try {
								System.out.println("enter the Contractor ID to update: ");
								String contractID = scanner.next();
								if (Validations.numberValidation(contractID)) {
									int ContractID2 = Integer.parseInt(contractID);
									contractorBean2.setContractId(ContractID2);
									stop5 = false;
								}
							} catch (VallidationExceptionFMS e) {
								String message = e.getMessage();
								System.err.println(message);
							}
						}

						boolean stop7 = true;
						while (stop7) {
							try {
								System.out.println("enter the Product ID: ");
								String productID = scanner.next();
								if (Validations.numberValidation(productID)) {
									int productID2 = Integer.parseInt(productID);
									if (productID2 == 00000) {
										ContractorApp.contract(cidAuto);
									}
									boolean product = proBean.isThereProductId(productID2);
									if (product) {
										contractorBean2.setProductId(productID2);
										stop7 = false;

									} else {
										stop7 = true;
										throw new ContractorAppException("Ooops!! This product is out of Stock, try other product-Id's");
									}
								} 
							} catch (Exception e) {
								String message = e.getMessage();
								System.err.println(message);
							}
						}

						boolean stop6 = true;
						while (stop6) {
							try {
								System.out.println("enter the haulier ID to update:(ex: KA-25-FB-4512) ");
								String haulier = scanner.next();
								if(Validations.haulierIdVallidation(haulier)){
									contractorBean2.setHaulierId(haulier);
									stop6 = false;
								} else {
									stop6 = true;
									throw new HaulierAddException("Enter the vallid HaulierID in the given format");
								}
							} catch (Exception e) {
								String message = e.getMessage();
								System.err.println(message);
							}
						}

						boolean stop1 = true;
						while (stop1) {
							try{
								System.out.println("enter the delivery date in YYYY/MM/DD fromat To Update: ");
								String date = scanner.next();

								if(Validations.dateValidation(date)) {
									contractorBean2.setDeliveryDate(date);
									stop1 = false;
								}
							}catch (VallidationExceptionFMS e) {
								String message = e.getMessage();
								System.err.println(message);
							}
						}

						boolean stay10 = true;
						while (stay10) {
							try {
								System.out.println("Enter the quantiy required to update: ");
								String quantity = scanner.next();
								if(Validations.numberValidation(quantity)) {
									int quantity2 = Integer.parseInt(quantity);
									contractorBean2.setQunatity(quantity2);
									stay10 = false;
								} 
							} catch (VallidationExceptionFMS e) {
								String message = e.getMessage();
								System.err.println(message);
							}
						}

						try{
							Boolean isUpdated = contractorDao.updateContarctor(contractorBean2.getContractId(),contractorBean2);
							if (isUpdated) {
								System.out.println("Updated successfully..!\n");
							} 
						}
						catch (CustomerAppException e) {
							String message = e.getMessage();
							System.err.println(message);
						}
						break;

					case 4:

						ContractorBean contractBean3 = new ContractorBean();
						try {
							System.out.println("enter your CTID To Delete: ");
							String ctidToDelete = scanner.next();
							if(Validations.numberValidation(ctidToDelete)) {
								Integer ctidToSearch2 = Integer.parseInt(ctidToDelete);
								contractBean3.setContractId(ctidToSearch2);
								boolean isDeleted = contractorDao.deletecontarctor(contractBean3.getContractId());
								if (isDeleted) {
									System.out.println("Specified Contract got deleted..\n");
								} else {
									System.err.println("Contrct not found..!");
								}
							}
						} catch (Exception e) {
							String message = e.getMessage();
							System.err.println(message);
						}
						break;

					case 5:
						HashMap<Integer, ContractorBean> allContracts = contractorDao.getAllContarctor();

						if(allContracts!=null) {
							Set<Integer> keys = allContracts.keySet();
							for (Integer key : keys) {
								ContractorBean conBean = allContracts.get(key);
								conBean.setContractId(key);
								System.out.println(conBean);
							}
						}else {
							System.err.println("No Data Fund For All Contracts..!");
						}
						break;

					case 6:
						ForestHomeCollections.main(null);

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