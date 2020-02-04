package com.capgemini.stockmanagementboot.dao;

import com.capgemini.stockmanagementboot.dto.UsersAuthenticationBean;

public interface UsersDAO {
	public UsersAuthenticationBean usersLogin(String userName, String password);

	public UsersAuthenticationBean searchUserByEmail(String email) ;

	public boolean updatePassword(UsersAuthenticationBean usersBean);
}
