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

import com.capgemini.stockmanagementboot.dto.CompanyBean;
import com.capgemini.stockmanagementboot.dto.ManagerBean;
import com.capgemini.stockmanagementboot.dto.StocksManagementResponse;
import com.capgemini.stockmanagementboot.services.CompanyServices;
import com.capgemini.stockmanagementboot.services.ManagerServices;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class ManagerController {

	@Autowired
	ManagerServices service;

	@PostMapping(path="/add-manager",produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public StocksManagementResponse addManger(@RequestBody ManagerBean manager) {
		StocksManagementResponse response = new StocksManagementResponse();
		if(service.addManager(manager)) {
			response.setStatusCode(201);
			response.setMessage("manager Added Succesfully");
			response.setDescription("manager added");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed To Add manager Details");
			response.setDescription("FAILED TO ADD manager : Might be-  "
					+ "1.Invalid managerName (must be alphabets)  "
					+ "2.Invalid EmailID (good pattern-akshay584@gmail.com)  "
					+ "3.Invalid PostalID (must be 6 digits)  "
					+ "4.Invalid Phone number (must be 10 digits starts with 6/7/8/9)  "
					+ "5.Invalid CityName (must be alphabets) ");
		}
		return response;
	}

	@GetMapping(path="/search-manager",produces = MediaType.APPLICATION_JSON_VALUE)
	public StocksManagementResponse searchManager(@RequestParam("managerID") int managerID) {
		StocksManagementResponse response = new StocksManagementResponse();
		ManagerBean manager=service.searchManager(managerID);
		if(manager!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("manager found");
			response.setManagers(Arrays.asList(manager));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("1.managerID does-not exist  OR  "
					+ "2.Invalid managerID (must be digits)");
		}
		return response;
	}

	@GetMapping(path="/get-allmanager",produces = MediaType.APPLICATION_JSON_VALUE)
	public StocksManagementResponse getAllManager() {
		StocksManagementResponse response = new StocksManagementResponse();
		List<ManagerBean> list=service.getAllManager();
		if(list.size()!=0) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("manager found");
			response.setManagers(list);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("No data For manager");
		}
		return response;

	}

	@DeleteMapping(path = "/delete-manager/{managerID}",produces = MediaType.APPLICATION_JSON_VALUE)
	public StocksManagementResponse deleteManager(@PathVariable("managerID") int managerID) {
		StocksManagementResponse response = new StocksManagementResponse();
		if(service.deleteManager(managerID)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("manager deleted");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("1.managerID does not found OR "
					+ "2.Invalid managerID (must be digits)");
		}
		return response;
	}

	@PutMapping(path = "/update-manager", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public StocksManagementResponse updateManager(@RequestBody ManagerBean manager) {
		StocksManagementResponse response = new StocksManagementResponse();
		if (service.updateManager(manager.getManagerID(), manager)){
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("manager Data updated");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("FAILED TO UPDATE manager : Might be-  "
					+ "1.Invalid managerName (must be alphabets)  "
					+ "2.Invalid EmailID (good pattern-akshay584@gmail.com)  "
					+ "3.Invalid PostalID (must be 6 digits)  "
					+ "4.Invalid Phone number (must be 10 digits starts with 6/7/8/9)  "
					+ "5.Invalid CityName (must be alphabets)  "
					+ "6.Invalid managerID (must be digit)");		}
		return response;
	}
	@GetMapping(path="/search-manager-by-email",produces = MediaType.APPLICATION_JSON_VALUE)
	public StocksManagementResponse searchManagerByEmail(@RequestParam("email") String email) {
		StocksManagementResponse response = new StocksManagementResponse();
		ManagerBean manager=service.searchManagerByMail(email);
		if(manager!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("manager found");
			response.setManagers(Arrays.asList(manager));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("1.EMAIL-ID does-not exist or password");
		}
		return response;
	}
}

