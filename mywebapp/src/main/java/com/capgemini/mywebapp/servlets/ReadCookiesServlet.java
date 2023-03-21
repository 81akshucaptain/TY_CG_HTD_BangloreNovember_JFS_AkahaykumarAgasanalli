package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/readCookie")
public class ReadCookiesServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//TO gey the cookie
		Cookie[] cookies=req.getCookies();

		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();

		req.getRequestDispatcher("./cokkies.html").include(req, resp);
		out.print("<html> ");
		out.print("<body> ");
		if(cookies!=null) {
		
		for (Cookie cookie : cookies) {
			out.print("\n cokie name \n  :"+cookie.getName());
			out.print("\n cookie value :"+cookie.getValue());
		}
		}else {
			out.print("<h2>cookies not found</h2>");
		}
		out.print("</body> ");
		out.print("</html> ");
	}

}

