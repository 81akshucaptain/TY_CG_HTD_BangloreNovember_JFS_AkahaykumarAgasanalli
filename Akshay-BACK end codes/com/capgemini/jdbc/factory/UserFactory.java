package com.capgemini.jdbc.factory;

import com.capgemini.jdbc.dao.UserDAO;
import com.capgemini.jdbc.dao.UserDAOImpl;
import com.capgemini.jdbc.services.UserServiceImpl;
import com.capgemini.jdbc.services.UserServices;

public class UserFactory {
private UserFactory() {
	
}
public static UserDAO instanceOfUserDAOimpl() {
	UserDAO dao=new UserDAOImpl();
	return dao;
}
public static UserServices instanceOfUSerServices() {
	UserServices services=new UserServiceImpl();
	return services;
	
}
}
