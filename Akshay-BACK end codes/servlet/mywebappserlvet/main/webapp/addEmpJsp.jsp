<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%
	String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4>
		<a href="./home"> Home</a>
	</h4>
	<fieldset>
		<legend>ADD THE EMPLOYEE</legend>

		<form action="./addEmployee2" method="post">
			<table>
				<tr>

					<td>EMPLOYEE-ID:</td>
					<td>:</td>
					<td><input type="number" name="empId"></td>
				</tr>

				<tr>
					<td>EMPLOYEE-NAME</td>
					<td>:</td>
					<td><input type="text" name="name"></td>
				</tr>

				<tr>
					<td>EMPLOYEE-SALARY</td>
					<td>:</td>
					<td><input type="number" name="salary"></td>
				</tr>

				<tr>
					<td>EMPLOYEE-AGE</td>
					<td>:</td>
					<td><input type="number" name="age"></td>
				</tr>
				<tr>
					<td>EMPLOYEE-PASSWORD</td>
					<td>:</td>
					<td><input type="text" name="password"></td>
				</tr>
				<tr>
					<td>EMPLOYEE-DESIGANTION</td>
					<td>:</td>
					<td><input type="text" name="designation"></td>
				</tr>
				<tr>
					<td colspan="3" align="center"><br> <input type="submit"
						value="addEmployee"></td>
				</tr>
			</table>
		</form>
	</fieldset>
	<% if(msg!=null && !msg.isEmpty()){ %>
	<h3 style='color:navy'><%=msg %></h3>
	<%} %>

</body>
</html>