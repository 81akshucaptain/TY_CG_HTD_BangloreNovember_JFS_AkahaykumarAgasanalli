package com.capgemini.forestmanagementboot.controller;

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

import com.capgemini.forestmanagementboot.dto.ForestManagementResponse;
import com.capgemini.forestmanagementboot.dto.LandsBean;
import com.capgemini.forestmanagementboot.services.LandsServices;

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
			response.setDescription("FAILED TO ADD LAND : Might be-  \"\r\n" + 
					"					+ \"1.Invalid Land Resources (must be alphabets)  \"\r\n" + 
					"					+ \"2.Invalid landSize (must be 6 digits)  \"\r\n" + 
					"					+ \"3.Invalid Land Location (must be alphabets)  \"\r\n" );
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
			response.setDescription("1.LandId does not found OR "
					+ "2.Invalid LandId (must be digit > 0)");
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
			response.setDescription("1.LandId does not found OR "
					+ "2.Invalid LandId (must be digit > 0)");
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
			response.setDescription("FAILED TO UPDATE LAND : Might be-  \"\r\n" + 
					"					+ \"1.Invalid Land Resources (must be alphabets)  \"\r\n" + 
					"					+ \"2.Invalid landSize (must be number > 0)  \"\r\n" + 
					"					+ \"3.Invalid Land Location (must be alphabets)  \"\r\n"
					+ "4.Invalid LandID (must be number >0" );
		}
		return response;
	}


}

