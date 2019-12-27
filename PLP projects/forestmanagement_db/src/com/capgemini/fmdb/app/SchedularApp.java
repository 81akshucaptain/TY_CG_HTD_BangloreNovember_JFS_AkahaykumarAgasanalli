package com.capgemini.fmdb.app;

import java.util.Scanner;

import com.capgemini.fmbd.dao.ContractorDAO;
import com.capgemini.fmbd.dao.ContractorDAOImpl;
import com.capgemini.fmbd.dao.ProductDAO;
import com.capgemini.fmbd.dao.ProductDAOImpl;
import com.capgemini.fmdb.bean.ContractorBean;
import com.capgemini.fmdb.bean.ProductBean;



public class SchedularApp {
	public void schedularHome() {

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

				if(coBean.getQunatity()<prBean.getQantity()) {
					System.out.println("VERIFICATION DONE WITH PRODUCT STOCKS, DEMANDED PRODUCT \n"
							+ "QUANTITY WILL BE DELIVERED ON DATE: "+coBean.getDeliveryDate()
							+"\n Sending confiramtion mail to customer with CUSTOMER-ID: "+coBean.getCustomerId()+"\n");
				}else {
					System.err.println("REQUESTED CONTRACT FOR PRODUCTS WILL BE DELAYED DUE TO\n "
							+ "INSUFFICIENT STOCKS, DELIVERED AS SOON AS POSIIBLE..");
				}
			case 4: FmDbHome.main(null);

			default: 
				System.err.println("Enter the vallid choice..!");
				break;
			}

		}
	}
}