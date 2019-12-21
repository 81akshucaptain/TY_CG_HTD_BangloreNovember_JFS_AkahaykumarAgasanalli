package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/createCookie")
public class CreateCookiesServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Cookie myCookie=new Cookie("empName", "akshay");
		myCookie.setMaxAge(7*24*60*60);
		resp.addCookie(myCookie);
		PrintWriter out=resp.getWriter();
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("./cokkies.html");
		dispatcher.include(req, resp);
		
		resp.setContentType("text/html");
		out.print("<html>");
		out.print("<body>");
		out.print("<h2>cookie created succesfuly..!</h2> ");
		out.print("</body>");
		out.print("</html>");

	}
}
