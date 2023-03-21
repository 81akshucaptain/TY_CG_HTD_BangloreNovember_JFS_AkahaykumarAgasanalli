package com.interview.hotelmanagementboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormLoginControllerTEST {

	@GetMapping("/signin")
	public String signin() {
		return "login.html";
	}
}
