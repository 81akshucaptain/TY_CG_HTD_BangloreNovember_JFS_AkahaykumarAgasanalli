package com.capgemini.jdbc.services;

import java.util.List;

import com.capgemini.jdbc.bean.UserBean;

public interface UserServices {
	public List<UserBean> getAllUser();
	public boolean userlogin(String uame,String psw);
	public boolean updateUser(String uname, String usn,String psw);
	public boolean deleteUser(String usn,String password);
	//create UserBean obje and pass to insert all values
	public boolean insertUser(UserBean user);
}
