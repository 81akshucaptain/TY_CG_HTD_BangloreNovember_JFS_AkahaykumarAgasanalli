package com.capgemini.forestmanagementjpa.apps;

import java.util.Scanner;
import com.capgemini.forestmanagementjpa.dto.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.capgemini.forestmanagementjpa.dao.*;
import com.capgemini.forestmanagementjpa.exceptions.*;
import com.capgemini.forestmanagementjpa.factory.*;


public class LandsApplication {
public void lands() {	
	LandsDAO land=ForestFactoryFmJpa.createInstanceOfLandsDAOImpl();
		Scanner scanner=new Scanner(System.in);
		while(true) {
			try {
				System.out.println("1.Enter one to Add land details");
				System.out.println("2.Enter two to Search land details");
				System.out.println("3.Enter three to Update land details");
				System.out.println("4.Enter four to Delete land details");
				System.out.println("5.Enter five to get All land details");
				System.out.println("6.Enter six to return home");
				String choice1=scanner.next();
				String choice1IDregex = "^[0-9]*$";
				Pattern choice1IDpattern = Pattern.compile(choice1IDregex);
				Matcher choice1IDmatcher = choice1IDpattern.matcher(choice1);
				if( choice1IDmatcher.matches()) {
					int	choice2=Integer.parseInt(choice1);

					switch (choice2) {
					case 1:
						LandsBean landBean1=new LandsBean();

						boolean stay1=true;
						while(stay1) {
							try{
								System.out.println("Enter ID of Land: ");
								String landId1=scanner.next();
								String sizeregex = "^[0-9]*";
								Pattern sizepattern = Pattern.compile(sizeregex);
								Matcher sizematcher = sizepattern.matcher(landId1);
								if( sizematcher.matches()) {
									Integer landId=Integer.parseInt(landId1);
									if(landId>0) {
										landBean1.setLandId(landId);
										stay1=false;
									}else {
										throw new LandsAppException("Enter the value which must be greater than zero..!");
									}
								}else {
									System.err.println("please Enter the VALID land-Id (An Integer)..!");
									stay1=true;
								}
							}catch(LandsAppException e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						} 				


						boolean stay2=true;
						while(stay2) {
							try{
								System.out.println("Enter Land size (In-acres): ");

								String size=scanner.next();
								String sizeregex = "^[0-9]*";
								Pattern sizepattern = Pattern.compile(sizeregex);
								Matcher sizematcher = sizepattern.matcher(size);
								if( sizematcher.matches()) {
									if(!(size.equals(0))) {
										landBean1.setLandSize(size);
										stay2=false;
									}else {
										throw new LandsAppException("Enter the value which must be greater than zero..!");
									}
								}else {
									System.err.println("please Enter the VALID Land size..!");
									stay2=true;
								}
							}catch(LandsAppException e) {
								String message=e.getMessage();
								System.err.println(message);
							}
						} 				
						boolean stay4=true;
						while(stay4) {
							System.out.println("Enter Land Location: ");
							String location=scanner.next();
							String resourcesregex = "^[A-Za-z]*";
							Pattern resourcespattern = Pattern.compile(resourcesregex);
							Matcher resourcesmatcher = resourcespattern.matcher(location);
							if( resourcesmatcher.matches()) {
								landBean1.setLandLocation(location);
								stay4=false;
							}else {
								System.err.println("please Enter the VALID landLocation..!");
								stay4=true;
							}
						} 
						boolean stay3=true;
						while(stay3) {
							System.out.println("Enter Land Resources: ");
							String resources=scanner.next();
							String resourcesregex = "^[A-Za-z]*";
							Pattern resourcespattern = Pattern.compile(resourcesregex);
							Matcher resourcesmatcher = resourcespattern.matcher(resources);
							if( resourcesmatcher.matches()) {
								landBean1.setLandResources(resources);
								stay3=false;
							}else {
								System.err.println("please Enter the VALID Resources..!");
								stay3=true;
							}
						} 
						boolean add=land.addLands(landBean1);
						if(add) {
							System.out.println("Added..successfully..!");
						}else {
							System.err.println("failed to add land details ");
						}
						break;

					case 2:
						boolean s_stay=true;
						try{
							System.out.println("enter the LandID to search Lnad: ");
							String LandToSearch=scanner.next();
							String LandToSearchregex = "^[0-9]*$";
							Pattern LandToSearchpattern = Pattern.compile(LandToSearchregex);
							Matcher LandToSearchmatcher = LandToSearchpattern.matcher(LandToSearch);
							if(LandToSearchmatcher.matches()) {
								Integer LandToSearch2=Integer.parseInt(LandToSearch);
								if(LandToSearch2>0) {
									LandsBean lBean= land.searchLands(LandToSearch2);
									System.out.println(lBean);
								}else {
									s_stay=true;
									throw new ProductAppException("Enter vallid Land Id to search, must be positive");
								}
							}else {
								s_stay=true;
								throw new ProductAppException("Enter vallid Land Id to search,must be an Integer");
							}
						}catch (ProductAppException e) {
							String message=e.getMessage();
							System.err.println(message);
						}
						break;	

					case 3:
						LandsBean landBean2=new LandsBean();

						boolean stay8=true;
						while(stay8) {
							System.out.println("Enter ID of Land to update: ");
							String landId1=scanner.next();
							String sizeregex = "^[0-9]*";
							Pattern sizepattern = Pattern.compile(sizeregex);
							Matcher sizematcher = sizepattern.matcher(landId1);
							if( sizematcher.matches()) {
								Integer landId=Integer.parseInt(landId1);
								if(landId>0) {
									landBean2.setLandId(landId);
									stay8=false;
								}else {
									System.err.println("enter the Positive value, must be greater than zero..!");
								}
							}else {
								System.err.println("please Enter the VALID land-Id (An Integer)..!");
								stay8=true;
							}
						} 				

						boolean stay7=true;
						while(stay7) {
							System.out.println("Enter Land Location to update: ");
							String location=scanner.next();
							String resourcesregex = "^[A-Za-z]*";
							Pattern resourcespattern = Pattern.compile(resourcesregex);
							Matcher resourcesmatcher = resourcespattern.matcher(location);
							if( resourcesmatcher.matches()) {
								landBean2.setLandLocation(location);
								stay7=false;
							}else {
								System.err.println("please Enter the VALID landLocation..!");
								stay7=true;
							}
						} 
						boolean stay5=true;
						while(stay5) {
							System.out.println("Enter Land size (In-acres) to update: ");
							String size=scanner.next();
							String sizeregex = "^[0-9]*";
							Pattern sizepattern = Pattern.compile(sizeregex);
							Matcher sizematcher = sizepattern.matcher(size);
							if( sizematcher.matches()) {
								if(!(size.equals(0))){
									landBean2.setLandSize(size);
									stay5=false;
								}else {
									System.err.println("Enter positive value value..");
								}
							}else {
								System.err.println("please Enter the VALID Land size..!");
								stay5=true;
							}
						} 				

						boolean stay6=true;
						while(stay6) {
							System.out.println("Enter Land Resources to update: ");
							String resources=scanner.next();
							String resourcesregex = "^[A-Za-z]*";
							Pattern resourcespattern = Pattern.compile(resourcesregex);
							Matcher resourcesmatcher = resourcespattern.matcher(resources);
							if( resourcesmatcher.matches()) {
								landBean2.setLandResources(resources);
								stay6=false;
							}else {
								System.err.println("please Enter the VALID Resources..!");
								stay6=true;
							}
						} 
						boolean update=land.updateLands(landBean2.getLandId(), landBean2);
						if(update) {
							System.out.println("Updated..GOOD DAY");
						}else {
							System.out.println("Failed to update");
						}
						break;

					case 4:
						try {
							System.out.println("Enter The Land-ID to delete land:");
							String landToDelete=scanner.next();
							String landToDeleteregex = "^[0-9]*$";
							Pattern landToDeletepattern = Pattern.compile(landToDeleteregex);
							Matcher landToDeletematcher = landToDeletepattern.matcher(landToDelete);
							if(landToDeletematcher.matches()) {	
								Integer landToSearch2=Integer.parseInt(landToDelete);
								if(land.deleteLands(landToSearch2)) {
									System.out.println("Done with deletion..!");	
								}else {
									System.err.println("No such LandId,try again");
								}
							}else {
								throw new LandsAppException("Please Enter The Valid landId, an INTEGER..!");
							}
						}catch (LandsAppException e) {
							String message=e.getMessage();
							System.err.println(message);
						}
						break;
					case 5:
						land.getAllLands();
						break;
//					case 6:
//						AdminApp app=new AdminApp();
//						app.adminMain();
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