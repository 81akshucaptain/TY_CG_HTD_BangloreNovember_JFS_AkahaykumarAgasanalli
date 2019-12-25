package com.capgemini.foresterymanagement.application;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.foresterymanagement.bean.ContractorBean;
import com.capgemini.foresterymanagement.bean.ProductBean;
import com.capgemini.foresterymanagement.dao.*;
import com.capgemini.foresterymanagement.factory.ForestFactory;


public class FmApllication2 {
	public static void contract() {
		ContractorDAO cdao=ForestFactory.instanceOfContractorDAOImpl();
		ProductDAO proBean=new ProductDAOImpl();
		Scanner sc=new Scanner(System.in);
		while (true) {
			System.out.println("********************WELCOME CUSTOMER TO CONTRACT HOUSE********************");
			System.out.println("*Enter 1 to add the Contract");
			System.out.println("*Enter 2 to search the Contract");
			System.out.println("*Enter 3 to update the Contract");
			System.out.println("*Enter 4 to remove the Contract");
			System.out.println("*Enter 5 to get all the Contract");
			System.out.println("*Enter 6 to Logout");
			int option=sc.nextInt();


			switch (option) {
			case 1:
				ContractorBean cb=new ContractorBean();

				boolean stay4=true;
				while(stay4) {
					try{
						System.out.println("enter the Customer ID: ");
						cb.setCustomerId(sc.nextInt());
						stay4=false;
					}catch (Exception e) {
						System.err.println("Enter The Valid Integer For Quantity");
						stay4=true;
					}
				}

				//				boolean stay5=true;
				//				while(stay5) {
				//					try{
				//						System.out.println("enter the contract ID: ");
				//						cb.setContractorId(sc.nextInt());
				//						stay5=false;
				//					}catch (Exception e) {
				//						System.err.println("Enter The Valid Integer For Quantity");
				//						stay5=true;
				//					}
				//				}

				boolean stay7=true;
				while(stay7) {
					try{
						System.out.println("enter the Product ID: ");
						int proId=sc.nextInt();
						if(proId==00000) {
							FmApllication2.contract();
						}
						boolean product=proBean.isThereProductId(proId);
						if(product) {
						cb.setProductId(proId);
						stay7=false;
						
						}else {
							System.err.println("Ooops!! This product is out of Stock, try other product-Id's");
						}
					}catch (Exception e) {
						System.err.println("Enter The Valid Integer For Quantity");
						stay7=true;
					}
				}


				System.out.println("enter the haulier ID: ");
				cb.setHaulierId(sc.next());

				boolean stay1=true;
				while(stay1) {
					System.out.println("enter the delivery date in YYYY/MM/DD fromat: ");
					String date = sc.next();

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
							cb.setDeliveryDate(date);
							stay1=false;
						}

					}else {
						System.err.println("Please Enter The Valid DATE-FORMATE..!");
						stay1=true;
					}

				}

//				boolean stay2=true;
//				while(stay2) {
//					System.out.println("Enter The Delivery Day: ");
//					String DAY=sc.next();
//					if(DAY.equals("sunday")||DAY.equals("monday")||DAY.equals("tuesday")||DAY.equals("wednesday")||DAY.equals("thursday")||DAY.equals("friday")||DAY.equals("saturday")||
//							DAY.equals("SUNDAY")||DAY.equals("MONDAY")||DAY.equals("TUESDAY")||DAY.equals("WEDNESDAY")||DAY.equals("THURSDAY")||DAY.equals("FRIDAY")||DAY.equals("SATURDAY")) 
//					{
//						cb.setDeliveryDay(DAY);
//						stay2=false;
//					}else {
//						System.err.println("Please enter the valid DAY...!");
//						stay2=true;
//					}
//				}
				boolean stay3=true;
				while(stay3) {
					try{
						System.out.println("enter the quantiy required: ");
						cb.setQunatity(sc.nextInt());
						stay3=false;
					}catch (Exception e) {
						System.err.println("Enter The Valid Integer For Quantity");
						stay3=true;
					}
				}

				if(cdao.addContarctor(cb)) {
					System.out.println("contract added successfully..!");
				}else {
					System.err.println("somthing went wrong buddy, try again..!");
				}
				break;

			case 2:
				System.out.println("enter the contractID to search Contract: ");

				try{
					int ctid=sc.nextInt();
					ContractorBean cdetails=cdao.searchContarctor(ctid);
					System.out.println("The details of Contract with "+ctid+" is:");
					System.out.println(cdetails);
				}catch (Exception e) {
					System.out.println("Please enter the valid contract ID: ");
				}
				break;
			case 3:
				ContractorBean cb2=new ContractorBean();
				int ctid = 0;
				boolean stop5=true;
				while(stop5) {
					try{
						System.out.println("enter the Contract ID To Update:: ");
						ctid=sc.nextInt();
						stop5=false;
					}catch (Exception e) {
						System.err.println("Enter The Valid Integer For Quantity");
						stop5=true;
					}
				}

				boolean stop4=true;
				while(stop4) {
					try{
						System.out.println("enter the Customer ID To Update: ");
						cb2.setCustomerId(sc.nextInt());
						stop4=false;
					}catch (Exception e) {
						System.err.println("Enter The Valid Integer For Quantity");
						stop4=true;
					}
				}


				boolean stop7=true;
				while(stop7) {
					try{
						System.out.println("enter the Product ID To Update:: ");
						cb2.setProductId(sc.nextInt());
						stop7=false;
					}catch (Exception e) {
						System.err.println("Enter The Valid Integer For Quantity");
						stop7=true;
					}
				}


				System.out.println("enter the haulier ID To Update: ");
				cb2.setHaulierId(sc.next());

				boolean stop1=true;
				while(stop1) {
					System.out.println("enter the delivery date in YYYY/MM/DD fromat To Update: ");
					String date = sc.next();

					String regex = "^[0-9]{4}/(1[0-2]|0[1-9])/(3[01]"
							+ "|[12][0-9]|0[1-9])$"; 
					Pattern pattern = Pattern.compile(regex); 
					Matcher matcher = pattern.matcher((CharSequence)date);
					if(matcher.matches()) {
						cb2.setDeliveryDate(date);
						stop1=false;
					}else {
						System.err.println("Please Enter The Valid DATE-FORMATE..!");
						stop1=true;
					}

				}

//				boolean stop2=true;
//				while(stop2) {
//					System.out.println("Enter The Delivery Day To Update: ");
//					String DAY=sc.next();
//					if(DAY.equals("sunday")||DAY.equals("monday")||DAY.equals("tuesday")||DAY.equals("wednesday")||DAY.equals("thursday")||DAY.equals("friday")||DAY.equals("saturday")||
//							DAY.equals("SUNDAY")||DAY.equals("MONDAY")||DAY.equals("TUESDAY")||DAY.equals("WEDNESDAY")||DAY.equals("THURSDAY")||DAY.equals("FRIDAY")||DAY.equals("SATURDAY")) 
//					{
//						cb2.setDeliveryDay(DAY);
//						stop2=false;
//					}else {
//						System.err.println("Please enter the valid DAY...!");
//						stop2=true;
//					}
//				}

				boolean stop3=true;
				while(stop3) {
					try{
						System.out.println("enter the quantiy required To Update: ");
						cb2.setQunatity(sc.nextInt());
						stop3=false;
					}catch (Exception e) {
						System.err.println("Enter The Valid Integer For Quantity");
						stop3=true;
					}
				}
				cdao.updateContarctor(ctid,cb2);
				break;

			case 4:

				try{
					System.out.println("Enter The Contract ID to delete the account:");
					int cidToDelete=sc.nextInt();
					boolean delete=cdao.deletecontarctor(cidToDelete);
					if(delete) {
						System.out.println("The specified Contrcat got deleted");
					}else {
						System.err.println("Please enter the valid contractID, problem in deletion");
					}
				}catch (Exception e) {
					System.err.println("Please enter the valid contractID:");
				}
				break;
			case 5:
				cdao.getAllContarctor();
				break;
			case 6:
				FmHome.main(null);

			}
		}
	}
}