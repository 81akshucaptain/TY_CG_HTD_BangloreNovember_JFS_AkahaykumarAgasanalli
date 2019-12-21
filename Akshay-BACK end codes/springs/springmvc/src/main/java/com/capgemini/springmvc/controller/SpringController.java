package com.capgemini.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgmini.springmvc.beans.User;

@Controller
public class SpringController {
	@RequestMapping("/hello")
	public String hello(ModelMap map) {
		map.addAttribute("msg","helloo world...!");
		return "index";
	}
	//@RequestMapping(path = "/query",method = RequestMethod.GET)//SOOO LENGHTY RIGHT
	@GetMapping("/query")//so GO FRO THIS
	public String query(@RequestParam(name ="name",required= false,defaultValue= "jack" )String name,
			@RequestParam(name = "age") int age,ModelMap map) {
		map.addAttribute("name",name);
		map.addAttribute("age",age);
		return "query";
	}
	
	@GetMapping("/form")
	public String from()  {
		return "form";
	}
//	@PostMapping("/form")
//	public String form(String name,String email,String gender,String password,ModelMap map) {
//		map.addAttribute("name",name);
//		map.addAttribute("email",email);
//		map.addAttribute("gender",gender);
//		map.addAttribute("password",password);
//		return "form";
//}
	@PostMapping("/form")
	public String form(User user,ModelMap map) {
		map.addAttribute("name",user.getName());
		map.addAttribute("email",user.getEmail());
		map.addAttribute("gender",user.getGender());
		map.addAttribute("password",user.getPassword());
		return "form";
	}
}
