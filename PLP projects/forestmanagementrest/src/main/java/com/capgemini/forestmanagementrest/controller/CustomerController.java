package com.capgemini.forestmanagementrest.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.forestmanagementrest.dto.CustomerBean;
import com.capgemini.forestmanagementrest.dto.ForestManagementResponse;
import com.capgemini.forestmanagementrest.dto.ProductBean;
import com.capgemini.forestmanagementrest.dto.UsersBean;
import com.capgemini.forestmanagementrest.services.CustomerServices;
import com.capgemini.forestmanagementrest.services.ProductServices;

@RestController
public class CustomerController {
	@Autowired
	CustomerServices service;
	
	@PostMapping(path="/add-customer",produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ForestManagementResponse addCustomer(@RequestBody CustomerBean customer) {
		ForestManagementResponse response = new ForestManagementResponse();
		if(service.addCustomer(customer)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Customer added");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("FAILED TO ADD CUSTOMER : Might be-  "
					+ "1.Invalid UserName (must be alphabets)  "
					+ "2.Invalid EmailID (good pattern-akshay584@gmail.com)  "
					+ "3.Invalid PostalID (must be 6 digits)  "
					+ "4.Invalid Phone number (must be 10 digits starts with 6/7/8/9)  "
					+ "5.Invalid TownName (must be alphabets) ");
		}
		return response;
	}
	
	@GetMapping(path="/search-customer",produces = MediaType.APPLICATION_JSON_VALUE)
	public ForestManagementResponse searchCustomer(@RequestParam("cid") int cid) {
		ForestManagementResponse response = new ForestManagementResponse();
		CustomerBean customer=service.searchCustomer(cid);
		if(customer!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Customer found");
			response.setCustomer(Arrays.asList(customer));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("1.CustomerID does-not exist  OR  "
					+ "2.Invalid CustomerID (must be digits)");
		}
		return response;
	}
	
	@GetMapping(path="/get-allcustomer",produces = MediaType.APPLICATION_JSON_VALUE)
	public ForestManagementResponse getAllCustomer() {
		ForestManagementResponse response = new ForestManagementResponse();
		List<CustomerBean> list=service.getAllCustomer();
		if(list.size()!=0) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Customer found");
			response.setCustomer(list);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("No data For Customers");
		}
		return response;
		
	}
	
	@DeleteMapping(path = "/delete-customer/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ForestManagementResponse deleteCustomer(@PathVariable("id") int id) {
		ForestManagementResponse response = new ForestManagementResponse();
		if(service.deleteCustomer(id)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Customer deleted");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("1.CustomerID does not found OR "
					+ "2.Invalid CustomerID (must be digits)");
		}
		return response;
	}
	

	@PutMapping(path = "/update-customer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ForestManagementResponse updateCustomer(@RequestBody CustomerBean customer) {
		ForestManagementResponse response = new ForestManagementResponse();
		if (service.updateCustomer(customer.getCid(), customer)){
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Customer Data updated");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("FAILED TO UPDATE CUSTOMER : Might be-  "
					+ "1.Invalid UserName (must be alphabets)  "
					+ "2.Invalid EmailID (good pattern-akshay584@gmail.com)  "
					+ "3.Invalid PostalID (must be 6 digits)  "
					+ "4.Invalid Phone number (must be 10 digits starts with 6/7/8/9)  "
					+ "5.Invalid TownName (must be alphabets)  "
					+ "6.Invalid CustumerID (must be digit)");		}
		return response;
	}
	@PostMapping(path = "/customerlogin", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ForestManagementResponse login(@RequestBody CustomerBean credentials) {
		ForestManagementResponse response = new ForestManagementResponse();
		boolean account = service.customerLogin(credentials.getCid(),credentials.getPassword());
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
