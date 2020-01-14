package com.capgemini.forestmanagementrest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestmanagementrest.dao.UsersDAO;

@Service
public class UsersServicesImpl implements UsersServices {

	@Autowired
	UsersDAO userDao;

	@Override
	public boolean usersLogin(String userName, String password) {
		return userDao.userLogin(userName, password);
	}
}
