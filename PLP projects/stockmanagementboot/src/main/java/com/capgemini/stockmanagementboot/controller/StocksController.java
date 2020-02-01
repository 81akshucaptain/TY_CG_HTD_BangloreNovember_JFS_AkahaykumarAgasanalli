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

import com.capgemini.stockmanagementboot.dto.StocksBean;
import com.capgemini.stockmanagementboot.dto.StocksManagementResponse;
import com.capgemini.stockmanagementboot.services.StocksServices;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class StocksController {
	@Autowired
	StocksServices service;

	@PostMapping(path="/add-stock",produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public StocksManagementResponse addStock(@RequestBody StocksBean stock) {
		StocksManagementResponse response = new StocksManagementResponse();
		if(service.addStocks(stock)) {
			response.setStatusCode(201);
			response.setMessage("stock Added Succesfully");
			response.setDescription("stock added");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed To Add stock Details");
			response.setDescription("FAILED TO ADD stock : Might be-  "
					+ "1.Invalid CompanyID (must be number)  "
					+ "2.Invalid CurrentPrice ( must be number)  "
					+ "3.Invalid CHangePercentage (must be digits)  "
					+ "4.Invalid Last Price (must be 10 digits starts with 6/7/8/9)  "
					+ "5.Invalid AvialableStocks (must be alphabets) "
					+ "6. Invalid Total (must be numbers)");
		}
		return response;
	}

	@GetMapping(path="/search-stocks",produces = MediaType.APPLICATION_JSON_VALUE)
	public StocksManagementResponse searchStock(@RequestParam("stockID") int stockID) {
		StocksManagementResponse response = new StocksManagementResponse();
		StocksBean stock=service.searchStocks(stockID);
		if(stock!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("stock found");
			response.setStocks(Arrays.asList(stock));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("1.stockID does-not exist  OR  "
					+ "2.Invalid stockID (must be digits)");
		}
		return response;
	}

	@GetMapping(path="/get-allstocks",produces = MediaType.APPLICATION_JSON_VALUE)
	public StocksManagementResponse getAllStocks() {
		StocksManagementResponse response = new StocksManagementResponse();
		List<StocksBean> list=service.getAllStocks();
		if(list.size()!=0) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("stock found");
			response.setStocks(list);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("No data For stocks");
		}
		return response;

	}

	@DeleteMapping(path = "/delete-stocks/{stockID}",produces = MediaType.APPLICATION_JSON_VALUE)
	public StocksManagementResponse deleteStocks(@PathVariable("stockID") int stockID) {
		StocksManagementResponse response = new StocksManagementResponse();
		if(service.deleteStocks(stockID)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("stock deleted");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("1.stockID does not found OR "
					+ "2.Invalid stockID (must be digits)");
		}
		return response;
	}

	@PutMapping(path = "/update-stocks", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public StocksManagementResponse updateStocks(@RequestBody StocksBean stok) {
		StocksManagementResponse response = new StocksManagementResponse();
		if (service.updateStocks(stok.getStockID(), stok)){
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("stok Data updated");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("FAILED TO ADD stock : Might be-  "
					+ "1.Invalid CompanyID (must be number)  "
					+ "2.Invalid CurrentPrice ( must be number)  "
					+ "3.Invalid CHangePercentage (must be digits)  "
					+ "4.Invalid Last Price (must be numbers)  "
					+ "5.Invalid AvialableStocks (must be alphabets) "
					+ "6.Invalid Total (must be numbers)");
		}
		return response;
	}
	@GetMapping(path="/search-stock-by-companyID",produces = MediaType.APPLICATION_JSON_VALUE)
	public StocksManagementResponse searchStocksByCompanyID(@RequestParam("companyID") int companyID) {
		StocksManagementResponse response = new StocksManagementResponse();
		StocksBean stocks=service.searchStocksByCompanyID(companyID);
		if(stocks!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("stocks found");
			response.setStocks(Arrays.asList(stocks));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("1.Company does-not exist");
		}
		return response;
	}
}


