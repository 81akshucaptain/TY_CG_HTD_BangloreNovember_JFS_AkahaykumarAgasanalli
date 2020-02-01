package com.capgemini.stockmanagementboot.services;

import com.capgemini.stockmanagementboot.dto.UsersAuthenticationBean;

public interface UsersServices {
	public UsersAuthenticationBean usersLogin(String email, String password);
}
