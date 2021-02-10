package com.tcs.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWordController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloword-showform";
	}

	/*
	 * @RequestMapping("/processForm") public String processForm() { return
	 * "helloWord-showform"; }
	 */

	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {

		String s_name = request.getParameter("studentName");

		s_name = s_name.toUpperCase();

		String result = "YO YO!  " + s_name+" lets GO again to Ankita";

		model.addAttribute("message", result);

		return "helloWord";
	}

}
