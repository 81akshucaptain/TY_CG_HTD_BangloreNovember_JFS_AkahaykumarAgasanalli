<%@page import="com.capgemini.mywebapp.bean.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false"%>
<%String msg=(String) request.getAttribute("msg"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete jsp</title>
</head>
<body>
<fieldset>
		<legend>DELETE EMLPOYEE</legend>
<!-- 		sction is mothing but url, so create deleteEMpServlet class -->
		<form action="./deleteEmployee2" method="get">
			EMPLOYEEid: <input type="number" name="empId" required> <br>
			<input type="submit" value="delete">
		</form>
	</fieldset>
	<%
		if (msg != null && !msg.isEmpty()) {
	%>
	<h3 style='color: red'><%=msg %></h3>
	<% } else { %>
	<h3 style='color: red'>NOt found the Employee</h3>
	<%} %>
</body>
</html>