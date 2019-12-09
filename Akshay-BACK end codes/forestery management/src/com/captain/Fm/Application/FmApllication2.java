package com.captain.Fm.Application;
import java.util.Scanner;
import com.captain.Fm.*;

import com.captain.Fm.Factory.ForestFactory;
import com.captain.Fm.bean.ContractorBean;
import com.captain.Fm.DAO.*;

public class FmApllication2 {
	void contractor() {
		ContractorDAO cdao=ForestFactory.instanceOfContractorDAOImpl();
		Scanner sc=new Scanner(System.in);
		while (true) {
			System.out.println("********************WELCOME TO CONTRACTOR HOUSE********************");
			System.out.println("*Enter 1 to add the Contractor");
			System.out.println("*Enter 2 to search the Contractor");
			System.out.println("*Enter 3 to update the Contractor");
			System.out.println("*Enter 4 to remove the Contractor");
			System.out.println("*Enter 5 to get all the Contractor");
System.out.println("*Enter 6 to return HOME");
			int option=sc.nextInt();


			switch (option) {
			case 1:
				ContractorBean cb=new ContractorBean();

				System.out.println("enter the costumer ID: ");
				System.out.println("enter the productid");
				cb.setProductId(sc.nextInt());
				System.out.println("enter the haulier ID: ");
				cb.setHaulierId(sc.nextInt());
				System.out.println("enter the delivery date in dd/mm/yyyy fromat: ");
				cb.setDeliveryDate(sc.next());
				System.out.println("enter the delivery day: ");
				cb.setDeliveryDay(sc.next());
				System.out.println("enter the quantiy required: ");
				cb.setQunatity(sc.nextInt());
				if(cdao.addContarctor(cb)) {
					System.out.println("Contractor added successfully..!");
				}else System.err.println("somthing went wrong buddy, try again..!");
				break;
			case 2:
				System.out.println("enter the contractorID to search Contractor: ");
				int ctid=sc.nextInt();
				ContractorBean cdetails=cdao.searchContarctor(ctid);
				System.out.println("The details of Contractor with "+ctid+" is:");
				System.out.println(cdetails);
				break;
			case 3:
				System.out.println("enter the CTID to update:");
				int cidToUpdate =sc.nextInt();
				ContractorBean cb2=new ContractorBean();
				System.out.println("Enter CustomerId to update:");
				cb2.setCustomerId(sc.nextInt());
				System.out.println("enter product ID to update: ");
				cb2.setProductId(sc.nextInt());
				System.out.println("enter hualier ID to update: ");
				cb2.setHaulierId(sc.nextInt());
				System.out.println("enter delivery DATE to update: ");
				cb2.setDeliveryDate(sc.next());
				System.out.println("enter delivery DAY to update: ");
				cb2.setDeliveryDay(sc.next());
				System.out.println("enter quantity to update: ");
				cb2.setQunatity(sc.nextInt());
				boolean update=cdao.updateContarctor(cidToUpdate,cb2);
				if(update==true) {
					System.out.println("New details added successfully..!");
				}else System.err.println("Something went wrong to update..!");
				break;
			case 4:
				System.out.println("Enter The Contractor ID to delete the account:");
				int cidToDelete=sc.nextInt();
				boolean delete=cdao.deletecontarctor(cidToDelete);
				break;
			case 5:
				cdao.getAllContarctor();
				break;
			case 6:
				MainApllication m=new MainApllication();
				m.main(null);

			}
		}
	}
}