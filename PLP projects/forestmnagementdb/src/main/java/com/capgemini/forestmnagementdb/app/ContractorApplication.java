package com.capgemini.forestmnagementdb.app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.capgemini.forestmnagementdb.bean.ContractorBean;
import com.capgemini.forestmnagementdb.bean.CustomerBean;
import com.capgemini.forestmnagementdb.dao.ContractorDAO;
import com.capgemini.forestmnagementdb.dao.CustomerDAO;
import com.capgemini.forestmnagementdb.dao.ProductDAO;
import com.capgemini.forestmnagementdb.exception.ContractorAppException;
import com.capgemini.forestmnagementdb.exception.HaulierAddException;
import com.capgemini.forestmnagementdb.exception.VallidationExceptionFMS;
import com.capgemini.forestmnagementdb.factory.ForestFactoryJdbc;
import com.capgemini.forestmnagementdb.validations.Validations;

public class ContractorApplication {
	void contractor(int cid) {
		ContractorDAO contractDao=ForestFactoryJdbc.createInstanceOfContractorDAOImpl();
		ProductDAO productDao=ForestFactoryJdbc.createInstanceOfProductDAOImpl();
		CustomerDAO customerDAO=ForestFactoryJdbc.createInstanceOfCustomerDAOImpl();
		Scanner scanner=new Scanner(System.in);
		while (true) {
			try {
				System.out.println("********************WELCOME TO CONTRACTOR HOUSE********************");
				System.out.println("*Enter 1 to add the Contractor");
				System.out.println("*Enter 2 to search the Contractor");
				System.out.println("*Enter 3 to update the Contractor");
				System.out.println("*Enter 4 to remove the Contractor");
				System.out.println("*Enter 5 to get all the Contractor");
				System.out.println("*Enter 6 to Update Password");
				System.out.println("*Enter 7 to Logout");
				String choice1=scanner.next();
				if(Validations.numberValidation(choice1)) {
					int	choice2=Integer.parseInt(choice1);

					switch (choice2) {
					case 1:
						ContractorBean contractBean=new ContractorBean();

						contractBean.setCustomerId(cid);

						boolean stay5=true;
						while(stay5){
							try{
								System.out.println("enter the Contractor ID: ");
								String ContractID=scanner.next();
								if(Validations.numberValidation(ContractID)) {
									int ContractID2=Integer.parseInt(ContractID);
									contractBean.setContractId(ContractID2);
									stay5=false;
								}
							}catch (VallidationExceptionFMS e) {
								String message=e.getMessage();
								System.out.println(message);
							}
						}


						boolean stay7=true;
						while(stay7) {
							try{
								System.out.println("enter the Product ID: ");
								String ProductID=scanner.next();
								if(Validations.numberValidation(ProductID)) {
									int ProductID2=Integer.parseInt(ProductID);

									if(productDao.checkIsTherePID(ProductID2)) {
										contractBean.setProductId(ProductID2);
										stay7=false;
									}else {
										System.err.println("Currently This product is unavailabe..!");
										stay7=true;
									}
								}
							}catch (VallidationExceptionFMS e) {
								String message=e.getMessage();
								System.out.println(message);
							}
						}

						boolean stay3=true;
						while(stay3) {
							try{
								System.out.println("enter the haulier ID:(ex: KA-25-FB-4512) ");
								String haulier=scanner.next();
								if(Validations.haulierIdVallidation(haulier)){
									contractBean.setHaulierId(haulier);
									stay3=false;
								}
							}catch (HaulierAddException e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						} 

						boolean stay1=true;
						while(stay1) {
							try{
								System.out.println("enter the delivery date in YYYY/MM/DD fromat: ");
								String date = scanner.next();

								if(Validations.dateValidation(date)) {
									DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
									LocalDateTime now = LocalDateTime.now(); 
									String date2=dtf.format(now);
									if(date.compareTo(date2)<0||date.compareTo(date2)==0){
										System.err.println("Please enter the Future Date... ");
										stay1=true;
									}else {
										contractBean.setDeliveryDate(date);
										stay1=false;
									}

								}
							}catch (VallidationExceptionFMS e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						}


						boolean stay8=true;
						while(stay8) {
							try{
								System.out.println("Enter the quantiy required: ");
								String quantity=scanner.next();
								if(Validations.numberValidation(quantity)) {
									int quantity2=Integer.parseInt(quantity);
									contractBean.setQunatity(quantity2);
									stay8=false;
								}
							}catch (VallidationExceptionFMS e) {
								System.err.println("please try again for Quantity");
								stay8=true;
							}
						}


						if(contractDao.addContarctor(contractBean)) {
							System.out.println("Contract added successfully With CTID: "+contractBean.getContractId());
						}else {
							System.err.println("Contract  May Already Exist, Try Again..!");
						}
						break;

					case 2:
						try{
							System.out.println("enter the contractorID to search Contractor: ");
							String ctidToSearch=scanner.next();
							if(Validations.numberValidation(ctidToSearch)) {	
								Integer ctidToSearch2=Integer.parseInt(ctidToSearch);
								ContractorBean coBean=contractDao.searchContarctor(ctidToSearch2);
								if(coBean==null) {
									throw new ContractorAppException("No such Contracts,please try another CTID");
								}else {
									System.out.println(coBean);
								}
							}
						}catch (Exception e) {
							String message=e.getMessage();
							System.err.println(message);
						}
						break;

					case 3:
						ContractorBean contractBean2=new ContractorBean();

						contractBean2.setCustomerId(cid);

						boolean stay15=true;
						while(stay15){
							try{
								System.out.println("enter the Contractor ID: ");
								String ContractID=scanner.next();
								if(Validations.numberValidation(ContractID)) {
									int ContractID2=Integer.parseInt(ContractID);
									contractBean2.setContractId(ContractID2);
									stay15=false;
								}
							}catch (VallidationExceptionFMS e) {
								String message=e.getMessage();
								System.out.println(message);
							}
						}


						boolean stay17=true;
						while(stay17) {
							try{
								System.out.println("enter the Product ID: ");
								String ProductID=scanner.next();
								if(Validations.numberValidation(ProductID)) {
									int ProductID2=Integer.parseInt(ProductID);

									if(productDao.checkIsTherePID(ProductID2)) {
										contractBean2.setProductId(ProductID2);
										stay17=false;
									}else {
										System.err.println("Currently This product is unavailabe..!");
										stay17=true;
									}
								}
							}catch (VallidationExceptionFMS e) {
								String message=e.getMessage();
								System.out.println(message);
							}
						}

						boolean stay13=true;
						while(stay13) {
							try{
								System.out.println("enter the haulier ID:(ex: KA-25-FB-4512) ");
								String haulier=scanner.next();
								if(Validations.haulierIdVallidation(haulier)){
									contractBean2.setHaulierId(haulier);
									stay13=false;
								}
							}catch (HaulierAddException e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						} 

						boolean stay14=true;
						while(stay14) {
							try{
								System.out.println("enter the delivery date in YYYY/MM/DD fromat: ");
								String date = scanner.next();

								if(Validations.dateValidation(date)) {
									DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
									LocalDateTime now = LocalDateTime.now(); 
									String date2=dtf.format(now);
									if(date.compareTo(date2)<0||date.compareTo(date2)==0){
										System.err.println("Please enter the Future Date... ");
										stay14=true;
									}else {
										contractBean2.setDeliveryDate(date);
										stay14=false;
									}

								}
							}catch (VallidationExceptionFMS e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						}


						boolean stay18=true;
						while(stay18) {
							try{
								System.out.println("Enter the quantiy required: ");
								String quantity=scanner.next();
								if(Validations.numberValidation(quantity)) {
									int quantity2=Integer.parseInt(quantity);
									contractBean2.setQunatity(quantity2);
									stay18=false;
								}
							}catch (VallidationExceptionFMS e) {
								System.err.println("please try again for Quantity");
								stay8=true;
							}
						}						
						
						try {
							boolean isUpdated=contractDao.updateContarctor(contractBean2.getContractId(),contractBean2);
							if(isUpdated) {
								System.out.println("Done with updates");
							}else {
								throw new ContractorAppException("Try With Valid Inputs..!");
							}
						}catch (Exception e) {
							String message=e.getMessage();
							System.out.println(message);
						}
						break;

					case 4:
						ContractorBean contractBean3=new ContractorBean();
						try {
							System.out.println("enter your CTID To Delete: ");
							String ctidToDelete=scanner.next();
							if(Validations.numberValidation(ctidToDelete)){	
								Integer ctidToSearch2=Integer.parseInt(ctidToDelete);
								contractBean3.setContractId(ctidToSearch2);
								contractDao.deletecontarctor(contractBean3.getContractId());
							}
						}catch (Exception e) {
							String message=e.getMessage();
							System.err.println(message);
						}
						break;

					case 5:
						List<ContractorBean> contractBeans= contractDao.getAllContarctor();
						if(contractBeans!=null) {
							for (ContractorBean contracts : contractBeans) {
								System.out.println(contracts);
							}
						}else {
							System.out.println("Currently No Contracts..!");
						}
						break;
					
					case 6:
						boolean staypsw = true;
					while (staypsw) {
						try{
							System.out.println("Enter The Existing Password :");
						String existingPassword = scanner.next();
						CustomerBean beanForChangePssword = customerDAO.searchCustomer(cid);
						
						if (beanForChangePssword.getPassword().equals(existingPassword)) {
							System.out.println("Enter The New Password:");
							String newPassword = scanner.next();
							beanForChangePssword.setPassword(newPassword);
							
							if(Validations.passwordValidation(newPassword)) {
								boolean passwordUpdated = customerDAO.updateCustomer(beanForChangePssword);
								
								if (passwordUpdated) {
									System.out.println("New Password Updated Successfully..!");
									staypsw = false;
								} else {
									System.out.println("Failed To Update New Password..!");
									break;
								}
								
							} else {
								System.out.println("Invalid Existing Password..!");
								staypsw = true;
							}
						}
						}catch (VallidationExceptionFMS e) {
							String message = e.getMessage();
							System.err.println(message);
						}
					}
					break;
					case 7:
						ForestHomeJdbc.main(null);
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