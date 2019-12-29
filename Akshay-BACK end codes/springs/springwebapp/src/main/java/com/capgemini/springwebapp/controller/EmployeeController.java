package com.capgemini.springwebapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.capgemini.springwebapp.beans.EmployeeBean;
import com.capgemini.springwebapp.services.EmployeeServices;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeServices services;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public String login(String email,String password,
			ModelMap map,HttpServletRequest request) {
		EmployeeBean eBean=services.auth(email, password);
		if(eBean==null) {
			map.addAttribute("msg","invalid Credentials");
			return "login";
		}
		HttpSession session=request.getSession();
		session.setAttribute("eBean", eBean);
		return "home";
	}

	@GetMapping("/registerform")
	public String register( ) {
		return "registerform";
	}
	@PostMapping
	public String register(EmployeeBean ebBean,ModelMap map) {
		boolean check=services.addEmployee(ebBean);

		if(check) {
			map.addAttribute("msg","you have registered to the eployee system");
		}else {
			map.addAttribute("msg","This email is already exist");
		}
		return "login";
	}
	@GetMapping("/search")
	public String search(@RequestParam("key")String key,ModelMap map,
			@SessionAttribute(name="eBean",required=false)EmployeeBean bean) {
		if(bean!=null) {
			List<EmployeeBean>	emplist=services.getEmployees(key);
			map.addAttribute("emplist",emplist);
			return "home";
		}else {
			return "login";
		}

	}

	@GetMapping("/home")
	//alog with validating the session
	public String home(@SessionAttribute(name="bean", required=false)EmployeeBean bean) {
		return "home";
	}

	@GetMapping("/changepassword")
	public String changePassword() {
		return "changepassword";
	}
	
	//along with validating the session
	@PostMapping("/changepassword")
	public String  changePassword(String password,
			@SessionAttribute("eBean")EmployeeBean bean) {

		services.changePassword(bean.getId(), password);
		return "home";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
}












