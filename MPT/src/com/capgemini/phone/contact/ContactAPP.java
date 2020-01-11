package com.capgemini.phone.contact;

import java.lang.invoke.SwitchPoint;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.phone.contactDAO.ContactDAO;
import com.capgemini.phone.contactFactory.ContactFactory;
import com.capgemini.phone.contact_bean.ContactBean;

public class ContactAPP {
	public static void main(String[] args) {

		ContactDAO cdao=ContactFactory.createInstanceOfContactDAOImpl();

		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("*Enter 1 to Dispalay All contact:");
			System.out.println("*Enter 2 to Search Contact:");
			System.out.println("*Enter 3 to Operate On Contacts:");

			int ch=sc.nextInt();

			switch(ch) {
			case 1:
				cdao.getAllContacts();
				break;
			case 2:
				System.out.println("Enter the contact name to search:");
				String name=sc.next();
				cdao.searchContact(name);
				System.out.println("enter 1 to call");
				System.out.println("enter 2 to message");
				System.out.println("enter 3 to video call");
				int key=sc.nextInt();

				switch (key) {
				case 1:
					System.out.println("CALLING TO "+name);
					break;
				case 2: 
					System.out.println("MESSAGE SENT TO "+name);
					break;
				case 3:
					System.out.println("CONNECTING VIDEO CALL TO "+name);
					break;
				default: System.err.println("Enter the valid choice..!");
				break;
				}
				break;
			case 3:
				System.out.println("Enter 1 to Add Contact:");
				System.out.println("Enter 2 to Delete Contact:");
				System.out.println("Enter 3 to Update Contact:");
				int key2=sc.nextInt();
				switch (key2) {
				case 1:
					ContactBean cb=new ContactBean();
					boolean stay2=true;
					while(stay2) 
					{
						System.out.println("Enter contact name: ");
						String name1=sc.next();
						String townregex = "^[A-Za-z]*";
						Pattern townpattern = Pattern.compile(townregex);
						Matcher townmatcher = townpattern.matcher(name1);
						if( townmatcher.matches()) {

							cb.setName(name1);
							stay2=false;
						}else {
							System.err.println("please Enter the VALID  NAME..!");
							stay2=true;
						}
					}

					boolean stay5=true;
					while(stay5) {
						System.out.println("Enter 10 digit phone number: ");
						String phone=sc.next();
						String phoneregex = "^[789][0-9]{9}$";
						Pattern phonepattern = Pattern.compile(phoneregex);
						Matcher phonematcher = phonepattern.matcher(phone);
						if( phonematcher.matches()) {

							cb.setNumber(phone);
							stay5=false;
						}else {
							System.err.println("please Enter the VALID PHONE NUMBER..!");
							stay5=true;
						}
					}

					boolean stay3=true;
					while(stay3) 
					{
						System.out.println("Enter contact group: ");
						String group=sc.next();
						String townregex = "^[A-Za-z]*";
						Pattern townpattern = Pattern.compile(townregex);
						Matcher townmatcher = townpattern.matcher(group);
						if( townmatcher.matches()) {

							cb.setGroup(group);
							stay3=false;
						}else {
							System.err.println("please Enter the VALID  GROUP-NAME..!");
							stay3=true;
						}
					}

					cdao.addContact(cb);

					break;

				default:System.err.println("Enter the valid choice");
				break;

				case 2: System.out.println("enter the name to delete:");
				String name3=sc.next();
				cdao.deleteContact(name3);
				break;

				case 3: 
					ContactBean cb2=new ContactBean();

					boolean stay10=true;
					while(stay10) 
					{
						System.out.println("Enter contact name to update: ");
						String name4=sc.next();
						String townregex = "^[A-Za-z]*";
						Pattern townpattern = Pattern.compile(townregex);
						Matcher townmatcher = townpattern.matcher(name4);
						if( townmatcher.matches()) {

							cb2.setName(name4);
							stay10=false;
						}else {
							System.err.println("please Enter the VALID  NAME..!");
							stay10=true;
						}
					}

					boolean stay11=true;
					while(stay11) {
						System.out.println("Enter 10 digit phone number update: ");
						String phone4=sc.next();
						String phoneregex = "^[789][0-9]{9}$";
						Pattern phonepattern = Pattern.compile(phoneregex);
						Matcher phonematcher = phonepattern.matcher(phone4);
						if( phonematcher.matches()) {

							cb2.setNumber(phone4);
							stay11=false;
						}else {
							System.err.println("please Enter the VALID PHONE NUMBER..!");
							stay11=true;
						}
					}

					/*boolean stay12=true;
					while(stay12) 
					{
						System.out.println("Enter contact group to update: ");
						String group4=sc.next();
						String townregex = "^[A-Za-z]*";
						Pattern townpattern = Pattern.compile(townregex);
						Matcher townmatcher = townpattern.matcher(group4);
						if( townmatcher.matches()) {

							cb2.setGroup(group4);
							stay12=false;
						}else {
							System.err.println("please Enter the VALID  GROUP-NAME..!");
							stay12=true;
						}
					}*/

					cdao.updateContact(cb2,cb2.getName());

					break;
				}


			}
		}

	}
}
