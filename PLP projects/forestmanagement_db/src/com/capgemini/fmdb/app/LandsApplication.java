package com.capgemini.fmdb.app;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.fmbd.dao.LandsDAO;
import com.capgemini.fmdb.bean.LandsBean;
import com.capgemini.fmdb.factory.ForestFactoryFmDb;

public class LandsApplication {
	public void land() {
		LandsDAO land=ForestFactoryFmDb.createInstanceOfLandsDAOImpl();
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("1.Enter one to Add land details");
			System.out.println("2.Enter two to Search land details");
			System.out.println("3.Enter three to Update land details");
			System.out.println("4.Enter four to Delete land details");
			System.out.println("5.Enter five to get All land details");
			System.out.println("6.Enter six to return home");
			int choice=sc.nextInt();
			switch (choice) {
			case 1:
				LandsBean land1=new LandsBean();

				boolean stay1=true;
				while(stay1) {
					System.out.println("Enter ID of Land: ");
					Integer landId=sc.nextInt();
					String landId1=landId.toString();
					String sizeregex = "^[0-9]*";
					Pattern sizepattern = Pattern.compile(sizeregex);
					Matcher sizematcher = sizepattern.matcher(landId1);
					if( sizematcher.matches()) {
						land1.setLandId(landId);
						stay1=false;
					}else {
						System.err.println("please Enter the VALID land-Id (An Integer)..!");
						stay1=true;
					}
				} 				


				boolean stay2=true;
				while(stay2) {
					System.out.println("Enter Land size (In-acres): ");
					String size=sc.next();
					String sizeregex = "^[0-9]*";
					Pattern sizepattern = Pattern.compile(sizeregex);
					Matcher sizematcher = sizepattern.matcher(size);
					if( sizematcher.matches()) {
						land1.setLandSize(size);
						stay2=false;
					}else {
						System.err.println("please Enter the VALID Land size..!");
						stay2=true;
					}
				} 				

				boolean stay3=true;
				while(stay3) {
					System.out.println("Enter Land Resources: ");
					String resources=sc.next();
					String resourcesregex = "^[A-Za-z]*";
					Pattern resourcespattern = Pattern.compile(resourcesregex);
					Matcher resourcesmatcher = resourcespattern.matcher(resources);
					if( resourcesmatcher.matches()) {
						land1.setLandResources(resources);
						stay3=false;
					}else {
						System.err.println("please Enter the VALID Resources..!");
						stay3=true;
					}
				} 
				boolean add=land.addLands(land1);
				if(add) {
					System.out.println("Added..successfully..!");
				}else {
					System.err.println("adding land details failed");
				}
				break;

			case 2:
				boolean s_stay=true;
				while(s_stay) {
					try{
						System.out.println("enter the LandsID to search Lands: ");
						int pid=sc.nextInt();
						LandsBean Lands= land.searchLands(pid);
						if(Lands!=null) {
							System.out.println(Lands);
						}else {
							System.err.println("There is no Land details with mentioned ID");
						}
						s_stay=false;
					}catch (Exception e) {
						System.out.println("Please enter the valid input");
						s_stay=true;
					}
				}
				break;
			case 3:
				LandsBean land2=new LandsBean();

				boolean stay4=true;
				while(stay4) {
					System.out.println("Enter ID of Land to update: ");
					Integer landId=sc.nextInt();
					String landId1=landId.toString();
					String sizeregex = "^[0-9]*";
					Pattern sizepattern = Pattern.compile(sizeregex);
					Matcher sizematcher = sizepattern.matcher(landId1);
					if( sizematcher.matches()) {
						land2.setLandId(landId);
						stay4=false;
					}else {
						System.err.println("please Enter the VALID land-Id (An Integer)..!");
						stay4=true;
					}
				} 				


				boolean stay5=true;
				while(stay5) {
					System.out.println("Enter Land size (In-acres) to update: ");
					String size=sc.next();
					String sizeregex = "^[0-9]*";
					Pattern sizepattern = Pattern.compile(sizeregex);
					Matcher sizematcher = sizepattern.matcher(size);
					if( sizematcher.matches()) {
						land2.setLandSize(size);
						stay5=false;
					}else {
						System.err.println("please Enter the VALID Land size..!");
						stay5=true;
					}
				} 				

				boolean stay6=true;
				while(stay6) {
					System.out.println("Enter Land Resources to update: ");
					String resources=sc.next();
					String resourcesregex = "^[A-Za-z]*";
					Pattern resourcespattern = Pattern.compile(resourcesregex);
					Matcher resourcesmatcher = resourcespattern.matcher(resources);
					if( resourcesmatcher.matches()) {
						land2.setLandResources(resources);
						stay6=false;
					}else {
						System.err.println("please Enter the VALID Resources..!");
						stay6=true;
					}
				} 
				boolean update=land.updateLands(land2.getLandId(), land2);
				if(update) {
					System.out.println("Updated..GOOD DAY");
				}else {
					System.out.println("Failed to update");
				}
				break;

			case 4:
				System.out.println("Enter The Land-ID to delete land:");
				try {
					int lidToDelete=sc.nextInt();
					boolean isDeleted=land.deleteLands(lidToDelete);
					if(isDeleted) {
						System.out.println("The Land with Lands-ID: "+lidToDelete+" deleted successfully");
					}else {
						System.err.println("Land-ID not found..!");
					}
				}catch (Exception e) {
					System.err.println("Please enter the valid input..!");
				}
				
				break;
			case 5:
				land.getAllLands();
				break;
			case 6:
				AdminApp app=new AdminApp();
				app.adminMain();

			}
		}
	}
}