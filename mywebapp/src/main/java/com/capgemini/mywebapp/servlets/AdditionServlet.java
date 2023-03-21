package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdditionServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int n1 = Integer.parseInt(req.getParameter("FirstNumber"));
		int n2 = Integer.parseInt(req.getParameter("SecondNumber"));
		int res = n1 + n2;
		PrintWriter out = resp.getWriter();
		out.println("The sum of TWo numbers: " + res);

	}
}
