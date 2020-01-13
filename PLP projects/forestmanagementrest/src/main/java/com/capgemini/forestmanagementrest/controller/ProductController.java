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
import com.capgemini.forestmanagementrest.dto.ProductBean;
import com.capgemini.forestmanagementrest.services.ProductServices;

@RestController
public class ProductController {
	
	@Autowired
	ProductServices service;
	
	@PostMapping(path="/add-product",produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ForestManagementResponse addProduct(@RequestBody ProductBean product) {
		ForestManagementResponse response = new ForestManagementResponse();
		if(service.addProduct(product)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Product added");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Product with same name already exists");
		}
		return response;
	}
	
	@GetMapping(path="/search-product",produces = MediaType.APPLICATION_JSON_VALUE)
	public ForestManagementResponse searchProduct(@RequestParam("pid") int pid) {
		ForestManagementResponse response = new ForestManagementResponse();
		ProductBean product=service.searchProduct(pid);
		if(product!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Product found");
			response.setProduct(Arrays.asList(product));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Product id does not exist");
		}
		return response;
	}
	
	@GetMapping(path="/get-allproducts",produces = MediaType.APPLICATION_JSON_VALUE)
	public ForestManagementResponse getAllProducts() {
		ForestManagementResponse response = new ForestManagementResponse();
		List<ProductBean> list=service.getAllProduct();
		if(list.size()!=0) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Products found");
			response.setProduct(list);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("No data");
		}
		return response;
		
	}
	
	@DeleteMapping(path = "/delete-product/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ForestManagementResponse deleteProduct(@PathVariable("id") int id) {
		ForestManagementResponse response = new ForestManagementResponse();
		if(service.deleteProduct(id)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Product deleted");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Product not found");
		}
		return response;
	}
	

	@PutMapping(path = "/update-product", produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ForestManagementResponse updateProduct(@RequestBody ProductBean product) {
		ForestManagementResponse response = new ForestManagementResponse();
		if (service.updateProduct(product)){
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Product cost updated");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Product not found");
		}
		return response;
	}


}
