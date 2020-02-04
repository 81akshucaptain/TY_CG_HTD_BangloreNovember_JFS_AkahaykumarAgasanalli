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
import com.capgemini.stockmanagementboot.dto.InvesterStocksInfoBean;
import com.capgemini.stockmanagementboot.dto.StocksManagementResponse;
import com.capgemini.stockmanagementboot.services.InvesterServices;
import com.capgemini.stockmanagementboot.services.InvesterStockInfoServices;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class InvesterStockInfoController {
	
	@Autowired
	InvesterStockInfoServices service;

	@PostMapping(path="/add-stock-info",produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public StocksManagementResponse addInvesterStockInfo(@RequestBody InvesterStocksInfoBean investerStockInfo) {
		StocksManagementResponse response = new StocksManagementResponse();
		if(service.addInvesterStockInfo(investerStockInfo)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("investerStockInformation added");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed To Add investerStockInformation Details");
			response.setDescription("FAILED TO ADD investerStockInformation : Might be-  "
					+ "1.Invalid companyName (must be alphabets)  "
					+ "2.Invalid companyID ( must be numbers)  "
					+ "3.Invalid currentPrice (must be digits)  "
					+ "4.Invalid purchasedPrice (must be digits)  "
					+ "5.Invalid volume (must be numbers) ");
		}
		return response;
	}

	@GetMapping(path="/search-stockInfo",produces = MediaType.APPLICATION_JSON_VALUE)
	public StocksManagementResponse searchInvesterStockInformation(@RequestParam("transactionID") int transactionID) {
		StocksManagementResponse response = new StocksManagementResponse();
		InvesterStocksInfoBean investerInfo=service.searchInvesterStockInfo(transactionID);
		if(investerInfo!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("investerInfo found");
			response.setInvesterInfo(Arrays.asList(investerInfo));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("1.transactionID does-not exist  OR  "
					+ "2.Invalid transactionID (must be digits)");
		}
		return response;
	}

	@GetMapping(path="/search-stock-Info-by-ivesterid",produces = MediaType.APPLICATION_JSON_VALUE)
	public StocksManagementResponse searchInvesterStockInfoByIID(@RequestParam("investerID") int investerID) {
		StocksManagementResponse response = new StocksManagementResponse();
		List<InvesterStocksInfoBean> investerInfos=service.searchInvesterStockInfoByInvesterID(investerID);
		if(investerInfos!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("investerInfo found not found for investerID");
			response.setInvesterInfo(investerInfos);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("1.investerID does-not exist  OR  "
					+ "2.Invalid investerID (must be digits)");
		}
		return response;
	}


	@GetMapping(path="/get-all-invester-info",produces = MediaType.APPLICATION_JSON_VALUE)
	public StocksManagementResponse getAllInvesterStockInformation() {
		StocksManagementResponse response = new StocksManagementResponse();
		List<InvesterStocksInfoBean> list=service.getAllInvesterStockInfo();
		if(list.size()!=0) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("stocks info found");
			response.setInvesterInfo(list);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("No data For stock info");
		}
		return response;
	}
	
	@PostMapping(path = "/delete-InvesterStockInfo",produces = MediaType.APPLICATION_JSON_VALUE)
	public StocksManagementResponse deleteInvesterStockInformation(@RequestBody InvesterStocksInfoBean investerStocksInfoBean) {
		StocksManagementResponse response = new StocksManagementResponse();
		if(service.deleteInvesterStockInfo(investerStocksInfoBean)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("InvesterStockInfo deleted");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("1.transactionID does not found OR "
					+ "2.Invalid transactionID (must be digits)");
		}
		return response;
	}

	@PutMapping(path = "/update-invester-stock-info", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public StocksManagementResponse updateInvesterStocksInformation(@RequestBody InvesterStocksInfoBean investerStockInfo) {
		StocksManagementResponse response = new StocksManagementResponse();
		if (service.updateInvesterStocksInfo(investerStockInfo.getTransactionID(), investerStockInfo)){
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("investerStockInfo Data updated");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("FAILED TO ADD investerStockInformation : Might be-  "
					+ "1.Invalid companyName (must be alphabets)  "
					+ "2.Invalid companyID ( must be numbers)  "
					+ "3.Invalid currentPrice (must be digits)  "
					+ "4.Invalid purchasedPrice (must be digits)  "
					+ "5.Invalid volume (must be numbers) ");
		}
		return response;
	}
	@GetMapping(path="/search-invester-infoby-companyname",produces = MediaType.APPLICATION_JSON_VALUE)
	public StocksManagementResponse searchInvesterInformationByCompanyName(@RequestParam("companyName") String companyName) {
		StocksManagementResponse response = new StocksManagementResponse();
		InvesterStocksInfoBean investerInfo=service.searchInvesterInfoByCompanyName(companyName);
		if(investerInfo!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("investerInfo found");
			response.setInvesterInfo(Arrays.asList(investerInfo));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("1.Company Name does-not exist");
		}
		return response;
	}
}

