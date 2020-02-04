package com.capgemini.stockmanagementboot.services;

import com.capgemini.stockmanagementboot.dto.UsersAuthenticationBean;

public interface UsersServices {
	public UsersAuthenticationBean usersLogin(String userName, String password);
	
	public UsersAuthenticationBean searchUserByEmail(String email);

	public boolean updatePassword(UsersAuthenticationBean usersBean);
	
}
