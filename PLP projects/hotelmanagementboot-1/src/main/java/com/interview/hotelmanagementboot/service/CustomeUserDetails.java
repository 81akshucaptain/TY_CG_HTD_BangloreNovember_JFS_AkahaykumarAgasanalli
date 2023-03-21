package com.interview.hotelmanagementboot.service;

import java.util.Optional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.interview.hotelmanagementboot.dao.CustomerDaoIMPL;
import com.interview.hotelmanagementboot.dto.User;

@Service
public class CustomeUserDetails implements UserDetailsService {


	@Autowired
	private CustomerDaoIMPL dao;


	
	public UserDetails loadUserByUsername2(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> user = dao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("username not found");
		}
		return user;
	}

	

}
