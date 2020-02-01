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
import com.capgemini.stockmanagementboot.dto.StocksManagementResponse;
import com.capgemini.stockmanagementboot.services.CompanyServices;


@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class CompanyController {
	
	@Autowired
	CompanyServices service;

	@PostMapping(path="/add-company",produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public StocksManagementResponse addCompany(@RequestBody CompanyBean company) {
		StocksManagementResponse response = new StocksManagementResponse();
		if(service.addCompany(company)) {
			response.setStatusCode(201);
			response.setMessage("Company Added Succesfully");
			response.setDescription("Company added");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed To Add Company Details");
			response.setDescription("FAILED TO ADD Company : Might be-  "
					+ "1.Invalid CompanyName (must be alphabets)  "
					+ "2.Invalid EmailID (good pattern-akshay584@gmail.com)  "
					+ "3.Invalid PostalID (must be 6 digits)  "
					+ "4.Invalid Phone number (must be 10 digits starts with 6/7/8/9)  "
					+ "5.Invalid CityName (must be alphabets) ");
		}
		return response;
	}

	@GetMapping(path="/search-company",produces = MediaType.APPLICATION_JSON_VALUE)
	public StocksManagementResponse searchCompany(@RequestParam("companyID") int companyID) {
		StocksManagementResponse response = new StocksManagementResponse();
		CompanyBean company=service.searchCompany(companyID);
		if(company!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("company found");
			response.setCompanies(Arrays.asList(company));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("1.companyID does-not exist  OR  "
					+ "2.Invalid companyID (must be digits)");
		}
		return response;
	}

	@GetMapping(path="/get-allcompany",produces = MediaType.APPLICATION_JSON_VALUE)
	public StocksManagementResponse getAllCompany() {
		StocksManagementResponse response = new StocksManagementResponse();
		List<CompanyBean> list=service.getAllCompany();
		if(list.size()!=0) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("company found");
			response.setCompanies(list);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("No data For company");
		}
		return response;

	}

	@DeleteMapping(path = "/delete-company/{companyID}",produces = MediaType.APPLICATION_JSON_VALUE)
	public StocksManagementResponse deleteCompany(@PathVariable("companyID") int companyID) {
		StocksManagementResponse response = new StocksManagementResponse();
		if(service.deleteCompany(companyID)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("company deleted");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("1.companyID does not found OR "
					+ "2.Invalid companyID (must be digits)");
		}
		return response;
	}


	@PutMapping(path = "/update-company", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public StocksManagementResponse updateCompany(@RequestBody CompanyBean company) {
		StocksManagementResponse response = new StocksManagementResponse();
		if (service.updateCompany(company.getCompanyID(), company)){
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("company Data updated");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("FAILED TO UPDATE company : Might be-  "
					+ "1.Invalid companyName (must be alphabets)  "
					+ "2.Invalid EmailID (good pattern-akshay584@gmail.com)  "
					+ "3.Invalid PostalID (must be 6 digits)  "
					+ "4.Invalid Phone number (must be 10 digits starts with 6/7/8/9)  "
					+ "5.Invalid CityName (must be alphabets)  "
					+ "6.Invalid companyID (must be digit)");		}
		return response;
	}
	@GetMapping(path="/search-company-by-email",produces = MediaType.APPLICATION_JSON_VALUE)
	public StocksManagementResponse searchCompany(@RequestParam("email") String email) {
		StocksManagementResponse response = new StocksManagementResponse();
		CompanyBean company=service.searchCompanyByMail(email);
		if(company!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("company found");
			response.setCompanies(Arrays.asList(company));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("1.EMAIL-ID does-not exist or password");
		}
		return response;
	}
}


