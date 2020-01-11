package com.capgemini.retailormpttest.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.retailormpttest.dto.OrderInfoBean;
import com.capgemini.retailormpttest.dto.ProductInfoBean;
import com.capgemini.retailormpttest.dto.RetailerResponse;
import com.capgemini.retailormpttest.dto.UserInfoBean;
import com.capgemini.retailormpttest.services.RetailerServicesImpl;

@RestController
public class RetailerController {
	@Autowired
	private RetailerServicesImpl services;

	@PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	// BCZ WE ARE PRODUCING AND CONSUMING JSON OBJECTS
	public RetailerResponse login(@RequestBody UserInfoBean eBean) {
		UserInfoBean ebBean = services.login(eBean.getEmail(), eBean.getPassword());
		RetailerResponse eResponse = new RetailerResponse();
		if (ebBean != null) {
			eResponse.setStatusCode(200);
			eResponse.setMessage("success");
			eResponse.setDiscription("employee found for the credentials");
			// THIS CODE WILL RESULT IN CREATING LIST
			eResponse.setUserBeans(Arrays.asList(ebBean));
		} else {
			eResponse.setStatusCode(401);
			eResponse.setMessage("Failure");
			eResponse.setDiscription("User Not found for the credentials");
		}
		return eResponse;
	}

	@PostMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
	public RetailerResponse registerUser(@RequestBody UserInfoBean userBean) {
		RetailerResponse eResponse = new RetailerResponse();

		if (services.registerUser(userBean)) {
			eResponse.setStatusCode(200);
			eResponse.setMessage("success");
			eResponse.setDiscription("User registered");
		} else {
			eResponse.setStatusCode(401);
			eResponse.setMessage("Failure");
			eResponse.setDiscription("Email already exist");
		}
		return eResponse;
	}

	@GetMapping(path = "/searchproduct", produces = MediaType.APPLICATION_JSON_VALUE)
	public RetailerResponse searchProduct(@RequestParam int pid) {
		List<ProductInfoBean> productBean = services.searchProduct(pid);
		RetailerResponse eResponse = new RetailerResponse();
		if (productBean == null) {
			eResponse.setStatusCode(401);
			eResponse.setMessage("Failure");
			eResponse.setDiscription("Product not found");
		} else {
			eResponse.setStatusCode(200);
			eResponse.setMessage("success");
			eResponse.setDiscription("Product found with given key");
			// THIS CODE WILL REDULT IN CREATING LIST
			eResponse.setProductBeans(productBean);
		}
		return eResponse;
	}

	@PostMapping(path = "/addproduct", produces = MediaType.APPLICATION_JSON_VALUE)
	public RetailerResponse addProductInfo(@RequestBody ProductInfoBean pBean) {
		RetailerResponse eResponse = new RetailerResponse();

		if (services.addProductInfo(pBean)) {
			eResponse.setStatusCode(200);
			eResponse.setMessage("success");
			eResponse.setDiscription("Product Added");
		} else {
			eResponse.setStatusCode(401);
			eResponse.setMessage("Failure");
			eResponse.setDiscription("Product Details already exist");
		}
		return eResponse;
	}

	@PutMapping(path = "/changepassword", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public RetailerResponse updateUserPassword(@RequestBody UserInfoBean uBean) {
		RetailerResponse eResponse = new RetailerResponse();
		if (services.updateUserPassword(uBean.getUid(), uBean.getPassword())) {
			eResponse.setStatusCode(200);
			eResponse.setMessage("changed");
			eResponse.setDiscription("User password changed");
		} else {
			eResponse.setStatusCode(401);
			eResponse.setMessage("Failed");
			eResponse.setDiscription("Problem in changing password");
		}
		return eResponse;
	}

	@GetMapping(path = "/getorders", produces = MediaType.APPLICATION_JSON_VALUE)
	public RetailerResponse getOrders(@RequestParam int userid) {
		RetailerResponse response = new RetailerResponse();
		List<OrderInfoBean> ordersBeans = services.getOrders(userid);
		if (ordersBeans.size() != 0) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDiscription("Data Found For Orders");
			response.setOrdersBeans(ordersBeans);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDiscription("No data For Orders");
		}
		return response;

	}

}
