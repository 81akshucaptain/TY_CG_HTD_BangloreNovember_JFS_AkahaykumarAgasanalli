<%@page import="com.capgemini.mywebapp.bean.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false" %>
    <% HttpSession session=request.getSession(); %>
    <%EmployeeBean empbean=(EmployeeBean)session.getAttribute("empbean"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3 style='color:navy'>WelCome<% empbean.getName();%></h3>
<a href="./addEmpJsp">Add employee</a><br>
<a href="./updateEmpJsp">Update employee</a><br>
<a href="./deleteEmpJsp">Delete employee</a><br>
<a href="./searchEmpFormJsp">Search employee</a><br>
<a href="./seeAllEmoloyees">See all employee</a><br>
<br>
<a href="./logout">Logout</a>
</body>
</html>