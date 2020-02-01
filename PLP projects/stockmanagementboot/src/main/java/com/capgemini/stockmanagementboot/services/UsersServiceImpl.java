package com.capgemini.stockmanagementboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.stockmanagementboot.dao.UsersDAO;
import com.capgemini.stockmanagementboot.dto.UsersAuthenticationBean;

@Service
public class UsersServiceImpl implements UsersServices {
	
	@Autowired
	UsersDAO userDao;

	@Override
	public UsersAuthenticationBean usersLogin(String email, String password) {
		// TODO Auto-generated method stub
		return userDao.usersLogin(email, password) ;
	}

}
