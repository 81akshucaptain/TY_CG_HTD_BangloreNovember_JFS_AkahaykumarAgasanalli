package com.captain.Fm.Application;
import java.util.Scanner;
import com.captain.Fm.*;

import com.captain.Fm.Factory.ForestFactory;
import com.captain.Fm.bean.ContractorBean;
import com.captain.Fm.bean.CustomerBean;
import com.captain.Fm.DAO.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FmApplication1 {
	public static void customer(){
		CustomerDAO dao=ForestFactory.instanceOfCustomerDAOImpl();

		Scanner sc=new Scanner(System.in);


		while (true) {
			System.out.println("*******************WELCOME TO CUSTOMER HOUSE*********************");
			System.out.println("*Enter 1 to add the customer");
			System.out.println("*Enter 2 to search the customer");
			System.out.println("*Enter 3 to update the customer");
			System.out.println("*Enter 4 to remove the customer");
			System.out.println("*Enter 5 to get all the customer");
			System.out.println("*Enter 6 to Retur HOME");

			int option=sc.nextInt();


			switch (option) {
			case 1:
				CustomerBean cb=new CustomerBean();

				boolean stay1=true;
				while(stay1) {
					System.out.println("Enter customer Name: ");
					String name=sc.next();
					String nameregex = "^[A-Za-z]*";
					Pattern namepattern = Pattern.compile(nameregex);
					Matcher namematcher = namepattern.matcher(name);
					if( namematcher.matches()) {
						cb.setName(name);
						stay1=false;
					}else {
						System.err.println("please Enter the VALID NAME..!");
						stay1=true;
					}
				} 

				boolean stay2=true;
				while(stay2) 
				{
					System.out.println("Enter customer Town: ");
					String town=sc.next();
					String townregex = "^[A-Za-z]*";
					Pattern townpattern = Pattern.compile(townregex);
					Matcher townmatcher = townpattern.matcher(town);
					if( townmatcher.matches()) {
						cb.setTown(town);
						stay2=false;
					}else {
						System.err.println("please Enter the VALID TOWN NAME..!");
						stay2=true;
					}
				}

				boolean stay4=true;
				while(stay4) {
					System.out.println("Enter customer Email: ");
					String email=sc.next();
					String emailregex = "^(.+)@(.+)\\.(.+)$";
					Pattern emailpattern = Pattern.compile(emailregex);
					Matcher emailmatcher = emailpattern.matcher((CharSequence)email);
					if( emailmatcher.matches()) {
						cb.setEmail(email);
						stay4=false;
					}else {
						System.err.println("please Enter the VALID EMAIL ID..!");
						stay4=true;
					}
				}

				boolean stay3=true;
				while(stay3) {
					System.out.println("Enter customer Postal: ");
					int postal=sc.nextInt();
					String postal1=Integer.toString(postal);
					String postalregex = "^[0-9]{6}";
					Pattern postalpattern = Pattern.compile(postalregex);
					Matcher postalmatcher = postalpattern.matcher(postal1);
					if( postalmatcher.matches()) {
						cb.setPostal(postal);
						stay3=false;
					}else {
						System.err.println("please Enter the VALID POSTALCODE..!");
						stay3=true;
					}
				}

				boolean stay5=true;
				while(stay5) {
					System.out.println("Enter customer Phone: ");
					Long phone=sc.nextLong();
					String phone1=Long.toString(phone);
					String phoneregex = "^[789][0-9]{9}";
					Pattern phonepattern = Pattern.compile(phoneregex);
					Matcher phonematcher = phonepattern.matcher(phone1);
					if( phonematcher.matches()) {
						cb.setPhone(phone);
						stay5=false;
					}else {
						System.err.println("please Enter the VALID PHONE..!");
						stay5=true;
					}
				}
				if(dao.addCustomer(cb)) {
					System.out.println("Done with adding");
				}else {
					System.err.println("somthing went wrong buddy, try again..!");
				}
				break;

			case 2:
				System.out.println("enter the cid to search customer: ");
				int cid=sc.nextInt();
				CustomerBean cdetails=dao.searchCustomer(cid);
				System.out.println(cdetails);
				break;
			case 3:
				CustomerBean cb2=new CustomerBean();
				int cidToUpdate=0;
				boolean stay10=true;
				while(stay10) {

					System.out.println("Enter customer ID to update: ");
					try
					{
						int cid2=sc.nextInt();
						cidToUpdate=cid2;
						stay10=false;
					}
					catch (Exception e) {
						String msg1=e.getMessage();
						System.err.println(msg1+"please Enter the INTEGER value..!");
						stay10=true;
					}
				} 

				boolean stay11=true;
				while(stay11) {
					System.out.println("Enter customer Name to update: ");
					String name2=sc.next();
					String nameregex2 = "^[A-Za-z]*";
					Pattern namepattern = Pattern.compile(nameregex2);
					Matcher namematcher = namepattern.matcher(name2);
					if( namematcher.matches()) {
						cb2.setName(name2);
						stay11=false;
					}else {
						System.err.println("please Enter the VALID NAME..!");
						stay11=true;
					}
				} 

				boolean stay12=true;
				while(stay12) 
				{
					System.out.println("Enter customer Town to update: ");
					String town2=sc.next();
					String townregex = "^[A-Za-z]*";
					Pattern townpattern = Pattern.compile(townregex);
					Matcher townmatcher = townpattern.matcher(town2);
					if( townmatcher.matches()) {

						cb2.setTown(town2);
						stay12=false;
					}else {
						System.err.println("please Enter the VALID TOWN NAME..!");
						stay12=true;
					}
				}
				boolean stay14=true;
				while(stay14) {
					System.out.println("Enter customer Email to update: ");
					String email2=sc.next();
					String emailregex = "^(.+)@(.+)\\.(.+)$";
					Pattern emailpattern = Pattern.compile(emailregex);
					Matcher emailmatcher = emailpattern.matcher((CharSequence)email2);
					if( emailmatcher.matches()) {

						cb2.setEmail(email2);
						stay14=false;
					}else {
						System.err.println("please Enter the VALID EMAIL ID..!");
						stay14=true;
					}
				}

				boolean stay13=true;
				while(stay13) {
					System.out.println("Enter customer Postal to update: ");
					int postal2=sc.nextInt();
					String postal1=Integer.toString(postal2);
					String postalregex = "^[0-9]{6}";
					Pattern postalpattern = Pattern.compile(postalregex);
					Matcher postalmatcher = postalpattern.matcher(postal1);
					if( postalmatcher.matches()) {

						cb2.setPostal(postal2);
						stay13=false;
					}else {
						System.err.println("please Enter the VALID POSTALCODE..!");
						stay13=true;
					}
				}

				boolean stay15=true;
				while(stay15) {
					System.out.println("Enter customer Phone to update: ");
					long ph=sc.nextLong();
					String phone2=Long.toString(ph);
					String phoneregex = "^[0-9]{10}";
					Pattern phonepattern = Pattern.compile(phoneregex);
					Matcher phonematcher = phonepattern.matcher(phone2);
					if( phonematcher.matches()) {

						cb2.setPhone(ph);
						stay15=false;
					}else {
						System.err.println("please Enter the VALID PHONE..!");
						stay15=true;
					}
				}

				if(dao.updateCustomer(cidToUpdate, cb2)) {
					System.out.println(" GOOD DAY");
				}else System.err.println("somthing went wrong buddy, try again..!");
				break;

			case 4:
				System.out.println("Enter The Customer ID to delete the account:");

				try{
					int cidToDelete=sc.nextInt();
					boolean delete=dao.deleteCustomer(cidToDelete);
				}catch (Exception e) {
					System.err.println("Eneter the correct value..!");
				}

			case 5:
				dao.getAllCustomer();
				break;

			case 6:
				AdminHomeApllication.adminHome();
			default:
				break;
			}
		}



	}
}
