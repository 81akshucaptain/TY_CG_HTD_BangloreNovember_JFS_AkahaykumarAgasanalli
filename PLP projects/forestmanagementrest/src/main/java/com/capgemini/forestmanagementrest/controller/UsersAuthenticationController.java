package com.capgemini.forestmanagementrest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.forestmanagementrest.dto.ForestManagementResponse;
import com.capgemini.forestmanagementrest.dto.UsersBean;
import com.capgemini.forestmanagementrest.services.UsersServices;

@RestController
public class UsersAuthenticationController {

	@Autowired
	UsersServices service;
		
	@PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ForestManagementResponse login(@RequestBody UsersBean credentials) {
		ForestManagementResponse response = new ForestManagementResponse();
		boolean account = service.usersLogin(credentials.getUser_name(),credentials.getPassword());
		if (account) {
			response.setStatusCode(201);
			response.setDescription("Success");
			response.setMessage("Logged in");
		} else {
			response.setStatusCode(405);
			response.setDescription("Failure");
			response.setMessage("Provide valid credentials");
		}
		return response;
	}	
	
}
