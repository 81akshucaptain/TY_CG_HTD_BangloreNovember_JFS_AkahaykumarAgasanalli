package com.capgemini.fmdb.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.fmbd.dao.ContractorDAO;
import com.capgemini.fmbd.dao.ProductDAO;
import com.capgemini.fmdb.bean.ContractorBean;
import com.capgemini.fmdb.factory.ForestFactoryFmDb;

public class ContractorApplication {
	void contractor(int cid) {
		ContractorDAO cdao=ForestFactoryFmDb.createInstanceOfContractorDAOImpl();
		ProductDAO pdao=ForestFactoryFmDb.createInstanceOfProductDAOImpl();
		Scanner sc=new Scanner(System.in);
		while (true) {
			System.out.println("********************WELCOME TO CONTRACTOR HOUSE********************");
			System.out.println("*Enter 1 to add the Contractor");
			System.out.println("*Enter 2 to search the Contractor");
			System.out.println("*Enter 3 to update the Contractor");
			System.out.println("*Enter 4 to remove the Contractor");
			System.out.println("*Enter 5 to get all the Contractor");
			System.out.println("*Enter 6 to Logout");
			int option=sc.nextInt();


			switch (option) {
			case 1:
				ContractorBean cb=new ContractorBean();

				boolean stay4=true;
				while(stay4) {
					try{
						System.out.println("enter the Customer ID: ");
						int cid2=sc.nextInt();
						if(cid==cid2) {
							cb.setCustomerId(cid2);
							stay4=false;
						}else {
							System.err.println("It might be others customer-ID,please enter your CustomerID");
							stay4=true;
						}
					}catch (Exception e) {
						System.err.println("Enter The Valid Integer For Quantity");
						stay4=true;
					}
				}
				boolean stay5=true;
				while(stay5) {
					try{
						System.out.println("enter the Contractor ID: ");
						cb.setContractId(sc.nextInt());
						stay5=false;
					}catch (Exception e) {
						System.err.println("Enter The Valid Integer For Quantity");
						stay5=true;
					}
				}

				boolean stay7=true;
				while(stay7) {
					try{
						System.out.println("enter the Product ID: ");
						int pid=sc.nextInt();
						if(pdao.checkIsTherePID(pid)) {
							cb.setProductId(pid);
							stay7=false;
						}else {
							System.err.println("Currently This product is unavailabe..!");
							stay7=true;
						}
					}catch (Exception e) {
						System.err.println("Enter The Valid Integer For Quantity");
						stay7=true;
					}
				}

				boolean stay3=true;
				while(stay3) {
					System.out.println("enter the haulier ID:(ex: KA 25 FB 4512) ");
					String haulier=sc.nextLine();
					String haulierregex = "^[A-Z]{2} [0-9]{2} [A-Z]{2} [0-9]{4}$";
					Pattern haulierpattern = Pattern.compile(haulierregex);
					Matcher hauliermatcher = haulierpattern.matcher(haulier);
					if( hauliermatcher.matches()) {
						cb.setHaulierId(haulier);
						stay3=false;
					}else {
						System.err.println("please Enter the VALID Hualier ID..!");
						stay3=true;
					}
				} 

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


				boolean stay8=true;
				while(stay8) {
					try{
						System.out.println("enter the quantiy required: ");
						cb.setQunatity(sc.nextInt());
						stay8=false;
					}catch (Exception e) {
						System.err.println("Enter The Valid Integer For Quantity");
						stay8=true;
					}
				}


				if(cdao.addContarctor(cb)) {
					System.out.println("Contractor added successfully..!");
				}else {
					System.err.println("somthing went wrong buddy, try again..!");
				}
				break;

			case 2:
				System.out.println("enter the contractorID to search Contractor: ");
				int ctid=sc.nextInt();
				ContractorBean coBean=cdao.searchContarctor(ctid);
				System.out.println(coBean);
				break;
			case 3:
				ContractorBean cb2=new ContractorBean();

				boolean stop5=true;
				while(stop5) {
					try{
						System.out.println("enter the Contractor ID To Update:: ");
						cb2.setContractId(sc.nextInt());
						stop5=false;
					}catch (Exception e) {
						System.err.println("Enter The Valid Integer For ContractID");
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
						System.err.println("Enter The Valid Integer For Customer-ID");
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
						System.err.println("Enter The Valid Integer For Product-Id");
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
						System.err.println("Please Enter The Valid DATE-FORMATE to update..!");
						stop1=true;
					}

				}

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
				cdao.updateContarctor(cb2.getContractId(),cb2);
				break;

			case 4:
				ContractorBean cb3=new ContractorBean();
				try {
					System.out.println("enter your CTID To Delete: ");
					cb3.setContractId(sc.nextInt());
				}catch (Exception e) {
					System.err.println("Please Enter The Valid CID in INTEGER..!");
				}
				cdao.deletecontarctor(cb3.getContractId());
				break;

			case 5:
				cdao.getAllContarctor();
				break;

			case 6:
				FmDbHome.main(null);
			}
		}
	}
}