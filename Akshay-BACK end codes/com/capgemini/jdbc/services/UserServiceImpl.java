package com.capgemini.jdbc.services;

import java.util.List;

import com.capgemini.jdbc.bean.UserBean;
import com.capgemini.jdbc.dao.UserDAO;
import com.capgemini.jdbc.factory.UserFactory;

public class UserServiceImpl implements UserServices{
	UserDAO udao=UserFactory.instanceOfUserDAOimpl();
	@Override
	public List<UserBean> getAllUser() {
		// TODO Auto-generated method stub
		return udao.getAllUser();
	}

	@Override
	public boolean userlogin(String uame, String psw) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean updateUser(String uname, String usn, String password) {
		// TODO Auto-generated method stub
		return udao.updateUser(uname,usn,password);
	}

	@Override
	public boolean deleteUser(String usn, String password) {
		
		return udao.deleteUser(usn, password);
	}

	@Override
	public boolean insertUser(UserBean user) {
		// TODO Auto-generated method stub
		return udao.insertUser(user);
	}

	
}
