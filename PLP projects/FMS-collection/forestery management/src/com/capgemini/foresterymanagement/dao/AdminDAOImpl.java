package com.capgemini.foresterymanagement.dao;

import com.capgemini.foresterymanagement.bean.AdminBean;

public class AdminDAOImpl implements AdminDAO {

	@Override
	public boolean adminLogin(String uname, String password,AdminBean admin) {
		try{
			String adminName="admin";
			String adminPassword="admin@Ak123";
			if((adminName.equals(uname)) &&(adminPassword.equals(password))) {
				return true;
			}
			else {
				return false;
			}
		}catch(Exception e) {
			System.out.println("There Is problem In Accesing Admin..");
			return false;

		}
	}
}