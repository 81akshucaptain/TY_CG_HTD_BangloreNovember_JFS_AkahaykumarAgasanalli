package com.capgemini.mywebapp.servlet.jsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session=req.getSession();
		if(session!=null) {
			session.invalidate();
			req.setAttribute("msg", "SuccessFully LogedOut..!Thank you for the visit");
		}else {
			req.setAttribute("msg", "You are Not Logged_IN..!");
		}
		req.getRequestDispatcher("./loginForm").forward(req, resp);
	}
}
