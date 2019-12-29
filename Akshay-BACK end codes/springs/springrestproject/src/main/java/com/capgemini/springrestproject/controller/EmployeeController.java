package com.capgemini.springrestproject.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springrestproject.dto.EmployeeBean;
import com.capgemini.springrestproject.dto.EmployeeResponse;
import com.capgemini.springrestproject.services.EmployeeServices;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeServices services;

	@PostMapping(path = "/auth", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	// BCZ WE ASRE PRODUCING AND CONSUMING JSON OBJECTS
	public EmployeeResponse auth(@RequestBody EmployeeBean eBean) {
		EmployeeBean ebBean= services.auth(eBean.getEmail(), eBean.getPassword());
		EmployeeResponse eResponse=new  EmployeeResponse();
		if(ebBean!=null) {
			eResponse.setStatusCode(200);
			eResponse.setMessage("success");
			eResponse.setDiscription("employee found for the credentials");
			//THIS CODE WILL REDULT IN CREATING LIST
			eResponse.setBeans(Arrays.asList(ebBean));
		}else {
			eResponse.setStatusCode(401);
			eResponse.setMessage("Failure");
			eResponse.setDiscription("employee Not found for the credentials");
		}
		return eResponse;
	}

	@PostMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse addEmplyee(@RequestBody EmployeeBean eBean) {
		EmployeeResponse eResponse=new  EmployeeResponse();

		if(services.addEmployee(eBean)) {
			eResponse.setStatusCode(200);
			eResponse.setMessage("success");
			eResponse.setDiscription("Employee registered");
		}else {
			eResponse.setStatusCode(401);
			eResponse.setMessage("Failure");
			eResponse.setDiscription("Email already exist");
		}
		return eResponse;
	}

	@GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse searchEmployee(@RequestParam String key) {
		List<EmployeeBean> ebBean=services.getEmployees(key);
		EmployeeResponse eResponse=new  EmployeeResponse();
		if(ebBean.isEmpty()) {
			eResponse.setStatusCode(401);
			eResponse.setMessage("Failure");
			eResponse.setDiscription("Employee not found");
		}else {
			eResponse.setStatusCode(200);
			eResponse.setMessage("success");
			eResponse.setDiscription("employee found with given key");
			//THIS CODE WILL REDULT IN CREATING LIST
			eResponse.setBeans(ebBean);
		}
		return eResponse;
	}

	@PutMapping(path = "/changepassword", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse changePassword(@RequestBody EmployeeBean eBean) {
		EmployeeResponse eResponse=new  EmployeeResponse();
		if(services.changePassword(eBean.getId(),eBean.getPassword())){
			eResponse.setStatusCode(200);
			eResponse.setMessage("changed");
			eResponse.setDiscription("Employee password changed");
		}else {
			eResponse.setStatusCode(401);
			eResponse.setMessage("Failed");
			eResponse.setDiscription("Problem in changing password");
		}
		return eResponse;
	}

	@DeleteMapping(path ="/delete/{id}",produces =MediaType.APPLICATION_JSON_VALUE )
	public EmployeeResponse deleteEmployee(@PathVariable(name="id")int id) {
		EmployeeResponse erResponse=new EmployeeResponse();
		if(services.deleteEmployee(id)) 
		{
			erResponse.setStatusCode(201);
			erResponse.setMessage("success");
			erResponse.setDiscription("employee details deleted");
		}else {
			erResponse.setStatusCode(401);
			erResponse.setMessage("Failed");
			erResponse.setDiscription("Problem in deleting id");
		}
		return erResponse;
	}
}












