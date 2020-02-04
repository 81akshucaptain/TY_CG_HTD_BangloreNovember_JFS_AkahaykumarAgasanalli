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
	public UsersAuthenticationBean usersLogin(String userName, String password) {
		// TODO Auto-generated method stub
		return userDao.usersLogin(userName, password) ;
	}

	@Override
	public boolean updatePassword(UsersAuthenticationBean usersBean) {
		// TODO Auto-generated method stub
		return userDao.updatePassword(usersBean);
	}

	@Override
	public UsersAuthenticationBean searchUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.searchUserByEmail(email);
	}

}
