package com.capgemini.forestmanagementjpa.apps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.forestmanagementjpa.dao.ContractorDAO;
import com.capgemini.forestmanagementjpa.dao.ProductDAO;
import com.capgemini.forestmanagementjpa.dto.ContractorBean;
import com.capgemini.forestmanagementjpa.exceptions.ContractorAppException;
import com.capgemini.forestmanagementjpa.exceptions.HaulierAddException;
import com.capgemini.forestmanagementjpa.factory.ForestFactoryFmJpa;

public class ContractorApplication {
	void contractor(int cid) {
		ContractorDAO contractDao=ForestFactoryFmJpa.createInstanceOfContractorDAOImpl();
		ProductDAO productDao=ForestFactoryFmJpa.createInstanceOfProductDAOImpl();
		Scanner scanner=new Scanner(System.in);
		while (true) {
			try {
				System.out.println("********************WELCOME TO CONTRACTOR HOUSE********************");
				System.out.println("*Enter 1 to add the Contractor");
				System.out.println("*Enter 2 to search the Contractor");
				System.out.println("*Enter 3 to update the Contractor");
				System.out.println("*Enter 4 to remove the Contractor");
				System.out.println("*Enter 5 to get all the Contractor");
				System.out.println("*Enter 6 to Logout");
				String choice1=scanner.next();
				String choice1IDregex = "^[0-9]*$";
				Pattern choice1IDpattern = Pattern.compile(choice1IDregex);
				Matcher choice1IDmatcher = choice1IDpattern.matcher(choice1);
				if( choice1IDmatcher.matches()) {
					int	choice2=Integer.parseInt(choice1);

					switch (choice2) {
					case 1:
						ContractorBean contractBean=new ContractorBean();

						contractBean.setCustomerId(cid);

						boolean stay5=true;
						while(stay5){
							System.out.println("enter the Contractor ID: ");
							String ContractID=scanner.next();
							String haulierregex = "^[0-9]*$";
							Pattern haulierpattern = Pattern.compile(haulierregex);
							Matcher hauliermatcher = haulierpattern.matcher(ContractID);
							if( hauliermatcher.matches()) {
								int ContractID2=Integer.parseInt(ContractID);
								contractBean.setContractId(ContractID2);
								stay5=false;
							}else {
								System.err.println("please Enter the VALID Integer for CTID..!");
								stay5=true;
							}				
						}


						boolean stay7=true;
						while(stay7) {
							System.out.println("enter the Product ID: ");
							String ProductID=scanner.next();
							String ProductIDregex = "^[0-9]*$";
							Pattern ProductIDpattern = Pattern.compile(ProductIDregex);
							Matcher ProductIDmatcher = ProductIDpattern.matcher(ProductID);
							if(ProductIDmatcher.matches()) {
								int ProductID2=Integer.parseInt(ProductID);

								if(productDao.checkIsTherePID(ProductID2)) {
									contractBean.setProductId(ProductID2);
									stay7=false;
								}else {
									System.err.println("Currently This product is unavailabe..!");
									stay7=true;
								}
							}else {
								System.err.println("please Enter the VALID Integer for CID..!");
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
									contractBean.setHaulierId(haulier);
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
									contractBean.setDeliveryDate(date);
									stay1=false;
								}

							}else {
								System.err.println("Please Enter The Valid DATE-FORMATE..!");
								stay1=true;
							}

						}


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
									contractBean.setQunatity(quantity2);
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


						if(contractDao.addContarctor(contractBean)) {
							System.out.println("Contractor added successfully..!");
						}else {
							System.err.println("somthing went wrong, try again..!");
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
								ContractorBean coBean=contractDao.searchContarctor(ctidToSearch2);
								if(coBean==null) {
									throw new ContractorAppException("No such Contracts,please try another CTID");
								}else {
									System.out.println(coBean);
								}
							}
						}catch (ContractorAppException e) {
							String message=e.getMessage();
							System.err.println(message);
						}
						break;

					case 3:
						ContractorBean contractBean2=new ContractorBean();

						contractBean2.setCustomerId(cid);

						boolean stop5=true;
						while(stop5){
							System.out.println("enter the Contractor ID to update: ");
							String ContractID=scanner.next();
							String haulierregex = "^[0-9]*$";
							Pattern haulierpattern = Pattern.compile(haulierregex);
							Matcher hauliermatcher = haulierpattern.matcher(ContractID);
							if( hauliermatcher.matches()) {
								int ContractID2=Integer.parseInt(ContractID);
								contractBean2.setContractId(ContractID2);
								stop5=false;
							}else {
								System.err.println("please Enter the VALID Integer for CTID..!");
								stop5=true;
							}				
						}

						boolean stop7=true;
						while(stop7) {
							System.out.println("enter the Product ID to update: ");
							String ProductID=scanner.next();
							String ProductIDregex = "^[0-9]*$";
							Pattern ProductIDpattern = Pattern.compile(ProductIDregex);
							Matcher ProductIDmatcher = ProductIDpattern.matcher(ProductID);
							if(ProductIDmatcher.matches()) {
								int ProductID2=Integer.parseInt(ProductID);

								if(productDao.checkIsTherePID(ProductID2)) {
									contractBean2.setProductId(ProductID2);
									stop7=false;
								}else {
									System.err.println("Currently This product is unavailabe..!");
									stop7=true;
								}
							}else {
								System.out.println("please Enter the VALID Integer for CID..!");
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
									contractBean2.setHaulierId(haulier);
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
								contractBean2.setDeliveryDate(date);
								stop1=false;
							}else {
								System.err.println("Please Enter The Valid DATE-FORMATE to update..!");
								stop1=true;
							}

						}

						boolean stop3=true;
						while(stop3) {
							try{
								System.out.println("Enter the quantiy required to update: ");
								String quantity=scanner.next();
								String quantityregex = "^[0-9]*$";
								Pattern quantitypattern = Pattern.compile(quantityregex);
								Matcher quantitymatcher = quantitypattern.matcher(quantity);
								if(quantitymatcher.matches()) {
									int quantity2=Integer.parseInt(quantity);
									contractBean2.setQunatity(quantity2);
									stop3=false;
								}else {
									System.err.println("please Enter the VALID Integer for quantity..!");
									stay8=true;
								}
							}catch (ContractorAppException e) {
								System.err.println("please try again for Quantity");
								stop3=true;
							}
						}
						try {
							boolean isUpdated=contractDao.updateContarctor(contractBean2.getContractId(),contractBean2);
							if(isUpdated) {
								System.out.println("Done with updates");
							}else {
								throw new ContractorAppException("There is problem with updation, try again..!");
							}
						}catch (ContractorAppException e) {
							String message=e.getMessage();
							System.out.println(message);
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
								contractDao.deletecontarctor(contractBean3.getContractId());
							}else {
								throw new ContractorAppException("Please Enter The Valid CTID, an INTEGER..!");
							}
						}catch (Exception e) {
							String message=e.getMessage();
							System.err.println(message);
						}
						break;

					case 5:
						contractDao.getAllContarctor();
						break;

					case 6:
						FmDbHome.main(null);
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