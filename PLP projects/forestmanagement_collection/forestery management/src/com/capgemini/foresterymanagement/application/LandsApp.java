package com.capgemini.foresterymanagement.application;

import java.awt.print.PrinterAbortException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.foresterymanagement.bean.CustomerBean;
import com.capgemini.foresterymanagement.bean.LandsBean;
import com.capgemini.foresterymanagement.dao.LandsDAO;
import com.capgemini.foresterymanagement.factory.ForestFactory;
import com.capgemini.foresterymangement.validation.Validations;
import com.capgemini.foresterymanagement.exception.*;

public class LandsApp {

	public static void land() {
		while(true)
		{
			try {		
				LandsDAO landDao=ForestFactory.InstanceOfLandDAOImpl();
				Scanner scanner=new Scanner(System.in);
				System.out.println("           ::::WELCOME TO LAND OPERATIONS::::");
				System.out.println("1.Enter one to Add land details");
				System.out.println("2.Enter two to Search land details");
				System.out.println("3.Enter three to Update land details");
				System.out.println("4.Enter four to Delete land details");
				System.out.println("5.Enter five to get All land details");
				System.out.println("6.Enter six to return home");

				String choice1=scanner.next();
				if(Validations.numberValidation(choice1)){
					int	choice2=Integer.parseInt(choice1);

					switch (choice2) {

					case 1:
						LandsBean landBean=new LandsBean();

						boolean stay5=true;
						while(stay5) {
							try{
								System.out.println("Enter Land Location: ");
								String location=scanner.next();
								if(Validations.alphabetsValidation(location)){
									landBean.setlandLocation(location);
									stay5=false;
								}
							}catch (VallidationExceptionFMS e) {
								String message=e.getMessage();
								System.err.println(message);
							}

						} 


						boolean stay2=true;
						while(stay2) {
							try{
								System.out.println("Enter Land size (In-acres): ");
								String size=scanner.next();
								if(Validations.numberValidation(size)) {
									landBean.setLandSize(size);
									stay2=false;
								}
							}catch (VallidationExceptionFMS e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						} 				


						boolean stay3=true;
						while(stay3) {
							try{
								System.out.println("Enter Land Resources (Product Names): ");
								String resources=scanner.next();
								if(Validations.alphabetsValidation(resources)) {
									landBean.setLandResources(resources);
									stay3=false;
								}
							}catch (VallidationExceptionFMS e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						} 

						try{
							boolean add=landDao.addLands(landBean);
							if(add) {
								System.out.println("Land With LandId : "+landBean.getLandId()+" AddedSuccessfully");
							}
						}catch (LandsAppException e) {
							String message=e.getMessage();
							System.err.println(message);
						}
						break;


					case 2:
						boolean s_stay=true;
						try{
							System.out.println("enter the LandID to search Lnad: ");
							String LandToSearch=scanner.next();
							if(Validations.numberValidation(LandToSearch)){
								Integer LandToSearch2=Integer.parseInt(LandToSearch);
								if(LandToSearch2>0) {
									LandsBean lBean=landDao.searchLands(LandToSearch2);
									if(lBean!=null) {
										System.out.println(lBean);
									}else {
										throw new PrinterAbortException("Land doesn't exist..!");
									}
								}else {
									s_stay=true;
									throw new ProductAppException("Enter vallid Land Id to search, must be positive");
								}
							}
						}catch (Exception e) {
							String message=e.getMessage();
							System.err.println(message);
						}
						break;	

					case 3:
						LandsBean landBean2=new LandsBean();

						boolean stay4=true;
						while(stay4) {
							try{
								System.out.println("Enter ID of Land to update: ");
								String landId1=scanner.next();
								if(Validations.numberValidation(landId1)) {
									Integer landId=Integer.parseInt(landId1);
									if(landId>0) {
										landBean2.setLandId(landId);
										stay4=false;
									}else {
										System.err.println("enter the Positive value, must be greater than zero..!");
									}
								}
							}catch (VallidationExceptionFMS e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						}

						boolean stay=true;
						while(stay) {
							try{
								System.out.println("Enter Land Location to update: ");
								String location=scanner.next();
								if(Validations.alphabetsValidation(location)) {
									landBean2.setlandLocation(location);
									stay=false;
								}
							}catch (VallidationExceptionFMS e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						} 

						boolean stay9=true;
						while(stay9) {
							try{
								System.out.println("Enter Land size (In-acres) to update: ");
								String size=scanner.next();
								if(Validations.numberValidation(size)) {
									landBean2.setLandSize(size);
									stay9=false;
								}
							}catch (VallidationExceptionFMS e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						} 				

						boolean stay6=true;
						while(stay6) {
							try{
								System.out.println("Enter Land Resources to update: ");
								String resources=scanner.next();
								if(Validations.alphabetsValidation(resources)) {
									landBean2.setLandResources(resources);
									stay6=false;
								}
							}catch (Exception e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						} 

						try{
							boolean update=landDao.updateLands(landBean2.getLandId(), landBean2);
							if(update) {
								System.out.println("New Data Updated..GOOD DAY");
							}
						}catch (LandsAppException e) {
							String message=e.getMessage();
							System.err.println(message);
						}
						break;

					case 4:
						try {
							System.out.println("Enter The Land-ID to delete land:");
							String landToDelete=scanner.next();
							if(Validations.numberValidation(landToDelete)) {	
								Integer landToSearch2=Integer.parseInt(landToDelete);
								if(landDao.deleteLands(landToSearch2)) {
									System.out.println("Given LandId With Details Got Deleted..!");	
								}
							}
						}catch (Exception e) {
							String message=e.getMessage();
							System.err.println(message);
						}
						break;

					case 5:
						try {
							HashMap<Integer,LandsBean>	allContracts=landDao.getAllLands();
							Set<Integer> keys=allContracts.keySet();
							for (Integer key : keys) {
								LandsBean conBean=allContracts.get(key);
								System.out.println(conBean);
							}
						}catch (LandsAppException e) {
							String message=e.getMessage();
							System.err.println(message);
						}
						break;

					case 6:
						AdminHomeApllication.adminHome();

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





