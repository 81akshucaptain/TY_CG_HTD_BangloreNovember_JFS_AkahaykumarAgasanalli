package com.capgemini.mywebapp.servlets;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.mywebapp.bean.EmployeeBean;
import com.capgemini.mywebapp.services.EmployeeService;
import com.capgemini.mywebapp.services.EmployeeServiceImpl;

/*The javax.servlet package contains many interfaces and classes
 that are used by the servlet or web container. These are not specific to any protocol.
The javax.servlet.http package contains interfaces 
and classes that are responsible for http requests only.
*/
@WebServlet("/login2")
public class LoginServlet extends HttpServlet {
	private EmployeeService empservice = new EmployeeServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String empIdVal = req.getParameter("empId");
		String passwpord = req.getParameter("password");
		int emp_id = Integer.parseInt(empIdVal);
		EmployeeBean empbean = empservice.authenticate(emp_id, passwpord);
//PrintWriter:This class implements all the print methods found in stream
		PrintWriter out = resp.getWriter();
		/*
		 * getWriter() returns PrintWritter Obj that can send characters text to the
		 * clients.
		 */
		out.print("<html>");
		out.print("<body>");

		if (empbean != null) {
			// valid credentials
			HttpSession session = req.getSession(true);
			/*
			 * getSession(): will return the current HttpSession related, else if create
			 * parameter is true then a new session will be created,else null returns
			 */
			// to add user details to the sessions
			session.setAttribute("EmployeeBean", empbean);
			//display the obj
			out.print("<h2 style='color:blue'> welcome" + empbean.getName() + "!</h2>");
			out.print("<br> <a href='./addEmp.html'> Add employee</a>");
			out.print("<br> <a href='#'> update employee</a>");
			out.print("<br> <a href='./deleteEmp.html'> delete employee</a>");
			out.print("<br> <a href='./searchEmpfile.html'> search employee</a>");
			out.print("<br> <a href='#'> see all employees</a>");
			out.print("<br> <a href='./Logout'> Logout</a>");
		} else {
			// invalid sessions
			out.print("<h3 style='color:red'>invalid Credentials</h3>");
			req.getRequestDispatcher("./loginPage.html").include(req, resp);

		}
		out.print("</body>");
		out.print("</html>");

	}// end of do post
}// end of class
