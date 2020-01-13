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

import com.capgemini.forestmanagementrest.dto.ForestManagementResponse;
import com.capgemini.forestmanagementrest.dto.LandsBean;
import com.capgemini.forestmanagementrest.dto.ProductBean;
import com.capgemini.forestmanagementrest.services.LandsServices;
import com.capgemini.forestmanagementrest.services.ProductServices;

@RestController
public class LandsController {
	@Autowired
	LandsServices service;
	
	@PostMapping(path="/add-land",produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ForestManagementResponse addLand(@RequestBody LandsBean land) {
		ForestManagementResponse response = new ForestManagementResponse();
		if(service.addLands(land)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("land added");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("land with same ID already exists");
		}
		return response;
	}
	
	@GetMapping(path="/search-land",produces = MediaType.APPLICATION_JSON_VALUE)
	public ForestManagementResponse searchLand(@RequestParam("lid") int lid) {
		ForestManagementResponse response = new ForestManagementResponse();
		LandsBean land=service.searchLands(lid);
		if(land!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("land found");
			response.setLand(Arrays.asList(land));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("land id does not exist");
		}
		return response;
	}
	
	@GetMapping(path="/get-alllands",produces = MediaType.APPLICATION_JSON_VALUE)
	public ForestManagementResponse getAllLand() {
		ForestManagementResponse response = new ForestManagementResponse();
		List<LandsBean> list=service.getAllLands();
		if(list.size()!=0) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("land Deatils found");
			response.setLand(list);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("No data For This LandId");
		}
		return response;
		
	}
	
	@DeleteMapping(path = "/delete-land/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ForestManagementResponse deleteLand(@PathVariable("id") int id) {
		ForestManagementResponse response = new ForestManagementResponse();
		if(service.deleteLands(id)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("land deleted");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("land not found");
		}
		return response;
	}
	
	@PutMapping(path = "/update-land", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ForestManagementResponse updateLand(@RequestBody LandsBean land) {
		ForestManagementResponse response = new ForestManagementResponse();
		if (service.updateLands(land.getLandId(),land)){
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("land cost updated");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Land not found");
		}
		return response;
	}


}

