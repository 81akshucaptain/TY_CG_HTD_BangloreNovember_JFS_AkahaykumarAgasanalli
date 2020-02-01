package com.capgemini.stockmanagementboot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.stockmanagementboot.dto.InvesterBean;
import com.capgemini.stockmanagementboot.dto.ManagerBean;
import com.capgemini.stockmanagementboot.dto.StocksManagementResponse;
import com.capgemini.stockmanagementboot.services.InvesterServices;
import com.capgemini.stockmanagementboot.services.ManagerServices;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class InvestersController {
	@Autowired
	InvesterServices service;

	@PostMapping(path="/add-invester",produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public StocksManagementResponse addInvester(@RequestBody InvesterBean invester) {
		StocksManagementResponse response = new StocksManagementResponse();
		if(service.addInvester(invester)) {
			response.setStatusCode(201);
			response.setMessage("invester Added Succesfully");
			response.setDescription("invester added");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed To Add invester Details");
			response.setDescription("FAILED TO ADD invester : Might be-  "
					+ "1.Invalid investerName (must be alphabets)  "
					+ "2.Invalid EmailID (good pattern-akshay584@gmail.com)  "
					+ "3.Invalid PostalID (must be 6 digits)  "
					+ "4.Invalid PhoneNumber (must be 10 digits starts with 6/7/8/9)  "
					+ "5.Invalid CityName (must be alphabets) ");
		}
		return response;
	}

	@GetMapping(path="/search-invester",produces = MediaType.APPLICATION_JSON_VALUE)
	public StocksManagementResponse searchInvester(@RequestParam("investerID") int investerID) {
		StocksManagementResponse response = new StocksManagementResponse();
		InvesterBean invester=service.searchInvester(investerID);
		if(invester!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("invester found");
			response.setInvesters(Arrays.asList(invester));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("1.investerID does-not exist  OR  "
					+ "2.Invalid investerID (must be digits)");
		}
		return response;
	}

	@GetMapping(path="/get-allinvester",produces = MediaType.APPLICATION_JSON_VALUE)
	public StocksManagementResponse getAllInvester() {
		StocksManagementResponse response = new StocksManagementResponse();
		List<InvesterBean> list=service.getAllInvesters();
		if(list.size()!=0) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("investers found");
			response.setInvesters(list);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("No data For investers");
		}
		return response;

	}

	@DeleteMapping(path = "/delete-invester/{investerID}",produces = MediaType.APPLICATION_JSON_VALUE)
	public StocksManagementResponse deleteInvester(@PathVariable("investerID") int investerID) {
		StocksManagementResponse response = new StocksManagementResponse();
		if(service.deleteInvester(investerID)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Invester deleted");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("1.investerID does not found OR "
					+ "2.Invalid investerID (must be digits)");
		}
		return response;
	}

	@PutMapping(path = "/update-invester", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public StocksManagementResponse updateManager(@RequestBody InvesterBean invester) {
		StocksManagementResponse response = new StocksManagementResponse();
		if (service.updateInvesters(invester.getInvesterID(), invester)){
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("invester Data updated");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("FAILED TO UPDATE invester : Might be-  "
					+ "1.Invalid investerName (must be alphabets)  "
					+ "2.Invalid EmailID (good pattern-akshay584@gmail.com)  "
					+ "3.Invalid PostalID (must be 6 digits)  "
					+ "4.Invalid Phone number (must be 10 digits starts with 6/7/8/9)  "
					+ "5.Invalid CityName (must be alphabets)  "
					+ "6.Invalid investerID (must be digit)");		}
		return response;
	}
	@GetMapping(path="/search-invester-by-name",produces = MediaType.APPLICATION_JSON_VALUE)
	public StocksManagementResponse searchManagerByEmail(@RequestParam("investerName") String investerName) {
		StocksManagementResponse response = new StocksManagementResponse();
		InvesterBean invester=service.searchInvesterByName(investerName);
		if(invester!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("manager found");
			response.setInvesters(Arrays.asList(invester));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("1.Name does-not exist");
		}
		return response;
	}
}


