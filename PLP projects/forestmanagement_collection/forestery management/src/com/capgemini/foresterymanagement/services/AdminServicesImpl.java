package com.capgemini.foresterymanagement.services;

import com.capgemini.foresterymanagement.bean.AdminBean;
import com.capgemini.foresterymanagement.dao.AdminDAO;
import com.capgemini.foresterymanagement.factory.ForestFactory;

public class AdminServicesImpl implements AdminServices {

	AdminDAO adminDao = ForestFactory.insatnceOfAdminDAOImpl();

	@Override
	public boolean adminLogin(String uname, String password, AdminBean ad) {
		return adminDao.adminLogin(uname, password, ad);
	}

}
