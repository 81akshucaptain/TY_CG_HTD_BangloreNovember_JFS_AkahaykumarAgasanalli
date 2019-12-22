package com.captain.Fm.Application;

import java.util.Scanner;

import com.captain.Fm.DAO.ContractorDAO;
import com.captain.Fm.DAO.ContractorDAOImpl;
import com.captain.Fm.DAO.ProductDAO;
import com.captain.Fm.DAO.ProductDAOImpl;
import com.captain.Fm.bean.ContractorBean;
import com.captain.Fm.bean.ProductBean;

public class SchedularHomeApplication {
	public static void schedularHome() {

		Scanner sc=new Scanner(System.in);
		ContractorDAO conDao=new ContractorDAOImpl();
		ProductDAO proDao=new ProductDAOImpl();
		while(true) {
			System.out.println("///////////////////////WELCOME TO FORESTERY MANAGMENT\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
			System.out.println("                            ::::SCHEDULAR HOME::::");
			System.out.println("1.View all contracts");
			System.out.println("2.View all prodcts");
			System.out.println("3.Schedule the order ");
			System.out.println("4.Logout ");
			int choice=sc.nextInt();
			switch (choice) {
			case 1:
				conDao.getAllContarctor();
				break;
			case 2: 
				proDao.getAllProduct();
				break;
			case 3:
				System.out.println("Enter the CONTRACT-ID to Schedule the contract: ");
				int ctid=sc.nextInt();
				ContractorBean coBean = conDao.searchContarctor(ctid);
				System.out.println(coBean);
				//String contractFields=coBean.toString();
				System.out.println("=========================================================");
				System.out.println("Enter the Demanded PRODUCT-ID of for verification and delivery: ");
				int pid=sc.nextInt();
				ProductBean prBean = proDao.searchProduct(pid);
				System.out.println(prBean);
				//String productFields=prBean.toString();

				if(coBean.getQunatity()<prBean.getQuantity()) {
					System.out.println("VERIFICATION DONE WITH PRODUCT STOCKS, DEMANDED PRODUCT \n"
							+ "QUANTITY WILL BE DELIVERED ON DATE: "+coBean.getDeliveryDate()+" ("+coBean.getDeliveryDay()+
							")\n Sending confiramtion mail to customer with CUSTOMER-ID: "+coBean.getCustomerId()+"\n");
				}else {
					System.err.println("REQUESTED CONTRACT FOR PRODUCTS WILL BE DELAYED DUE TO\n "
							+ "INSUFFICIENT STOCKS, DELIVERED AS SOON AS POSIIBLE..");
				}
			case 4: FmHome.main(null);
			default:
				break;
			}

		}
	}
}