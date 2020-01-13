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

import com.capgemini.forestmanagementrest.dto.ContractorBean;
import com.capgemini.forestmanagementrest.dto.CustomerBean;
import com.capgemini.forestmanagementrest.dto.ForestManagementResponse;
import com.capgemini.forestmanagementrest.services.ContractorServices;
import com.capgemini.forestmanagementrest.services.CustomerServices;

@RestController
public class ContractController {

	@Autowired
	ContractorServices service;
	
	@PostMapping(path="/add-contract",produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ForestManagementResponse addContract(@RequestBody ContractorBean contract) {
		ForestManagementResponse response = new ForestManagementResponse();
		if(service.addContarctor(contract)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("contract added");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("contract with same CTId already exists");
		}
		return response;
	}
	
	@GetMapping(path="/search-contract",produces = MediaType.APPLICATION_JSON_VALUE)
	public ForestManagementResponse searchContract(@RequestParam("ctid") int ctid) {
		ForestManagementResponse response = new ForestManagementResponse();
		ContractorBean contract=service.searchContarctor(ctid);
		if(contract!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("contract found");
			response.setContract(Arrays.asList(contract));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("contract Id does-not exist");
		}
		return response;
	}
	
	@GetMapping(path="/get-allcontracts",produces = MediaType.APPLICATION_JSON_VALUE)
	public ForestManagementResponse getAllContracts() {
		ForestManagementResponse response = new ForestManagementResponse();
		List<ContractorBean> list=service.getAllContarctor();
		if(list.size()!=0) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Contracts found");
			response.setContract(list);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("No data For Contracts");
		}
		return response;
		
	}
	
	@DeleteMapping(path = "/delete-contract/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ForestManagementResponse deleteContract(@PathVariable("id") int id) {
		ForestManagementResponse response = new ForestManagementResponse();
		if(service.deletecontarctor(id)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("contract deleted");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("contract not found");
		}
		return response;
	}
	
	@PutMapping(path = "/update-contract", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ForestManagementResponse updateContract(@RequestBody ContractorBean contract) {
		ForestManagementResponse response = new ForestManagementResponse();
		if (service.updateContarctor(contract.getContractId(), contract)){
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("contract Data updated");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("contract not found");
		}
		return response;
	}


}

