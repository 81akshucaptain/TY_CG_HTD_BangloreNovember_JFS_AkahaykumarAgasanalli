package com.interview.hotelmanagementboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class HomeController {
	@GetMapping("/login")
	public String login() {
		return "login page";
	}

	@GetMapping("/register")
	public String register() {
		return "register page";
	}

	@GetMapping("/home")
	public String home() {
		return "home page";
	}
}