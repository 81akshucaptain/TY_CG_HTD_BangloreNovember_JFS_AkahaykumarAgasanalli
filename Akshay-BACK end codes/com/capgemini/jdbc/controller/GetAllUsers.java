package com.capgemini.jdbc.controller;

import java.util.Iterator;
import java.util.List;

import com.capgemini.jdbc.bean.UserBean;
import com.capgemini.jdbc.dao.UserDAO;
import com.capgemini.jdbc.factory.UserFactory;
import com.capgemini.jdbc.services.UserServices;

public class GetAllUsers {
public static void main(String[] args) {
	UserServices services=UserFactory.instanceOfUSerServices();
	List<UserBean> list=services.getAllUser();
	Iterator<UserBean> i=list.iterator();
	while (i.hasNext()) {
		UserBean userBean = (UserBean) i.next();
		System.out.println(userBean);
		
	}
	/*if(list!=null) {
		for (UserBean userBean : list) {
			System.out.println(userBean);
		}
		
	}*/
	
}
}
