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
	void customer(){


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
					String phoneregex = "^[0-9]{10}";
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
					System.out.println("Contractor added successfully..!");
				}else System.err.println("somthing went wrong buddy, try again..!");
				break;

			case 2:
				System.out.println("print the cid to search Customer: ");
				int cid=sc.nextInt();
				CustomerBean cdetails=dao.searchCustomer(cid);
				System.out.println("The details of Customer with"+cid+"is:");
				System.out.println(cdetails);
				break;
			case 3:
				System.out.println("enter the CID to update:");
				int cidToUpdate =sc.nextInt();
				CustomerBean cb2=new CustomerBean();
				System.out.println("Enter name to update:");
				cb2.setName(sc.next());
				System.out.println("Enter town to update:");
				cb2.setTown(sc.next());
				System.out.println("Enter psotal to update:");
				cb2.setPostal(sc.nextInt());
				System.out.println("Enter email to update:");
				cb2.setEmail(sc.next());
				System.out.println("Enter phone to update:");
				cb2.setPhone(sc.nextLong());
				boolean update=dao.updateCustomer(cidToUpdate,cb2);
				if(update==true) {
					System.out.println("New details added successfully..!");
				}else System.err.println("Something went wrong to update..!");
				break;
			case 4:
				System.out.println("Enter The Customer ID to delete the account:");
				int cidToDelete=sc.nextInt();
				boolean delete=dao.deleteCustomer(cidToDelete);

			case 5:
				dao.getAllCustomer();

			case 6:
				MainApllication m=new MainApllication();
				m.main(null);
			default:
				break;
			}
		}



	}
}
