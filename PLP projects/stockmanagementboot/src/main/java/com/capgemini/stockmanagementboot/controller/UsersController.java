package com.capgemini.stockmanagementboot.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.stockmanagementboot.dto.StocksManagementResponse;
import com.capgemini.stockmanagementboot.dto.UsersAuthenticationBean;
import com.capgemini.stockmanagementboot.services.UsersServices;

@RestController
//its combination of @Controller + @ResponseBody
// Helps in understanding the ResponseBody semantics by RequestMapping Methods, By default 
public class UsersController {

	@Autowired
	UsersServices service;
	
	@PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public StocksManagementResponse login(@RequestBody UsersAuthenticationBean credentials) {
		//For returning the response of type StocksManagementResponse
		//so create Object of StocksManagementResponse
		StocksManagementResponse response = new StocksManagementResponse();
		
		//Then call the UsersLogin method in the services class by creating
		//services reference variable "service" Auto wire it 
		UsersAuthenticationBean account = service.usersLogin(credentials.getUserName(), credentials.getPassword());
		if (account != null) {
			response.setStatusCode(201);
			response.setDescription("Success");
			response.setMessage("Logged in");
			response.setUsers(Arrays.asList(account));
		} else {
			response.setStatusCode(405);
			response.setDescription("Failure");
			response.setMessage("Provide valid credentials");
		}
		return response;
	}
}
