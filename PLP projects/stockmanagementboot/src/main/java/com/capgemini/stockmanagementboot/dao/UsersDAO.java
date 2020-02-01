package com.capgemini.stockmanagementboot.dao;

import com.capgemini.stockmanagementboot.dto.UsersAuthenticationBean;

public interface UsersDAO {
	public UsersAuthenticationBean usersLogin(String email, String password);
}
