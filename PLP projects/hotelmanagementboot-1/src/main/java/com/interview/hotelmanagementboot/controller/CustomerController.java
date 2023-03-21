package com.interview.hotelmanagementboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.hotelmanagementboot.dto.CustomerBean;
import com.interview.hotelmanagementboot.dto.HotelManagementResponseBodyBean;
import com.interview.hotelmanagementboot.dto.User;
import com.interview.hotelmanagementboot.service.CustomerServices;

/* Spring RestController takes care of mapping request data to the 
 * defined request handler method. Once response body is generated from 
 * the handler method, it converts it to JSON or XML response*/
@RestController // Combination of @Controller and @ResponseBody

/*
 * REST stands for representational state transfer. It is a set of constraints
 * that set out how an API (application programming interface) should work. If
 * an API is RESTful, that simply means that the API adheres to the REST
 * architecture. Put simply, there are no differences between REST and RESTful
 * as far as APIs are concerned. REST is the set of constraints. RESTful refers
 * to an API adhering to those constraints. It can be used in web services,
 * applications, and software.
 * 
 * REST Constraints 1.CLIENT-SERVER: Who is calling whos sending request must
 * set these boundaries 2.STATE LESS: server would not store anything related to
 * the session. In REST, the client must include all information for the server
 * to fulfill the request whether as a part of query params, headers or URI.
 * Statelessness enables greater availability since the server does not have to
 * maintain, update or communicate that session state. 3.UNIFORM INTERFACE: Must
 * use HTTP verb's GET,POST,DELETE and PUT uri's (Uniform resource identifier)
 * 4. CASHEABLE : Clients needs to be cash the representation, bcz of
 * statelessness (every representation is self descriptive) Hence cashing is
 * possible in RestFul API.
 */
@CrossOrigin(origins = "", allowedHeaders = "", allowCredentials = "true")
/*
 * Cross-Origin Resource Sharing (CORS) is a security concept that allows
 * restricting the resources implemented in web browsers. It prevents the
 * JavaScript code producing or consuming the requests against different origin.
 */
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	/*
	 * Marks a constructor, field, setter method, or config method as to be
	 * autowired bySpring's dependency injection facilities
	 */
	CustomerServices customerService;

	/*
	 * @PostMapping annotation maps HTTP POST requests onto specific handler
	 * methods. It is a composed annotation that acts as a shortcut
	 * for @RequestMapping(method = RequestMethod.POST).
	 */
	@PostMapping(path = "/add.customer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public HotelManagementResponseBodyBean addCustomer(@RequestBody CustomerBean customer) {
		/*
		 * Annotation indicating a method parameter should be bound to the body of the
		 * web request.The body of the request is passed through an HTTPMESSAGECONVERTER
		 * to resolve the method argument depending on the content type of the request.
		 * Optionally, automatic validation can be applied by annotating the argument
		 * with @Valid.
		 */

		// HTTP RESPONSE CODES
		/*
		 * Succesfull respose : 200-OK , 201-Resource created Client error responses:
		 * 400 Bad Request, 401 Unauthorized,402 Payment Required ,403 Forbidden 404 Not
		 * Found, 405 Method Not Allowed. Server error responses: 500 Internal Server
		 * Error, 502 Bad Gateway,503 Service Unavailable 504 Gateway Timeout
		 * 
		 */
		HotelManagementResponseBodyBean customersResponse = new HotelManagementResponseBodyBean();
		if (customerService.createCustomer(customer)) {
			customersResponse.setStatusCode(400);
			customersResponse.setMessage("Success");

			customersResponse.setDescription("Customer Added Successfuly");
		} else {
			customersResponse.setStatusCode(401);
			customersResponse.setMessage("Failure");
			customersResponse.setDescription("Failed to Add Customer,Customer May Exist..!");

		}

		return customersResponse;
	}

	@DeleteMapping(path = "/delete.customer/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public HotelManagementResponseBodyBean deleteCustomer(@PathVariable("id") int id) {
		/*
		 * Annotation which indicates that a method parameter should be bound to a URI
		 * template variable.
		 */
		HotelManagementResponseBodyBean customersResponse = new HotelManagementResponseBodyBean();
		if (customerService.deleteCusromer(id)) {
			customersResponse.setStatusCode(200);
			customersResponse.setMessage("Success");
			customersResponse.setDescription("Customer Deleted Successfuly");
		} else {
			customersResponse.setStatusCode(401);
			customersResponse.setMessage("Failure");
			customersResponse.setDescription("Failed to delete Customer,Customer May not  Exist..!");

		}
		return customersResponse;
	}

	/*
	 * GetMapping we can apply only on method level and RequestMapping annotation we
	 * can apply on class level and as well as on method level
	 */
	//@PreAuthorize("hasRole('NORMAL')")
	@GetMapping(path = "/get.all.customers")
	public HotelManagementResponseBodyBean searchCustomer() {
		HotelManagementResponseBodyBean customersResponse = new HotelManagementResponseBodyBean();
		List<CustomerBean> customers = customerService.getAllCustomers();
		if (customers != null) {
			customersResponse.setStatusCode(400);
			customersResponse.setMessage("Success");
			customersResponse.setDescription("Customer Found Successfuly");
			customersResponse.setCustomer(customers);
		} else {
			customersResponse.setStatusCode(401);
			customersResponse.setMessage("Failure");
			customersResponse.setDescription("Failed to find Customers,Customers May not  Exist..!");

		}
		return customersResponse;
	}

	@PutMapping(path = "/update.customer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HotelManagementResponseBodyBean updateCustomer(@RequestBody CustomerBean customerToUpdate) {
		HotelManagementResponseBodyBean customersResponse = new HotelManagementResponseBodyBean();
		if (customerService.updateCustomer(customerToUpdate)) {
			customersResponse.setStatusCode(400);
			customersResponse.setMessage("Success");
			customersResponse.setDescription("Customer Updated Successfuly");
		} else {
			customersResponse.setStatusCode(401);
			customersResponse.setMessage("Failure");
			customersResponse.setDescription("Failed to Update Customer,Customer May not  Exist..!");

		}
		return customersResponse;
	}

	@PostMapping(path = "/createAccount", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public HotelManagementResponseBodyBean createAccount(@RequestBody User loginBean) {
		HotelManagementResponseBodyBean creatResponse = new HotelManagementResponseBodyBean();
		if (customerService.createAccount(loginBean)) {
			creatResponse.setStatusCode(400);
			creatResponse.setMessage("Success");
			creatResponse.setDescription("Customer created Successfull");
		} else {
			creatResponse.setStatusCode(401);
			creatResponse.setMessage("failure");
			creatResponse.setDescription("Customer creation failed");
		}
		return creatResponse;
	}

	@PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public HotelManagementResponseBodyBean login(@RequestBody User loginBean) {
		HotelManagementResponseBodyBean loginResponse = new HotelManagementResponseBodyBean();
		if (customerService.login(loginBean)) {
			loginResponse.setStatusCode(400);
			loginResponse.setMessage("Success");
			loginResponse.setDescription("Customer Login Successfull");
		} else {
			loginResponse.setStatusCode(401);
			loginResponse.setMessage("failure");
			loginResponse.setDescription("Customer Login failed");
		}
		return loginResponse;
	}
}
